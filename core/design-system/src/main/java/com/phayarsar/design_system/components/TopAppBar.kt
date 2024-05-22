package com.phayarsar.design_system.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.phayarsar.design_system.R
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews


/** A center aligned top app bar that uses a [scrollBehavior] to customize its nested scrolling
* behavior when working in conjunction with a scrolling content looks like:
*
* @param title the title to be displayed in the top app bar
* @param modifier the [Modifier] to be applied to this top app bar
* @param navigationIcon the navigation icon displayed at the start of the top app bar. This should
* typically be an [IconButton] or [IconToggleButton].
* @param actions the actions displayed at the end of the top app bar. This should typically be
* [IconButton]s. The default layout here is a [Row], so icons inside will be placed horizontally.
*
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PysTopAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    navigationIcon: Int = R.drawable.ic_arrow_back_24,
    onNavigateUp: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (onNavigateUp != null) {
                IconButton(onClick = onNavigateUp) {
                    Icon(
                        painter = painterResource(id = navigationIcon),
                        contentDescription = null,
                    )
                }
            }
        },
        actions = actions
    )
}

@ThemePreviews
@Composable
private fun PysTopAppBarPreview() {
    PysPreview {
        PysTopAppBar(
            title = "Top App Bar",
            onNavigateUp = { /* Handle navigation */ }
        )
    }
}

@ThemePreviews
@Composable
private fun PysTopAppBarWithActionsPreview() {
    PysPreview {
        PysTopAppBar(
            title = "Top App Bar",
            actions = {
                PysTextButton(
                    onClick = { /* Handle action */ },
                    text = "Next",
                )
            }
        )
    }
}

