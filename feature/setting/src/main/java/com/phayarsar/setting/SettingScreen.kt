package com.phayarsar.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.phayarsar.design_system.theme.PysTheme
import com.phayarsar.design_system.theme.ThemePreviews

@Composable
fun SettingScreen() {

    Text(
        text = "This is a sample",
        textAlign = TextAlign.Center
    )
}

@ThemePreviews
@Composable
fun PreviewSettingScreen() {
    PysTheme {
        SettingScreen()
    }
}