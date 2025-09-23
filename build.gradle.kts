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

// ✅ Definicja wersji w Kotlin DSL
val springVersion = "6.1.13"
val lombokVersion = "1.18.34"
val junitVersion = "5.8.2"

dependencies {
	// Spring Core
	implementation("org.springframework:spring-core:$springVersion")
	implementation("org.springframework:spring-beans:$springVersion")
	implementation("org.springframework:spring-context:$springVersion")
	implementation("org.springframework:spring-context-support:$springVersion")
	implementation("org.springframework:spring-expression:$springVersion")

	// Logowanie
	implementation("ch.qos.logback:logback-classic:1.2.11")

	// Lombok
	compileOnly("org.projectlombok:lombok:$lombokVersion")
	annotationProcessor("org.projectlombok:lombok:$lombokVersion")

	// Testy
	testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
}

tasks.test {
	useJUnitPlatform()
	jvmArgs("-XX:+EnableDynamicAgentLoading")
	testLogging {
		showStandardStreams = false // nie wyświetla ostrzeżeń JVM
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
