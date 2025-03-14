package com.phayarsar.design_system.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.design_system.utils.bounceClick

/**
 * Phayar Sar filled button with text and icon content slots.
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param hapticFeedback Controls the hapticFeedback state of the button.
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 */
@Composable
fun PysButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    hapticFeedback: Boolean = false,
    text: String,
    leadingIcon: ImageVector? = null,
) {
    val haptic = LocalHapticFeedback.current

    Button(
        modifier = modifier.bounceClicks(enabled),
        onClick = {
            if (hapticFeedback) haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        },
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
        content = {
            PysButtonContent(
                text = text,
                leadingIcon = leadingIcon,
            )
        }
    )
}


/**
 * Phayar Sar outlined button with text and icon content slots.
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param hapticFeedback Controls the hapticFeedback state of the button.
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 */
@Composable
fun PysOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    hapticFeedback: Boolean = false,
    text: String,
    leadingIcon: ImageVector? = null,
) {
    val haptic = LocalHapticFeedback.current

    OutlinedButton(
        modifier = modifier.bounceClicks(enabled),
        enabled = enabled,
        onClick = {
            if (hapticFeedback) haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        border = BorderStroke(
            width = PysButtonDefaults.OutlinedButtonBorderWidth,
            color = if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = PysButtonDefaults.DISABLED_OUTLINED_BUTTON_BORDER_ALPHA,
                )
            },
        ),
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
        content = {
            PysButtonContent(
                text = text,
                leadingIcon = leadingIcon,
            )
        }
    )
}

/**
 * Phayar Sar text button with text and icon content slots.
 *
 * @param onClick Will be called when the user clicks the button.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Controls the enabled state of the button. When `false`, this button will not be
 * clickable and will appear disabled to accessibility services.
 * @param hapticFeedback Controls the hapticFeedback state of the button.
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Pass `null` here for no leading icon.
 */
@Composable
fun PysTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    hapticFeedback: Boolean = false,
    text: String,
    leadingIcon: ImageVector? = null,
) {
    val haptic = LocalHapticFeedback.current
    TextButton(
        modifier = modifier.bounceClicks(enabled),
        enabled = enabled,
        onClick = {
            if (hapticFeedback) haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            onClick()
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.onBackground,
        ),
        content = {
            PysButtonContent(
                text = text,
                leadingIcon = leadingIcon,
            )
        }
    )
}

/**
 * Internal Phayar Sar button content layout for arranging the text label and leading icon.
 *
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Default is `null` for no leading icon.Ï
 */
@Composable
internal fun PysButtonContent(
    text: String,
    leadingIcon: ImageVector? = null,
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
            )
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                },
            ),
    ) {
        Text(text)
    }
}

/**
 * Phayar Sar button default values.
 */
object PysButtonDefaults {
    // OutlinedButton border color doesn't respect disabled state by default
    const val DISABLED_OUTLINED_BUTTON_BORDER_ALPHA = 0.12f

    // OutlinedButton default border width isn't exposed via ButtonDefaults
    val OutlinedButtonBorderWidth = 1.dp
}

fun Modifier.bounceClicks(enabled: Boolean): Modifier {
    return if (enabled) this.bounceClick() else this
}

@ThemePreviews
@Composable
private fun PysOutlinedButtonPreview() {
    PysPreview {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            PysButton(
                onClick = {},
                text = "Filled Button"
            )

            PysOutlinedButton(onClick = {}, text = "Outlined Button")

            PysButton(
                onClick = {},
                text = "Button LeadingIcon",
                leadingIcon = Icons.Rounded.Add,
            )

            PysTextButton(onClick = {}, text = "Text Button")
        }
    }
}
