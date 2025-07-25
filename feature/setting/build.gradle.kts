plugins {
    alias(libs.plugins.phayarsar.android.feature)
    alias(libs.plugins.phayarsar.android.library.compose)
}

android {
    namespace = "com.phayarsar.setting"
}

dependencies{

    implementation(project(":core:domain"))
    implementation(project(":core:common"))
    implementation(libs.androidx.constriantlayout.compose)
}