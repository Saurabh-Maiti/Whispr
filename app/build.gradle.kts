plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.whispr"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.whispr"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)  // Keep this, remove the duplicate
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore)  // This resolves to the correct version via the Firebase BOM
    implementation(libs.androidx.credentials)
    implementation(libs.androidx.credentials.play.services.auth)
    implementation(libs.googleid)

    // Test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debug dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Compose Dependencies
    implementation("androidx.compose.ui:ui:1.4.0") // or latest version
    implementation("androidx.compose.material3:material3:1.0.0") // or latest version
    implementation("androidx.compose.foundation:foundation:1.4.0") // or latest version

    // Navigation Dependency
    val nav_version = "2.8.9"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Observe as state dependency
    implementation("androidx.compose.runtime:runtime-livedata:1.6.0")

    // Splash Screen
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Firebase BOM (ensure all Firebase dependencies use this for version management)
    implementation("com.google.firebase:firebase-bom:32.7.4")
}

