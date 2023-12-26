plugins {
    id("com.android.application")
}


android {
    namespace = "com.example.measurementapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.measurementapplication"
        minSdk = 30
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(files("libs/lunar-1.3.9.jar"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.jakewharton:butterknife:10.2.1")
    annotationProcessor ("com.jakewharton:butterknife-compiler:10.2.1")
//    implementation ("com.github.gzu-liyujiang.AndroidPicker:WheelPicker:<version>")
//    implementation ("com.github.gzu-liyujiang.AndroidPicker:CalendarPicker:<version>")
    implementation ("com.github.ycuwq:DatePicker:1.3.4")



}