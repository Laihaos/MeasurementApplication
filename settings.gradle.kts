//pluginManagement {
//    repositories {
//        google()
//        mavenCentral()
//        gradlePluginPortal()
//        maven { url=uri("https://jitpack.io") }
//    }
//}

pluginManagement {
    repositories {
        maven { url=uri("https://jitpack.io") }
        maven { url=uri("https://maven.aliyun.com/repository/releases")}
//        maven { url 'https://maven.aliyun.com/repository/jcenter' }
        maven { url=uri("https://maven.aliyun.com/repository/google") }
        maven { url=uri("https://maven.aliyun.com/repository/central") }
        maven { url=uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url=uri("https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven { url=uri("https://jitpack.io") }
        maven { url=uri("https://maven.aliyun.com/repository/releases") }
//        maven { url 'https://maven.aliyun.com/repository/jcenter' }
        maven { url=uri("https://maven.aliyun.com/repository/google") }
        maven { url=uri("https://maven.aliyun.com/repository/central") }
        maven { url=uri("https://maven.aliyun.com/repository/gradle-plugin") }
        maven { url=uri("https://maven.aliyun.com/repository/public") }
        google()
        mavenCentral()
    }
}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//        maven { url=uri("https://jitpack.io") }
//
//    }
//}

rootProject.name = "MeasurementApplication"
include(":app")

//distributionUrl=https://mirrors.cloud.tencent.com/gradle//gradle-5.6.4-all.zip

