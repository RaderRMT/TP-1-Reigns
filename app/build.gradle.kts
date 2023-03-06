plugins {
    application

    id("com.github.johnrengelman.shadow") version "7.0.0"
}

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
}

application {
    mainClass.set("redder.reigns.Reigns")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "redder.reigns.Reigns"
    }

    archiveFileName.set("${rootProject.name}.jar")
}
