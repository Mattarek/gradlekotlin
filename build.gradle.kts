plugins {
	id("java")
	id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	// Lombok
	compileOnly("org.projectlombok:lombok:1.18.34")
	annotationProcessor("org.projectlombok:lombok:1.18.34")

	testCompileOnly("org.projectlombok:lombok:1.18.34")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.34")

	// SLF4J + Logback
	implementation("org.slf4j:slf4j-api:2.0.16")
	implementation("ch.qos.logback:logback-classic:1.5.13")

	// JUnit 5
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
	useJUnitPlatform() // jawnie mówimy, że testujemy JUnit 5
	finalizedBy(tasks.jacocoTestReport)
}

// konfiguracja raportów JaCoCo
tasks.jacocoTestReport {
	dependsOn(tasks.test) // raporty generujemy po uruchomieniu testów

	reports {
		html.required.set(true)
		xml.required.set(true)
		csv.required.set(false)
	}
}

tasks.jacocoTestCoverageVerification {
	dependsOn(tasks.test) // najpierw uruchamiamy testy

	violationRules {
		rule {
			limit {
				// minimalne pokrycie linii
				counter = "LINE"
				value = "COVEREDCOUNT"
				minimum = 0.5.toBigDecimal() // 50%
			}
		}
	}
}

tasks.check {
	dependsOn(tasks.jacocoTestCoverageVerification)
}