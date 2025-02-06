package com.phyarsar.home.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {}
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}