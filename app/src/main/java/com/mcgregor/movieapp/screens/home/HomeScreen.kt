package com.mcgregor.movieapp.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mcgregor.movieapp.model.Movie
import com.mcgregor.movieapp.model.getMovies
import com.mcgregor.movieapp.navigation.MovieScreens
import com.mcgregor.movieapp.widgets.MovieCard

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.LightGray,
            elevation = 50.dp
        ) {
            Text(text = "Movies", fontWeight = FontWeight.Bold)

        }
    }) {
        MainContent(navController)
    }

}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {

    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(movieList) {
                    MovieCard(movie = it) { movie ->
                        navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                    }

                }
            }

        }
    }

}