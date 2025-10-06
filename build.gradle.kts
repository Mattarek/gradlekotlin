plugins {
	java
	jacoco
}

group = "pl.zajavka"
version = "1.0.0"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

repositories {
	mavenCentral()
}

// ✅ Wersje dependencies
val springVersion = "6.2.11"
val lombokVersion = "1.18.34"
val junitVersion = "5.11.2"
val mockitoVersion = "5.14.2"
val logbackVersion = "1.2.11"
val postgresqlDriverVersion = "42.5.0"

dependencies {
	// Spring Core
	implementation("org.springframework:spring-core:$springVersion")
	implementation("org.springframework:spring-beans:$springVersion")
	implementation("org.springframework:spring-context:$springVersion")
	implementation("org.springframework:spring-context-support:$springVersion")
	implementation("org.springframework:spring-expression:$springVersion")
	implementation("org.springframework:spring-jdbc:${springVersion}")

	implementation("org.postgresql:postgresql:${postgresqlDriverVersion}")

	// Spring Test (tu jest SpringExtension)
	testImplementation("org.springframework:spring-test:$springVersion")

	// Logowanie
	implementation("ch.qos.logback:logback-classic:$logbackVersion")

	// Lombok
	compileOnly("org.projectlombok:lombok:$lombokVersion")
	annotationProcessor("org.projectlombok:lombok:$lombokVersion")

	// JUnit 5
	testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")

	// Mockito
	testImplementation("org.mockito:mockito-core:$mockitoVersion")
	testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

tasks.test {
	useJUnitPlatform()
	jvmArgs("-XX:+EnableDynamicAgentLoading")
	testLogging {
		showStandardStreams = false
		events("passed", "skipped", "failed")
	}
}

jacoco {
	toolVersion = "0.8.12"
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
	reports {
		xml.required.set(true)
		csv.required.set(false)
		html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
	}
}

tasks.jacocoTestCoverageVerification {
	dependsOn(tasks.test)
	violationRules {
		rule {
			element = "CLASS"
			limit {
				counter = "LINE"
				value = "COVEREDRATIO"
				minimum = "0.2".toBigDecimal()
			}
		}
	}
}

tasks.check {
	dependsOn(tasks.jacocoTestCoverageVerification)
}
