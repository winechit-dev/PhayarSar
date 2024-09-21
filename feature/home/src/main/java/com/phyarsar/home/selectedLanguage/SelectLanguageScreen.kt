package com.phyarsar.home.selectedLanguage

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.os.LocaleListCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.phayarsar.design_system.components.PysCard
import com.phayarsar.design_system.components.PysTextButton
import com.phayarsar.design_system.components.PysTopAppBar
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.design_system.theme.ThemePreviews
import com.phayarsar.domain.model.LanguageModel
import com.phayarsar.localization.Vocabulary
import com.phyarsar.home.R
import com.phyarsar.home.findActivity

@Composable
fun SelectLanguageScreen(onClickNext: () -> Unit) {

    val viewModel: SelectedLanguageViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    val currentLocale = if (AppCompatDelegate.getApplicationLocales().isEmpty) {
        "en"
    } else {
        AppCompatDelegate.getApplicationLocales()[0]?.language ?: "en"
    }

    var selectedLanguage by remember { mutableStateOf(currentLocale) }

    val localization = Vocabulary.localization
    Scaffold(
        topBar = {
            PysTopAppBar(
                title = localization.choose_a_language,
                colors = MaterialTheme.colorScheme.surfaceContainerLowest,
                actions = {
                    PysTextButton(
                        onClick = {
                            //  viewModel.changeLocale()
                            onClickNext()
                        },
                        //text = localization.next
                        text = stringResource(id = R.string.next)
                    )
                }
            )
        }
    ) {

        SelectedLanguageContent(
            // languageList = uiState,
            languageList = languageList,
            contentPadding = it,
            selectedLanguage = selectedLanguage,
            onSelected = { languageModel ->
                //   viewModel.selectLanguage(languageModel.language)
                selectedLanguage = languageModel.language
                AppCompatDelegate.setApplicationLocales(
                    LocaleListCompat.forLanguageTags(languageModel.language)
                )
               /* context.findActivity()?.runOnUiThread {
 selectedLanguage = languageModel.language
                AppCompatDelegate.setApplicationLocales(
                    LocaleListCompat.forLanguageTags(languageModel.language)
                )
                }*/
            }
        )
    }
}

@Composable
fun SelectedLanguageContent(
    languageList: List<LanguageModel>,
    contentPadding: PaddingValues,
    selectedLanguage: String,
    onSelected: (LanguageModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
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
                    SelectLanguageItem(
                        languageItem = languageItem,
                        selectedLanguage = selectedLanguage,
                        onSelected = {
                            onSelected(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SelectLanguageItem(
    languageItem: LanguageModel,
    selectedLanguage: String,
    onSelected: (LanguageModel) -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.space20)
            .clickable {
                onSelected(languageItem)
            }
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
            text = languageItem.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .constrainAs(englishName) {
                    start.linkTo(imgFlag.end, 10.dp)
                    top.linkTo(imgFlag.top)
                }
        )

        Text(
            text = languageItem.body,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(myanmarName) {
                    start.linkTo(englishName.start)
                    top.linkTo(englishName.bottom, 2.dp)
                    bottom.linkTo(imgFlag.bottom)
                }
        )

        if (selectedLanguage == languageItem.language) {
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

/*@Composable
fun SelectLanguageItem(languageItem: LanguageModel, onSelected: (LanguageModel) -> Unit) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.space20)
            .clickable {
                onSelected(languageItem)
            }
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
            text = languageItem.title,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .constrainAs(englishName) {
                    start.linkTo(imgFlag.end, 10.dp)
                    top.linkTo(imgFlag.top)
                }
        )

        Text(
            text = languageItem.body,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .constrainAs(myanmarName) {
                    start.linkTo(englishName.start)
                    top.linkTo(englishName.bottom, 2.dp)
                    bottom.linkTo(imgFlag.bottom)
                }
        )

        if (languageItem.isSelected) {
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
}*/


@ThemePreviews
@Composable
private fun SelectLanguageItemPreview() {
    PysPreview {
        /*SelectLanguageItem(
            LanguageModel(
                language = "english",
                title = "English",
                body = "(English)",
                image = R.drawable.ic_uk_flag,
                isSelected = true,
                locale = ENGLISH
            )
        ) {}*/
    }
}


@ThemePreviews
@Composable
private fun SelectLanguageContentPreview() {
    PysPreview {
        //  SelectedLanguageContent(languageList, PaddingValues(8.dp)) {}
    }
}