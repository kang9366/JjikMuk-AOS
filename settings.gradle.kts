pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven{ url = uri("https://jitpack.io") }
        //KakaoSDK repository
        maven { url = uri("https://devrepo.kakao.com/nexus/content/groups/public/")}
    }
}

rootProject.name = "JjikMuk"
include(":app")
 