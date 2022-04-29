import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.7"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
	id ("com.github.hierynomus.license") version "0.16.1"
}

group = "org.nagarro"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

configurations.all {
	exclude (group="org.springframework.boot", module="spring-boot-starter-tomcat")
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
		implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-jetty")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation ("org.flywaydb:flyway-core")
	runtimeOnly("org.postgresql:postgresql")
	implementation (group= "org.slf4j", name= "slf4j-api", version= "1.7.36")
	implementation (group= "ch.qos.logback", name= "logback-core", version= "1.2.11")
	implementation (group= "ch.qos.logback", name= "logback-classic", version= "1.2.11")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

license {
	header = rootProject.file("HEADER")
	strictCheck = false
	useDefaultMappings = true
	mapping ("kt" , "SLASHSTAR_STYLE")
//	mapping("sql","DOUBLEDASHES_STYLE")
	exclude("*.yml")
	exclude("logback.xml")

}