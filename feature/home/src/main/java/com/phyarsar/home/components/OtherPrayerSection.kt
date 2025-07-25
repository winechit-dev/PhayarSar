package com.phyarsar.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.design_system.utils.bounceClick
import com.phayarsar.domain.model.PrayerModel
import com.phayarsar.localization.Vocabulary.localization
import com.phyarsar.home.HomeEvent
import com.phyarsar.home.PreviewData
import com.phyarsar.home.R

fun LazyListScope.otherPrayerSection(
    list: List<PrayerModel>,
    onClick: (HomeEvent) -> Unit
) {
    item {
        Row(
            horizontalArrangement = Arrangement.spacedBy(LocalSpacing.current.space12),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = LocalSpacing.current.space8)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_other_books),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
            )
            Text(
                text = localization.other_prayers,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )
        }
    }
    items(
        items = list,
        key = { it.id },
        contentType = { "OtherPrayerItem" }
    ) { item ->
        OtherPrayerItem(item = item, onClick = onClick)
    }
}

@Composable
private fun OtherPrayerItem(item: PrayerModel, onClick: (HomeEvent) -> Unit) {
    PysCard(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.padding(top = LocalSpacing.current.space8)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(LocalSpacing.current.space12),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(LocalSpacing.current.space12)
                .fillMaxWidth()
                .bounceClick()
                .clickable { onClick(HomeEvent.GoToDetails(item)) },
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_book_closed),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            Text(
                text = item.label,
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.weight(1f),
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_navigate_next_24),
                contentDescription = null
            )
        }
    }
}

@ThemePreviews
@Composable
fun OtherPrayerSectionPreview() {
    PysPreview {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.padding(LocalSpacing.current.space16)
            ) {
                otherPrayerSection(
                    list = PreviewData.previewOtherPrayerList,
                    onClick = {}
                )
            }
        }
    }
}