package com.example.movieapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Red, elevation = 4.dp,
        ) {
            Text(text = "Movies", color = Color.White, fontSize = 16.sp)
        }
    }) {
      val f=  it.calculateTopPadding()
        println(f)
        MainContent(navController = navController)
    }
}

val data = listOf("Avatar","300","Harry Potter","Life")
@Composable
fun MainContent(movies:List<String> = data,navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(){
            items(movies){ it ->
                MovieRow(movie = it, onClick = {movie->
                  navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")
                })
            }
        }
    }
}
@Composable
fun MovieRow(movie: String,onClick:(String)->Unit){
    Card(modifier = Modifier
            .padding(8.dp)
            .height(100.dp)
            .clickable { onClick(movie) }
            .fillMaxWidth()
            .border(border = BorderStroke(2.dp, color = Color.Gray),
                shape = RoundedCornerShape(corner = CornerSize(10.dp))
                ), elevation = 0.dp

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(shape = RoundedCornerShape(corner = CornerSize(10.dp))),
                backgroundColor = Color.Black
            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "",
                    modifier = Modifier
                        .size(20.dp),
                    tint = Color.White)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = movie)
        }
    }
}

