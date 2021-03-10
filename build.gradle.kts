import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    application
}

group = "me.cyberdie22"
version = "2021.1-EAP"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:30.1-jre")
    testImplementation(kotlin("test-junit"))
}

tasks.withType<ShadowJar>() {
    minimize()
    archiveClassifier.set("")
    manifest {
        attributes["Implementation-Name"] = "6502 Emulator"
        attributes["Implementation-Version"] = archiveVersion
        attributes["Main-Class"] = "MainKt"
    }
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

application {
    mainClassName = "MainKt"
}