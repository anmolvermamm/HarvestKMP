pluginManagement {
  repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
  }
}

rootProject.name = "HarvestKMP"
include(":androidApp")
include(":shared")
include(":watchApp")
include(":wearOS")
include(":webApp")
include(":compose-desktop")