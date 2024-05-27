package com.phyarsar.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.components.PysOutlinedButton
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.localization.Vocabulary
import com.phayarsar.localization.model.LocalizationModel
import com.phyarsar.home.PreviewData.previewOtherPrayerList
import com.phyarsar.home.PreviewData.previewPrayerList
import com.phyarsar.home.components.PrayerCard
import com.phyarsar.home.components.otherPrayerSection

// ToDo:
//  create HomeUiState data class
//  add prayerList, otherPrayerList to HomeUiState
//  move ui code to HomeContent component
@Composable
fun HomeScreen(onClick: () -> Unit) {
    val localization = Vocabulary.localization

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = LocalSpacing.current.space20)
            .padding(horizontal = LocalSpacing.current.space20)
    ) {
        item {
            HeaderSection(onClick = onClick)
        }

        item {
            AddWorshipPlanCard(
                modifier = Modifier.padding(bottom = LocalSpacing.current.space20)
            )
        }

        item {
            PrayerCard(
                title = localization.prayerTitle,
                subtitle = localization.prayerSubTitle,
                duration = "8",
                list = previewPrayerList,
                modifier = Modifier.padding(bottom = LocalSpacing.current.space20)
            )
        }

        otherPrayerSection(
            list = previewOtherPrayerList,
            onClick = {}
        )
    }
}

@Composable
fun HeaderSection(
    localization: LocalizationModel = Vocabulary.localization,
    onClick: () -> Unit = {}
) {

    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = localization.phayarsar,
                style = MaterialTheme.typography.headlineLarge
            )

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                    .clickable { onClick() }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
        }

        Text(
            text = String.format(localization.today_pray_time_x, 0),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(top = LocalSpacing.current.space8)
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = LocalSpacing.current.space20,
                    bottom = LocalSpacing.current.space20
                )
        )
    }
}

@ThemePreviews
@Composable
private fun HeaderSessionPreview() {
    PysPreview {
        HeaderSection()
    }
}


@Composable
fun AddWorshipPlanCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val localization = Vocabulary.localization
    PysCard(
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
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

@ThemePreviews
@Composable
private fun HomeScreenPreview() {
    PysPreview {
        HomeScreen(onClick = {})
    }
}