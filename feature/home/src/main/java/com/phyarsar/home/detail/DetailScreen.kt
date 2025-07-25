package com.phyarsar.home.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.phayarsar.design_system.theme.PysTheme
import com.phayarsar.design_system.theme.ThemePreviews
import com.phyarsar.home.R

@Composable
fun DetailScreen() {
    CenterAlignTopAppBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterAlignTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = "Center Aligned Top App Bar Bar Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_back),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        DetailContentSection(innerPadding)
    }
}

@Composable
fun DetailContentSection(paddingValues: PaddingValues = PaddingValues()) {

}

@Preview
@Composable
fun PreviewCenterAlignTopAppBar() {
    PysTheme {
        CenterAlignTopAppBar()
    }
}

@Preview
@Composable
fun PreviewDetailContentSection() {
    PysTheme {
        DetailContentSection()
    }
}

@ThemePreviews
@Composable
fun PreviewDetailScreenSample() {
    PysTheme {
        DetailScreen()
    }
}