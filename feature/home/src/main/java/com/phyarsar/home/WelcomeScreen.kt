package com.phyarsar.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phayarsar.design_system.components.PysButton
import com.phayarsar.design_system.theme.LocalSpacing
import com.phayarsar.design_system.theme.PysPreview
import com.phayarsar.localization.Vocabulary

@Composable
fun WelcomeScreen() {
    val localization = Vocabulary.localization
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.space20),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(LocalSpacing.current.space38))

        Image(
            painter = painterResource(id = R.drawable.ic_uk_flag),
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(LocalSpacing.current.space38))

        Text(
            text = localization.welcome_to_phayarsar,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(LocalSpacing.current.space30))

        Text(
            text = localization.onboarding_desc,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        PysButton(
            text = localization.btn_get_started,
            modifier = Modifier.fillMaxWidth(),
            onClick = { })
    }
}

@Preview
@Composable
private fun WelcomeScreenPreview() {
    PysPreview {
        WelcomeScreen()
    }
}