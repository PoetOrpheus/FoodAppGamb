package com.example.foodappgamb.Activity.Spash

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodappgamb.R

@Composable
fun GetStartedButtons(
    onClick:()->Unit,
    modifier: Modifier
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ){
        Button(
            onClick={},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(50.dp),
            modifier = modifier
                .padding(end=16.dp)
                .fillMaxWidth(0.35f)
                .border(1.dp, Color.White,shape= RoundedCornerShape(50.dp))
                .height(50.dp)
            ) {
            Text(
                text = "Регистрация",
                fontSize = 13.sp,
                color = Color.White
            )
        }

        Button(
            onClick={onClick()},
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.orange)),
            shape = RoundedCornerShape(50.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Начать",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}