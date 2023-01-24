package com.sampleandroidapp.mobicomp.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.sampleandroidapp.mobicomp.R

@Composable
fun LoginScreen(
    modifier: Modifier
) {
    //Text("Welcome to the login screen")                // Welcome text is not needed

    val username = remember { mutableStateOf("") }  // if needed pre-value: Juha
    val password = remember { mutableStateOf("") }  // if needed pre-value

    Column(
        modifier = Modifier.padding(20.dp),                 // column items left and right sides
        horizontalAlignment = Alignment.CenterHorizontally, // loginpage: horizontally all to middle
        verticalArrangement = Arrangement.Center            // loginpage: vertically to center
    ) {
        //Image(                                   //androidx.compose.foundation.Image
        //    painter = painterResource(id = R.drawable.ic_launcher_foreground),
        //    contentDescription = "login_image",
        //    modifier = Modifier.fillMaxWidth(),
        //    alignment = Alignment.Center
        //)

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "",
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))
                                                // TextField: text moves up inside the box
        OutlinedTextField(                      // Outlined: text moves up to outline
            value = username.value,
            onValueChange = { text -> username.value = text },
            modifier = Modifier.fillMaxWidth(),      // needs to do this first
            label = {Text(text = "Username")},       // and then Center the image
            shape = RoundedCornerShape(size = 50.dp) // rounded corners
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = { passwordString -> password.value = passwordString },
            modifier = Modifier.fillMaxWidth(),        // Calling the isolla "head" Modifier
            label = {Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),  // hides text, shows *
            shape = RoundedCornerShape(size = 50.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(                       // androidx.compose.ui.Modifier
            onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth().height(50.dp),
            shape = RoundedCornerShape(size = 50.dp)
        ) {
            Text(text = "Login")
        }
    }
}
