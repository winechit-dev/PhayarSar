package com.phyarsar.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.design_system.utils.bounceClick
import com.phayarsar.localization.Vocabulary.localization
import com.phyarsar.home.R
import com.phyarsar.home.model.PrayerModel

fun LazyListScope.otherPrayerSection(
    list: List<PrayerModel>,
    onClick: (PrayerModel) -> Unit
) {
    item {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
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
private fun OtherPrayerItem(item: PrayerModel, onClick: (PrayerModel) -> Unit) {
    PysCard(
        onClick = { onClick(item) },
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .bounceClick()
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_book_closed),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
            )
            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
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
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                otherPrayerSection(

                    list = listOf(
                        PrayerModel("1", "Prayer 1"),
                        PrayerModel("2", "Prayer 2"),
                        PrayerModel("3", "Prayer 3"),
                        PrayerModel("4", "Prayer 4"),
                        PrayerModel("5", "Prayer 5"),
                        PrayerModel("6", "Prayer 6"),
                        PrayerModel("7", "Prayer 7"),
                        PrayerModel("8", "Prayer 8"),
                        PrayerModel("9", "Prayer 9"),
                        PrayerModel("10", "Prayer 10")
                    ),
                    onClick = {}
                )
            }
        }
    }
}