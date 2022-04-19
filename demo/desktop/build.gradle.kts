import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm("desktop")
    sourceSets {
        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation(project(":kmp-storage"))
            }
        }
    }
}

compose.desktop {
    application {
        mainClass = "com.mylibrary.demo.MainKt"
    }
}
