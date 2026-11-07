plugins {
    java
    id("gg.essential.loom") version "0.10.0.+"
    id("dev.architectury.architectury-pack200") version "0.1.3"
}

group = "com.example.justculling"
version = "1.0"
base.archivesName.set("justculling")

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

loom {
    forge {
        pack200Provider.set(dev.architectury.pack200.java.Pack200Adapter())
    }
    mappings("snapshot", "20151216")
}

repositories {
    mavenCentral()
    maven("https://repo.essential.gg/repository/maven-public/")
    maven("https://repo.spongepowered.org/repository/maven-public/")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.named("remapJar") {
    archiveBaseName.set("justculling")
    archiveClassifier.set("")
}

tasks.register("printLoomInfo") {
    doLast {
        println("Minecraft version: " + loom.minecraftVersion)
        println("Mappings: " + loom.mappings)
    }
}
