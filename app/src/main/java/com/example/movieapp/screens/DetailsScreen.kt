package com.example.movieapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movie: String?){
    Scaffold(
        topBar = {
            TopAppBar {

                Row(horizontalArrangement = Arrangement.Start, 
                    verticalAlignment = Alignment.CenterVertically
                    
                ) {
                    IconButton(onClick = {
                       navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = movie.toString(), fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
        }
    ) {

        it.calculateTopPadding()

    }

}