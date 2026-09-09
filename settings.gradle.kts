plugins {
    // Вставляем плагин именно сюда!
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "simple_entry_back"
include("contractor-module")