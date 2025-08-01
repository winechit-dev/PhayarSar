package com.phyarsar.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import charcoal
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.design_system.utils.bounceClick
import com.phayarsar.domain.model.PrayerModel
import com.phayarsar.localization.Vocabulary
import com.phayarsar.localization.model.LocalizationModel
import com.phyarsar.home.HomeEvent
import com.phyarsar.home.PreviewData
import com.phyarsar.home.R

@Composable
fun PrayerCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    duration: String,
    list: List<PrayerModel>,
    color: Color = MaterialTheme.colorScheme.primary,
    localization: LocalizationModel = Vocabulary.localization,
    onClick: (HomeEvent) -> Unit
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(
            color.copy(alpha = 0.8f),
            color.copy(alpha = 0.9f),
            color.copy(alpha = 1f)
        )
    )

    Box(
        modifier = modifier.background(
            brush = gradient,
            shape = MaterialTheme.shapes.large
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White.copy(alpha = 0.85f),
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_access_time_filled_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.White,
                        text = localization.x_min.replace("{$}", duration)
                    )
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            HorizontalDivider(
                color = Color.White,
                thickness = 0.5.dp
            )
            PrayerListSection(list = list.take(3), onClick = onClick)
            PrayerCollectionSection(onClick = onClick, list = list)
        }
    }
}

@Composable
private fun PrayerCollectionSection(
    onClick: (HomeEvent) -> Unit,
    localization: LocalizationModel = Vocabulary.localization,
    list: List<PrayerModel>
) {
    if (list.size <= 3) return
    PysCard(
        color = Color.White,
        shape = MaterialTheme.shapes.medium,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = localization.view_collection,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.weight(1f),
                color = charcoal
            )
            Text(
                text = localization.plus_x_more.replace("{$}", "${list.size - 3}"),
                style = MaterialTheme.typography.labelMedium,
                color = charcoal
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_navigate_next_24),
                contentDescription = null,
                tint = charcoal
            )
        }
    }
}

@Composable
private fun PrayerListSection(list: List<PrayerModel>, onClick: (HomeEvent) -> Unit) {
    PysCard(
        color = Color.Black.copy(alpha = 0.4f),
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 200.dp)// Added height constraint to prevent infinite height
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        ) {
            items(list) {
                PrayerItem(
                    item = it,
                    showDivider = it != list.last(),
                    onClick = onClick
                )
            }
        }
    }
}


@Composable
private fun PrayerItem(item: PrayerModel, showDivider: Boolean = true, onClick: (HomeEvent) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .bounceClick()
            .clickable{ onClick(HomeEvent.GoToDetails(item))}
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_pray),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Column {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = item.label,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    modifier = Modifier.weight(1f),
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_navigate_next_24),
                    tint = Color.White,
                    contentDescription = null
                )
            }
            if (showDivider) HorizontalDivider(thickness = 0.5.dp, color = Color.White)
        }
    }
}

@ThemePreviews
@Composable
private fun PrayerCardPreview() {
    PysPreview {
        PrayerCard(
            modifier = Modifier.padding(16.dp),
            title = "ဘုရားရှိခိုး ဂါထာများ",
            subtitle = "ဘုရားကန်တော့",
            duration = "8",
            list = PreviewData.previewPrayerList,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            onClick = {}
        )
    }
}