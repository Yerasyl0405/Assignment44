package com.example.finalassignment3.ThridTask

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ImageList( navController: NavController) {

    LazyColumn (verticalArrangement = Arrangement.spacedBy(36.12.dp) , modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(top = 97.dp)){
        items(1){
            Header()
        }
        items(6) { index->
            ListImages(item= getData(), index,navController)

        }}
}
