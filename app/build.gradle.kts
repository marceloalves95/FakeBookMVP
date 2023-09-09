plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("jacoco-reports")
}

android {
    namespace = "br.com.fakebookmvp"
    compileSdk = 33

    defaultConfig {
        applicationId = "br.com.fakebookmvp"
        minSdk = 26
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }

    tasks.withType<Test> {
        extensions.configure(JacocoTaskExtension::class) {
            isIncludeNoLocationClasses = true
            excludes = listOf("jdk.internal.*")
        }
    }
}

dependencies {

    implementation(project(":modules:network"))
    implementation(project(":modules:extensions"))
    implementation(project(":modules:testing"))

    //Material
    implementation(libs.material)
    //AndroidX
    implementation(libs.bundles.androidx)

    //ThirdParty
    implementation(libs.koin)
    implementation(libs.bundles.rx)
    //Network
    implementation(libs.bundles.retrofit)

    //Unit Test
    testImplementation(libs.assertK)
    testImplementation(libs.robolectric)
    testImplementation(libs.mockk)
    testImplementation(libs.mockwebserver)
    testImplementation(libs.junit)
    testImplementation(libs.koin.test)
    testImplementation(libs.test.ext.junit)
    testImplementation(libs.test.core.ktx)
    testImplementation(libs.mockito.core)

    //Instrumental Test
    androidTestImplementation(libs.assertK)
    androidTestImplementation(libs.test.core.ktx)
    androidTestImplementation(libs.mockk.android)
    androidTestImplementation(libs.test.ext.junit)
    androidTestImplementation(libs.mockk.agent)
    androidTestImplementation(libs.arch.core.testing)
    androidTestImplementation(libs.barista)
    androidTestImplementation(libs.espresso)
    androidTestImplementation(libs.hamcrest)
    androidTestImplementation(libs.truth.test)
}