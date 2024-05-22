package com.phyarsar.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phyarsar.home.R

@Composable
fun AddWorshipPlanCard() {
    PysCard(
        color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f),
    ) {
        Row{
            Icon(
                painter = painterResource(id = R.drawable.ic_playlist_add_24),
                contentDescription = "Add Worship Plan",
            )

        }
    }
}

@ThemePreviews
@Composable
private fun AddWorshipPlanCardPreview() {
    PysPreview {
        AddWorshipPlanCard()
    }
}