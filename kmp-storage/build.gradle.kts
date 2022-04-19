import java.util.Properties
import java.io.FileInputStream

plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("maven-publish")
    id("org.jetbrains.dokka")
}

group = "com.wakaztahir"

kotlin {
    android {
        publishLibraryVariants("release")
    }
    jvm("desktop")
    sourceSets {
        named("commonMain") {
            dependencies {

            }
        }
        named("androidMain") {
            dependencies {

            }
        }
    }
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res")
        }
    }
}

val githubProperties = Properties()
kotlin.runCatching { githubProperties.load(FileInputStream(rootProject.file("github.properties"))) }

configure<PublishingExtension> {
    publications {
        all {
            this as MavenPublication

            pom {
                this.name.set("Library for Compose Multiplatform")
                licenses {
                    license {
                        this.name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            setUrl(findProperty("publish.url")?.toString().orEmpty())
            credentials {
                username = findProperty("publish.username")?.toString().orEmpty()
                password = findProperty("publish.password")?.toString().orEmpty()
            }
        }
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/codeckle/kmp-storage")
            runCatching {
                credentials {
                    /**Create github.properties in root project folder file with gpr.usr=GITHUB_USER_ID  & gpr.key=PERSONAL_ACCESS_TOKEN**/
                    username = (githubProperties["gpr.usr"] ?: System.getenv("GPR_USER")).toString()
                    password = (githubProperties["gpr.key"] ?: System.getenv("GPR_API_KEY")).toString()
                }
            }.onFailure { it.printStackTrace() }
        }
    }
}