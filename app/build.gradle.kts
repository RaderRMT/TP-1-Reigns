plugins {
    application
}

java {
    withSourcesJar()
    withJavadocJar()
}

repositories {
    mavenCentral()
}

dependencies {
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
