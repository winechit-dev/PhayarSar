package com.phyarsar.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.phayarsar.design_system.components.AnnotatedStyleText
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.components.PysOutlinedButton
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.localization.Vocabulary
import com.phayarsar.localization.model.LocalizationModel
import com.phyarsar.home.PreviewData.previewOtherPrayerList
import com.phyarsar.home.components.PrayerCard
import com.phyarsar.home.components.otherPrayerSection

@Composable
fun HomeScreen(
    onClick: (HomeEvent) -> Unit
) {

    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeContent(
        uiState = uiState,
        onClick = onClick
        //{ homeEvent ->
//             viewModel.homeEvent(homeEvent)
//        }
    )

    /*LaunchedEffect(Unit) {
        viewModel.navigationEvent.collect { event ->
            when (event) {
                is HomeEvent.GoToDetails -> {
                    navController.navigate("detail")
                }

                is HomeEvent.OnSearch -> {
                    navController.navigate("detail")
                }

                else -> {
                    // Handle search action
                }
            }
        }
    }*/
}

@Composable
fun HomeContent(
    uiState: HomeUiState,
    onClick: (HomeEvent) -> Unit,
    localization: LocalizationModel = Vocabulary.localization
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
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
                list = uiState.prayerList,
                modifier = Modifier.padding(bottom = LocalSpacing.current.space20),
                onClick = onClick
            )
        }

        otherPrayerSection(
            list = uiState.otherPrayerList,
            onClick = onClick
        )
    }
}

@Composable
fun HeaderSection(
    localization: LocalizationModel = Vocabulary.localization,
    onClick: (HomeEvent) -> Unit = {}
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
                style = MaterialTheme.typography.headlineLarge,
            )

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
                    .clickable {
                        onClick(HomeEvent.OnSearch)
                    }
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

        AnnotatedStyleText(
            text = localization.today_pray_time,
            time = localization.x_min.replace("{$}", "0"),
            modifier = Modifier
                .padding(top = LocalSpacing.current.space4)
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
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(32.dp)
            )
            Text(
                text = localization.worship_plan_helps_you_pray,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
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
private fun HomeContentPreview() {
    PysPreview {
        HomeContent(uiState = HomeUiState(prayerList = previewOtherPrayerList), onClick = {})
    }
}