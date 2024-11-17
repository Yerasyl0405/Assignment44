package com.example.finalassignment3.ThridTask

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.assignment3.network.RetrofitInstance.api
import com.example.assignment3.view.FilmImagesViewModel
import com.example.assignment3.view.StaffViewModel
import com.example.finalassignment3.realThirdTask.realThirdTask.model.Item

val filmImagesViewModel = FilmImagesViewModel(api)

@Composable
fun FilmImagesScreen(
    filmId: Int
) {
    val images by filmImagesViewModel.images.collectAsState()

    LaunchedEffect(Unit) {
        filmImagesViewModel.fetchImages(filmId)
    }

    Column {
        Row (modifier = Modifier.padding(start = 26.dp, end = 26.dp), horizontalArrangement = Arrangement.Absolute.SpaceBetween){
            Text(text = "Галерея")
            Text(text = "${images.size}")
        }

        LazyRow(
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(images) { imageUrl ->
                Box(
                    modifier = Modifier
                        .padding(8.dp).height(108.dp).width(192.dp)

                ) {
                    AsyncImage(
                        model = imageUrl.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }



    }
}