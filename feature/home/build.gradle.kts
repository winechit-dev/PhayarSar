plugins {
    alias(libs.plugins.phayarsar.android.feature)
    alias(libs.plugins.phayarsar.android.library.compose)
    alias(libs.plugins.phayarsar.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.phyarsar.home"
}

dependencies{

    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    implementation(libs.androidx.constriantlayout.compose)
    implementation(libs.kotlinx.serialization.json)

}