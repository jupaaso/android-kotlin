package com.sampleandroidapp.mobicomp.ui.home

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun Home(
    viewModel: RemindersViewModel = viewModel(),
    navController: NavController
) {
    val viewState by viewModel.state.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        HomeContent(
            navController = navController
        )
        //Text(text = "Here is home screen, main screen. To be developed later")
    }
}

@Composable
fun HomeContent(
    navController: NavController,
) {
    val activity = (LocalContext.current as? Activity)
    val appBarColor = MaterialTheme.colors.secondary.copy(alpha = 0.87f)

    Scaffold(
        modifier = Modifier.padding(bottom = 24.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("reminder") },
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
        )  {
            TopAppBar(
                title = {
                    Text(
                        text ="HW1",
                        //text = stringResource("Mobicomp"),
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .heightIn(max = 24.dp)
                    )
                },
                backgroundColor = appBarColor,

                actions = {
                    Spacer(modifier = Modifier.width(4.dp))  // EI VAIKUTA
                    IconButton(onClick = {
                        activity?.finish()
                    }) {
                        Text(
                            text = "LOGOUT",
                            color = Color.Red,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(10.dp))  // EI VAIKUTA
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            modifier = Modifier
                                .heightIn(20.dp)
                        ) //stringResource("Search")) Ei vaikutusta koolla
                    }
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                            imageVector = Icons.Filled.AccountCircle,
                            contentDescription = "Account", //stringResource("Account"))
                            modifier = Modifier.size(50.dp)
                        )
                    }
                } )
             // TopAppBarille
                // This line adds the list of category paymenst into home screen
                Spacer(modifier = Modifier.height(20.dp))
                Reminders(
                    modifier = Modifier.fillMaxSize()
                )
            } // TopAppBarille
    }  // Columnille
}