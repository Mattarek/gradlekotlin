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

dependencies {
	// Logowanie
	implementation("ch.qos.logback:logback-classic:1.2.11")

	// Lombok
	compileOnly("org.projectlombok:lombok:1.18.34")
	annotationProcessor("org.projectlombok:lombok:1.18.34")

	// Testy
	testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
	testImplementation("org.mockito:mockito-core:5.3.1")
	testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
	testCompileOnly("org.projectlombok:lombok:1.18.34")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.34")
}

tasks.test {
	useJUnitPlatform()
	jvmArgs("-XX:+EnableDynamicAgentLoading")
	testLogging {
		showStandardStreams = false  // nie wyświetla ostrzeżeń JVM
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
				minimum = 0.2.toBigDecimal()
			}
		}
	}
}

tasks.check {
	dependsOn(tasks.jacocoTestCoverageVerification)
}
