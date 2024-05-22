package com.phayarsar.design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.design_system.utils.bounceClick
import com.phayarsar.design_system.utils.hapticClickable
import com.phayarsar.design_system.utils.softShadow

@Composable
fun PysCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    elevation: Dp = 0.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .bounceClick()
            .softShadow(
                shape = shape,
                shadowColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                elevation = elevation
            )
            .clip(shape)
            .hapticClickable(
                hapticFeedbackEnabled = true,
                onClick = onClick,
                enabled = true
            ),
        color = color
    ) {
        content()
    }
}

@Composable
fun PysCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
    elevation: Dp = 0.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier
            .softShadow(
                shape = shape,
                shadowColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                elevation = elevation
            )
            .clip(shape),
        color = color
    ) {
        content()
    }
}

@ThemePreviews
@Composable
fun PysCardPreview() {
    PysPreview {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            PysCard(
                modifier = Modifier.size(200.dp),
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
                onClick = {}
            ) {}
        }
    }
}
