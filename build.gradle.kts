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

	// Do testów z Lombokiem też można dodać:
	testCompileOnly("org.projectlombok:lombok:1.18.34")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.34")

	implementation("org.slf4j:slf4j-api:1.7.25")
//	implementation("org.slf4j:slf4j-simple:1.7.25")

	implementation("org.slf4j:slf4j-api:2.0.16")
	implementation("ch.qos.logback:logback-classic:1.5.6")
}


