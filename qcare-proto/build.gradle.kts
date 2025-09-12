plugins {
    java
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {}


group = "xyz.firestige.qcare"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}
