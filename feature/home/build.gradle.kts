plugins {
    alias(libs.plugins.phayarsar.android.feature)
    alias(libs.plugins.phayarsar.android.library.compose)
}

android {
    namespace = "com.phyarsar.home"
}

dependencies{
    implementation(libs.androidx.constriantlayout.compose)
}