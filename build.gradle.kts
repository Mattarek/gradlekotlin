plugins {
	id("java")
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
	implementation("org.slf4j:slf4j-api:1.7.25")
	// implementation("org.slf4j:slf4j-simple:1.7.25")

	implementation("org.slf4j:slf4j-api:2.0.16")
	implementation("ch.qos.logback:logback-classic:1.5.6")

	// JUnit 5
	testImplementation("org.junit.jupiter:junit-jupiter:5.11.0")

}

tasks.test {
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
	}
}
