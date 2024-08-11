plugins {
    alias(libs.plugins.phayarsar.android.library)
    alias(libs.plugins.phayarsar.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.phayarsar.data"
}

dependencies {

    implementation(project(":core:localization"))
    implementation(project(":core:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    
    implementation(libs.androidx.dataStore.pref)
    implementation(libs.androidx.dataStore.core)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.kotlinx.serialization.json)

}