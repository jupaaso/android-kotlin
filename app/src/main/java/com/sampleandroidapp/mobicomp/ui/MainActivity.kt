package com.sampleandroidapp.mobicomp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.sampleandroidapp.mobicomp.data.CategoryRepository
import com.sampleandroidapp.mobicomp.data.MobileComputingDatabase
import com.sampleandroidapp.mobicomp.data.ReminderRepository
import com.sampleandroidapp.mobicomp.ui.login.LoginScreen
import com.sampleandroidapp.mobicomp.ui.theme.MobicompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobicompTheme(darkTheme = true) {                   // darkTheme used, otherwise light
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    //LoginScreen(modifier = Modifier.fillMaxSize())

                    MobileComputingApp()
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MobicompTheme {
//        Greeting("Android")
//    }
//}