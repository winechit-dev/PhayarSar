plugins {
    alias(libs.plugins.phayarsar.android.feature)
    alias(libs.plugins.phayarsar.android.library.compose)
}

android {
    namespace = "com.phyarsar.home"
}

dependencies{

    implementation(project(":core:domain"))
    implementation(libs.androidx.constriantlayout.compose)
}