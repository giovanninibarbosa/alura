plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "br.com.alura.technews"
        minSdkVersion(19)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))

    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.lifecycle:lifecycle-extensions:2.0.0")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.2")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")

    implementation("junit:junit:4.12")
    implementation("androidx.test.ext:junit:1.1.0")


    implementation("androidx.test.espresso:espresso-core:3.1.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("androidx.recyclerview:recyclerview:1.0.0")
    implementation("com.google.android.material:material:1.0.0")

    // Https: Connection - Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")

    // Https: Log Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:3.14.1")

    // DI : Koin
    implementation("org.koin:koin-android:2.0.0-rc-2")
    implementation("org.koin:koin-android-viewmodel:2.0.0-rc-2")

    kapt("androidx.room:room-compiler:2.4.3")

}
