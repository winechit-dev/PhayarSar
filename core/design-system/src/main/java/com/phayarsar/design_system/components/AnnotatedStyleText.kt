package com.phayarsar.design_system.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.phayarsar.design_system.R
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews

@Composable
fun AnnotatedStyleText(
    text:String,
    time:String,
    modifier: Modifier = Modifier
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append(text)
            }
            append(time)
        },
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
    )
}

@ThemePreviews
@Composable
private fun AnnotatedStyleTextPreview() {
    PysPreview {
        AnnotatedStyleText("Today's pray time is", "0 min", )
    }
}