package com.example.foodappgamb.Activity.DetailEachFood

import android.content.ClipDescription
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodappgamb.R

@Composable
fun DescriptionSection(
    description: String
){
    Column {
        Text(
            text = "Описание товара",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.darkPurple),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Text(
            text = description,
            fontSize = 16.sp,
            color = colorResource(R.color.darkPurple),
            modifier = Modifier.padding(16.dp)
        )
    }
}