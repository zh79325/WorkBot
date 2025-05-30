//import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-android-extensions")
}
object versions {
    const val appVersionCode=643
    const val appVersionName= "6.4.3"
    const val devVersionCode= 643
    const val devVersionName= "6.4.3"
    const val target= 26
    const val mini= 21
    const val compile= 32
    const val buildTool= "36.0.0"
    const val IDE= "Android Studio Bumblebee | 2021.1.1"
    const val JDK= "15"
}
android { 

    buildToolsVersion = versions.buildTool
    compileSdk = versions.compile

    defaultConfig {
        minSdk = versions.mini
        targetSdk = versions.target
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }
    lint.abortOnError = false

    sourceSets {
        getByName("main") {
            res.srcDirs("src/main/res","src/main/res-i18n")
        }
    }
}

dependencies {
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1-alpha01") {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    testImplementation("junit:junit:4.13.2")
//    api(kotlin("stdlib", KotlinCompilerVersion.VERSION))
    api("androidx.annotation:annotation:1.4.0")
    api("com.github.hyb1996:settingscompat:1.1.5")
    implementation("androidx.activity:activity-ktx:1.5.1")
    api(kotlin("reflect", version = "1.7.10"))
}
