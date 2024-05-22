package com.phyarsar.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.components.PysOutlinedButton
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.localization.Vocabulary
import com.phyarsar.home.R

@Composable
fun AddWorshipPlanCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val localization = Vocabulary.localization
    PysCard(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_playlist_add_24),
                contentDescription = "Add Worship Plan",
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = localization.worship_plan_helps_you_pray,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.weight(1f)
            )
            PysOutlinedButton(
                onClick = onClick,
                text = localization.add_new
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