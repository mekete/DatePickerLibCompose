plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.google.android.material"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        targetSdk = 36

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
    // AndroidX core dependencies required by datepicker
    api(libs.activity)
    api(libs.androidx.annotation)
    api(libs.androidx.annotation.experimental)
    api(libs.appcompat)
    api(libs.androidx.core)
    api(libs.androidx.fragment)
    api(libs.androidx.recyclerview)
    api(libs.androidx.transition)
    api(libs.androidx.vectordrawable)

    // Additional AndroidX dependencies used by material components
    api(libs.androidx.coordinatorlayout)
    api(libs.androidx.customview)
    api(libs.androidx.lifecycle.runtime)
    api(libs.androidx.graphics.shapes)
    api(libs.androidx.dynamicanimation)
    api(libs.androidx.drawerlayout)
    api(libs.androidx.cardview)
    api(libs.androidx.viewpager2)
    api(libs.androidx.resourceinspection.annotation)
    api(libs.constraintlayout)

    // Kotlin standard library (required for androidx.graphics.shapes)
    implementation(libs.kotlin.stdlib)

    // ErrorProne annotations (required by Material Components)
    implementation(libs.errorprone.annotations)

    // Test dependencies
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
