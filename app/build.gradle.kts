

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }



    buildTypes {
        getByName("debug") {
            buildConfigField("String", "GITHUB_USER_NAME", "\"${System.getenv("GITHUB_USER_NAME") ?: "<not-set>"}\"")
            buildConfigField("String", "GITHUB_USER_PASSWORD", "\"${System.getenv("GITHUB_USER_PASSWORD") ?: "<not-set>"}\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")

    implementation ("com.google.android.material:material:1.11.0")

    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")

    implementation ("com.github.moxy-community:moxy:2.2.2")
    implementation ("com.github.moxy-community:moxy-ktx:2.2.2")
    implementation ("com.github.moxy-community:moxy-androidx:2.2.2")

    implementation ("io.reactivex.rxjava3:rxjava:3.0.0")
    implementation ("io.reactivex.rxjava3:rxkotlin:3.0.0")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")

    implementation ("com.github.terrakok:cicerone:7.1")
    implementation ("com.github.kirich1409:viewbindingpropertydelegate:1.4.7")
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation ("com.github.bumptech.glide:okhttp3-integration:4.12.0@aar")

    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")

    kapt ("com.github.moxy-community:moxy-compiler:2.2.2")
    kapt ("com.github.bumptech.glide:compiler:4.12.0")
    kapt ("androidx.room:room-compiler:2.6.1")

    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.room:room-rxjava3:2.6.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}