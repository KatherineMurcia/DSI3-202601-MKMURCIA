plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.dsi3"
version = "0.0.1-SNAPSHOT"

extra["lombok.version"] = "1.18.38"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

tasks.withType<JavaCompile>().configureEach {
	options.release = 17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.hibernate.orm:hibernate-community-dialects")
	runtimeOnly("org.xerial:sqlite-jdbc:3.46.1.3")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

springBoot {
	mainClass = "com.dsi3.api.ApiApplication"
}

tasks.named<Test>("test") {
	useJUnitPlatform()
}
