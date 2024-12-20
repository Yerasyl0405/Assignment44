package com.example.finalassignment3.realThirdTask.realThirdTask.view.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.assignment3.network.RetrofitInstance.api
import com.example.assignment3.view.FilmImagesViewModel

val filmImagesViewModel = FilmImagesViewModel(api)

@Composable
fun FilmImagesScreen(
    filmId: Int,
    navController: NavController
) {
    val images by filmImagesViewModel.images.collectAsState(emptyList())

    LaunchedEffect(Unit) {
        filmImagesViewModel.fetchImages(filmId)
    }


        Row (modifier = Modifier.padding(start = 26.dp, end = 26.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = "Галерея", fontSize = 18.sp, lineHeight = 19.8.sp, fontWeight = FontWeight.W600 )
            Text(text = "${images.size} >", fontSize = 14.sp, lineHeight = 15.4.sp, fontWeight = FontWeight.W500, color = Color(0xFF3D3BFF), modifier = Modifier.clickable { navController.navigate("FullStaffList") })
        }
    Spacer(modifier = Modifier.padding(16.dp))
    Column(modifier = Modifier) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) { item { Spacer(modifier = Modifier.padding(horizontal = 13.dp)) }

            items(images) { imageUrl ->
                Box(
                    modifier = Modifier
                        .height(108.dp).width(192.dp).padding(end = 8.dp).clip(shape = RoundedCornerShape(4.dp))

                ) {
                    AsyncImage(
                        model = imageUrl.imageUrl,
                        contentDescription = null,

                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),

                    )
                }
            }
        }



    }
}