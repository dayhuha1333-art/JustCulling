pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://repo.essential.gg/repository/maven-public/")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net/")
        maven("https://repo.spongepowered.org/maven/")
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "gg.essential.loom" -> useModule("gg.essential:architectury-loom:${requested.version}")
            }
        }
    }
}

rootProject.name = "JustCulling"
