package com.example.foodappgamb.Activity.Dashboard

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.foodappgamb.Activity.Cart.CartActivity
import com.example.foodappgamb.R

@Composable
fun MyBottomBar(

){
    val bottomMenuItemsList= prepareBottomMenu()
    val context= LocalContext.current
    var selectedItem by remember{ mutableStateOf("Дом")}


    BottomAppBar (
        backgroundColor = colorResource(R.color.grey),
        elevation = 3.dp
    ){
        bottomMenuItemsList.forEach{bottomMenuItem->
            BottomNavigationItem(
                selected = (selectedItem==bottomMenuItem.label),
                onClick = {
                    selectedItem=bottomMenuItem.label
                    if (bottomMenuItem.label=="Корзина"){
                        context.startActivity(Intent(context,CartActivity::class.java))
                    }else{
                        Toast.makeText(context,bottomMenuItem.label,Toast.LENGTH_LONG).show()
                    }
                },
                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top=8.dp)
                            .size(20.dp)
                    )
                }

            )
        }
    }
}

data class BottomMenuItem(
    val label:String,
    val icon:Painter
)

@Composable
fun prepareBottomMenu():List<BottomMenuItem>{
    val bottomMenuItemList= arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(BottomMenuItem(label = "Дом", icon = painterResource(R.drawable.btn_1)))
    bottomMenuItemList.add(BottomMenuItem(label = "Корзина", icon = painterResource(R.drawable.btn_2)))
    bottomMenuItemList.add(BottomMenuItem(label = "Любимые", icon = painterResource(R.drawable.btn_3)))
    bottomMenuItemList.add(BottomMenuItem(label = "Заказы", icon = painterResource(R.drawable.btn_4)))
    bottomMenuItemList.add(BottomMenuItem(label = "Профиль", icon = painterResource(R.drawable.btn_5)))

    return bottomMenuItemList
}