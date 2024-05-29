package com.phyarsar.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.components.PysTextButton
import com.phayarsar.design_system.components.PysTopAppBar
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.domain.model.LanguageModel
import com.phayarsar.localization.Vocabulary
import com.phyarsar.home.PreviewData.languageList

@Composable
fun SelectLanguageScreen(onClick: (HomeEvent) -> Unit) {

    val localization = Vocabulary.localization
    Scaffold(
        topBar = {
            PysTopAppBar(
                title = localization.choose_a_language,
                colors = MaterialTheme.colorScheme.surfaceContainerLowest,
                actions = {
                    PysTextButton(
                        onClick = { onClick(HomeEvent.OnNext) },
                        text = localization.next
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            PysCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = LocalSpacing.current.space20)
                    .padding(top = LocalSpacing.current.space30),
                color = MaterialTheme.colorScheme.surfaceContainerLowest
            ) {
                LazyColumn(modifier = Modifier) {
                    items(languageList) { languageItem ->
                        SelectLanguageItem(languageItem)
                    }
                }
            }
        }
    }
}

@Composable
fun SelectLanguageItem(languageItem: LanguageModel) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.space20),
    ) {
        val (imgFlag, englishName, myanmarName, imgCheck) = createRefs()

        Image(
            painter = painterResource(id = languageItem.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .constrainAs(imgFlag) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )

        Text(
            text = languageItem.languageName,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .constrainAs(englishName) {
                    start.linkTo(imgFlag.end, 10.dp)
                    top.linkTo(imgFlag.top)
                }
        )

        Text(
            text = languageItem.languageNotation,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(myanmarName) {
                    start.linkTo(englishName.start)
                    top.linkTo(englishName.bottom, 2.dp)
                    bottom.linkTo(imgFlag.bottom)
                }
        )

        if (languageItem.isChecked) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check_circle),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(24.dp)
                    .constrainAs(imgCheck) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
        }
    }
}


@ThemePreviews
@Composable
private fun SelectLanguageItemPreview() {
    PysPreview {
        SelectLanguageItem(
            LanguageModel(
                languageName = "English",
                languageNotation = "(English)",
                image = R.drawable.ic_uk_flag,
                isChecked = true
            )
        )
    }
}

@ThemePreviews
@Composable
private fun SelectLanguageScreenPreview() {
    PysPreview {
        SelectLanguageScreen({})
    }
}