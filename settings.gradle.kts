rootProject.name = "FakeBookMVP"
include(":app")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
includeBuild("includedBuilds/build-jacoco")
include(":modules:extensions")
include(":modules:network")
include(":modules:testing")
