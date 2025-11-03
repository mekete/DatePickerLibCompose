plugins {
    alias(libs.plugins.android.library)
}

android {
    namespace = "com.shalom.android.material.datepicker"
    compileSdk = 35

    defaultConfig {
        minSdk = 26
        targetSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    // Material Components (includes DatePicker)
    api(libs.material)

    // ThreeTen Extra for Ethiopian calendar support
    api(libs.threeten.extra)

    // AndroidX dependencies
    implementation(libs.appcompat)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
