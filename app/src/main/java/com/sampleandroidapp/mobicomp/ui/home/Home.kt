package com.sampleandroidapp.mobicomp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun Home(
    viewModel: RemindersViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavController
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        HomeContent(
            navController = navController
        )
        //Text(text = "Here is home screen, main screen. To be developed later")
    }
}

@Composable
fun HomeContent(
    navController: NavController
) {
    Scaffold(
        modifier = Modifier.padding(bottom = 24.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(route = "reminder") },
                modifier = Modifier.padding(all = 20.dp),
                contentColor = Color.Black
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxWidth()
        ) {
            val appBarColor = MaterialTheme.colors.secondary.copy(alpha = 0.87f)

            HomeAppBar(
                backgroundColor = appBarColor,
                navController = navController
            )
        }
    }
}

@Composable
private fun HomeAppBar(
    backgroundColor: Color,
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(
                text ="MobileComputing HW1",
                //text = stringResource("Mobicomp"),
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp)
            )
        },
        backgroundColor = backgroundColor,
        actions = {
            IconButton( onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                       .heightIn(20.dp)) //stringResource("Search")) Ei vaikutusta koolla
            }
            IconButton( onClick = { navController.navigate("profile") } ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Account")  //stringResource("Account"))
            }
        }

    )
}