package com.phayarsar.design_system.theme

import android.content.res.Configuration
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import backgroundDark
import bole_40
import bole_90
import brightPink_100
import brightPink_40
import brightPink_90
import charcoal
import charcol_40
import charcol_90
import darkPurple_40
import darkPurple_90
import ebony_40
import ebony_90
import errorDark
import errorLight
import indigoBlue_40
import indigoBlue_90
import midnightBlue_100
import midnightBlue_40
import midnightBlue_90
import mono_0
import mono_10
import neonBlue_40
import neonBlue_90
import oliveGreen_100
import oliveGreen_40
import oliveGreen_90
import onBackgroundDark
import onErrorDark
import onPrimaryDark
import onSurfaceDark
import orange_40
import orange_90
import outlineDark
import outlineLight
import pineGreen_40
import pineGreen_90
import primaryContainerDark
import primaryDark
import rust_100
import rust_40
import rust_90
import scrimDark
import scrimLight
import surfaceDark
import ultraViolet_40
import ultraViolet_90

@Immutable
data class ExtendedColorScheme(
    val pineGreenColor: ColorFamily,
    val oliveGreenColor: ColorFamily,
    val indigoBlueColor: ColorFamily,
    val neonBlueColor: ColorFamily,
    val midnightBlueColor: ColorFamily,
    val brightPinkColor: ColorFamily,
    val orangeColor: ColorFamily,
    val rustColor: ColorFamily,
    val boleColor: ColorFamily,
    val darkPurpleColor: ColorFamily,
    val ultraVioletColor: ColorFamily,
    val ebonyColor: ColorFamily,
    val charcolColor: ColorFamily,
)

private val LightColorScheme = lightColorScheme(
    primary = pineGreen_40,
    onPrimary = Color.White,
    primaryContainer = pineGreen_90,
    onPrimaryContainer = Color.White,
    error = errorLight,
    onError = Color.White,
    background = mono_10,
    onBackground = charcoal,
    surface = mono_0,
    onSurface = charcoal,
    outline = outlineLight,
    scrim = scrimLight,
)

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = Color.White,
    error = errorDark,
    onError = onErrorDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    outline = outlineDark,
    scrim = scrimDark,
)

val extendedLight = ExtendedColorScheme(
    pineGreenColor = ColorFamily(
        primary = pineGreen_40,
        onPrimary = Color.White,
        primaryContainer = pineGreen_90,
        onPrimaryContainer = Color.White,
    ),
    oliveGreenColor = ColorFamily(
        primary = oliveGreen_40,
        onPrimary = Color.White,
        primaryContainer = oliveGreen_90,
        onPrimaryContainer = oliveGreen_100,
    ),
    indigoBlueColor = ColorFamily(
        primary = indigoBlue_40,
        onPrimary = Color.White,
        primaryContainer = indigoBlue_90,
        onPrimaryContainer = Color.White,
    ),
    neonBlueColor = ColorFamily(
        primary = neonBlue_40,
        onPrimary = Color.White,
        primaryContainer = neonBlue_90,
        onPrimaryContainer = Color.White,
    ),
    midnightBlueColor = ColorFamily(
        primary = midnightBlue_40,
        onPrimary = Color.White,
        primaryContainer = midnightBlue_90,
        onPrimaryContainer = midnightBlue_100,
    ),
    brightPinkColor = ColorFamily(
        primary = brightPink_40,
        onPrimary = Color.White,
        primaryContainer = brightPink_90,
        onPrimaryContainer = brightPink_100,
    ),
    orangeColor = ColorFamily(
        primary = orange_40,
        onPrimary = Color.White,
        primaryContainer = orange_90,
        onPrimaryContainer = Color.White,
    ),
    rustColor = ColorFamily(
        primary = rust_40,
        onPrimary = Color.White,
        primaryContainer = rust_90,
        onPrimaryContainer = rust_100,
    ),
    boleColor = ColorFamily(
        primary = bole_40,
        onPrimary = Color.White,
        primaryContainer = bole_90,
        onPrimaryContainer = Color.White,
    ),
    darkPurpleColor = ColorFamily(
        primary = darkPurple_40,
        onPrimary = Color.White,
        primaryContainer = darkPurple_90,
        onPrimaryContainer = Color.White,
    ),
    ultraVioletColor = ColorFamily(
        primary = ultraViolet_40,
        onPrimary = Color.White,
        primaryContainer = ultraViolet_90,
        onPrimaryContainer = Color.White,
    ),
    ebonyColor = ColorFamily(
        primary = ebony_40,
        onPrimary = Color.White,
        primaryContainer = ebony_90,
        onPrimaryContainer = Color.White,
    ),
    charcolColor = ColorFamily(
        primary = charcol_40,
        onPrimary = Color.White,
        primaryContainer = charcol_90,
        onPrimaryContainer = Color.White,
    )
)

@Immutable
data class ColorFamily(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color
)

@Composable
fun PysTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    extendedColorFamily: ColorFamily = extendedLight.pineGreenColor,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme.copy(
            primary = extendedColorFamily.primary,
            onPrimary = extendedColorFamily.onPrimary,
            primaryContainer = extendedColorFamily.primaryContainer,
            onPrimaryContainer = extendedColorFamily.onPrimaryContainer
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = PysTypography,
        content = content
    )
}

/**
 * Multipreview annotation that represents light and dark themes. Add this annotation to a
 * composable to render the both themes.
 */
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "Light theme")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark theme")
annotation class ThemePreviews

@Composable
fun PysPreview(
    content: @Composable BoxWithConstraintsScope.() -> Unit,
) {
    PysTheme {
        Surface {
            BoxWithConstraints {
                content()
            }
        }
    }
}