plugins {
    kotlin("jvm") version "1.4.10"
    //id("kotlinx.benchmark") version "0.2.0-dev-20"
}

group = "shreckye"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("script-runtime"))

    //implementation("org.jetbrains.kotlinx:kotlinx.benchmark.runtime-jvm:0.2.0-dev-20")
}
