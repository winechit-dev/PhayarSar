package com.phayarsar.localization

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.phayarsar.localization.model.LocalizationModel
import java.util.Locale

val LocalLocalization = compositionLocalOf { LocalizationModel() }

object Vocabulary {
    val localization: LocalizationModel
        @Composable
        @ReadOnlyComposable
        get() = LocalLocalization.current
}

@Composable
fun Localization(localization: LocalizationModel, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalLocalization provides (localization),
        content = content
    )
}