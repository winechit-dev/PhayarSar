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
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.localization.Vocabulary
import com.phayarsar.localization.model.LocalizationModel
import com.phyarsar.home.components.AddWorshipPlanCard
import com.phyarsar.home.components.PrayerCard
import com.phyarsar.home.components.otherPrayerSection

@Composable
fun HomeScreen(onClick: () -> Unit) {
    val localization = Vocabulary.localization

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.space20),
        verticalArrangement = Arrangement.spacedBy(20.dp)

    ) {
        item {
            HeaderSession(onClick = onClick)
        }

        item {
            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = LocalSpacing.current.space16)
            )
        }

        item {
            AddWorshipPlanCard()
        }

        item {
            PrayerCard(
                title = localization.prayerTitle,
                subtitle = localization.prayerSubTitle,
                duration = "0",
                list = prayerList,
            )
        }

        otherPrayerSection(
            list = otherPrayerList,
            onClick = {}
        )
    }
}

@Composable
fun HeaderSession(
    localization: LocalizationModel = Vocabulary.localization,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Text(
                text = localization.phayarsar,
                style = MaterialTheme.typography.headlineLarge
            )

            Text(
                text = String.format(localization.today_pray_time_x, 0),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(top = LocalSpacing.current.space8)
            )
        }

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
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
private fun HeaderSessionPreview() {
    PysPreview {
        HeaderSession()
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    PysPreview {
        HomeScreen(onClick = {})
    }
}