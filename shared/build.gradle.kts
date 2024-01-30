plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
    id("com.rickclephas.kmp.nativecoroutines")
}

kotlin {
    androidTarget()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    val coroutinesVersion = "1.7.3"
    val koinVersion = "3.5.3"

    sourceSets {
        all {
            languageSettings {
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
                optIn("kotlin.experimental.ExperimentalObjCName")
            }
        }
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            implementation("io.insert-koin:koin-core:$koinVersion")

            api("com.rickclephas.kmm:kmm-viewmodel-core:1.0.0-ALPHA-16")
            api("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
            api("me.nathanfallet.usecases:usecases:1.5.5")
        }
        val androidUnitTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation("io.mockk:mockk:1.13.8")
            }
        }
    }
}

android {
    namespace = "dev.toastcie.lifeisshort.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

koverReport {
    defaults {
        mergeWith("debug")
    }
}