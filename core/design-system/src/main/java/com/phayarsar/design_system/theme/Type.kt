package com.phayarsar.design_system.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phayarsar.design_system.R

val dmSerifDisplayFamily = FontFamily(
    Font(R.font.dm_serif_display_regular, FontWeight.Normal)
)
val quicksandFamily = FontFamily(
    Font(R.font.quicksand_regular, FontWeight.Normal),
    Font(R.font.quicksand_semibold, FontWeight.SemiBold),
    Font(R.font.quicksand_bold, FontWeight.Bold)
)


val platformStyle = PlatformTextStyle(
    includeFontPadding = false, // Set this to false to remove extra padding
)
val PysTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = dmSerifDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 38.4.sp,
        platformStyle = platformStyle
    ),
    headlineMedium = TextStyle(
        fontFamily = dmSerifDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        platformStyle = platformStyle
    ),
    headlineSmall = TextStyle(
        fontFamily = dmSerifDisplayFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        platformStyle = platformStyle
    ),
    titleLarge = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
        lineHeight = 30.sp,
        platformStyle = platformStyle
    ),
    titleMedium = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        platformStyle = platformStyle
    ),
    titleSmall = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        platformStyle = platformStyle
    ),
    bodyLarge = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        platformStyle = platformStyle
    ),
    bodyMedium = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 18.sp,
        platformStyle = platformStyle
    ),
    bodySmall = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        platformStyle = platformStyle
    ),
    labelLarge = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        platformStyle = platformStyle
    ),
    labelMedium = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        platformStyle = platformStyle
    ),
    labelSmall = TextStyle(
        fontFamily = quicksandFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        platformStyle = platformStyle
    )
)

@ThemePreviews
@Composable
fun TypographyPreview() {
    PysPreview {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "headlineLarge",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                text = "headlineMedium",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "headlineSmall",
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "titleLarge",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "titleMedium",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "titleSmall",
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = "bodyLarge",
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "bodyMedium",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "bodySmall",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "labelMedium",
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = "labelSmall",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}