plugins {
    id("java")
    // Плагин Spring Boot (управляет сборкой, запуском bootRun и созданием fat-jar)
    id("org.springframework.boot") version "3.3.3"

    // Плагин управления зависимостями (автоматически определяет версии для starter-библиотек)
    id("io.spring.dependency-management") version "1.1.6"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Строго фиксируем 21 (или 17)
    }
}

// Указываем плагину точное имя нашего главного класса
springBoot {
    mainClass.set("org.example.Main")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // Стартер для создания Web-приложений (REST API, MVC, встроенный Tomcat)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Стартер для тестирования (JUnit 5, Mockito, AssertJ)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    // Обязательно для работы тестов на JUnit 5
    useJUnitPlatform()
}