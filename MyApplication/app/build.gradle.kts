@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
   
}

android {
    namespace = "com.example.myapplication"
    compileSdk =  34

    defaultConfig {
        applicationId =  "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
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
    buildFeatures {
        compose = true
    }

    composeOptions{
        kotlinCompilerExtensionVersion = "1.5.7"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material3)
    implementation(libs.material)
    implementation(libs.androidx.benchmark.macro)
//    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)

    //Compose dependencies
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling)
    implementation("androidx.compose.foundation:foundation:1.5.4")
    implementation(libs.material)
    implementation(libs.activity.compose)
    implementation(libs.constraintlayout)
    implementation(libs.constraintCompose)
    implementation(libs.lifecycleViewmodelCompose)
    implementation(libs.runtimeLivedataCompose)
    implementation(libs.imageAccompanistCoil)




//    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
//    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")

    implementation("androidx.compose.runtime:runtime-rxjava2:1.5.4")
}