package com.phyarsar.home.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.phayarsar.design_system.components.PysTopAppBar
import com.phayarsar.design_system.theme.PysTheme
import com.phayarsar.design_system.theme.ThemePreviews
import com.phyarsar.home.R
import kotlinx.serialization.Serializable

@Serializable
data class Detail(val id: String, val label: String)

@Composable
fun DetailScreen(
    args: Detail
) {
    DetailScreenTopAppBar(args)
}

@Composable
fun DetailScreenTopAppBar(args: Detail) {
    Scaffold(
        topBar = {
            PysTopAppBar(
                title = args.label,
                navigationIcon = R.drawable.ic_arrow_back_24,
                onNavigateUp = {},
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
fun PreviewDetailScreenTopAppBar() {
    PysTheme {
        DetailScreenTopAppBar(Detail("1", "Detail Screen"))
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
        DetailScreen(Detail("1", "Detail Screen"))
    }
}