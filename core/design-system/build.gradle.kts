plugins {
    alias(libs.plugins.phayarsar.android.library)
    alias(libs.plugins.phayarsar.android.library.compose)
}

android {
    namespace = "com.phayarsar.design_system"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.androidx.compose.foundation)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}