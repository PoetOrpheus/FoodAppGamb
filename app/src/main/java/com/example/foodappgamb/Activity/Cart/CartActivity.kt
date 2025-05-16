package com.example.foodappgamb.Activity.Cart

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodappgamb.Activity.BaseActivity
import com.example.foodappgamb.R
import com.uilover.project2142.Helper.ManagmentCart

class CartActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CartScreen(
            ManagmentCart(this),
            onBackClick = {finish()}
        )}
    }
}

@Composable
fun CartScreen(
    managnmentCart:ManagmentCart= ManagmentCart(LocalContext.current),
    onBackClick:()->Unit,
){
    val cartItem=remember {(mutableStateOf(managnmentCart.getListCart()))}
    val tax= remember { mutableStateOf(0.0) }
    calculatorCart(managnmentCart,tax)

    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        item{
            ConstraintLayout(
                modifier = Modifier.padding(top = 36.dp)
            ) {
                val (backBtn,cartTxt)=createRefs()
                Text(
                    text ="Твоя корзина",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(cartTxt) { centerTo(parent) }
                )
                Image(
                    painter = painterResource(R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .constrainAs(backBtn) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickable { onBackClick() }
                )
            }
        }
        if (cartItem.value.isEmpty()) {
            item {
                Text(
                    text = "Корзина пуста",
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        } else {
            items(cartItem.value) {item->
                CartItem(
                    cartItems = cartItem.value,
                    item=item,
                    managmentCart=managnmentCart,
                    onItemChange = {
                        calculatorCart(managnmentCart,tax)
                        cartItem.value=ArrayList(managnmentCart.getListCart())
                    }
                )
            }

            item {
                Text(
                    "Заказ на сумму ",
                    color= colorResource(R.color.darkPurple),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            item {
                CartSummary(
                    itemTotal = managnmentCart.getTotalFee(),
                    tax=tax.value,
                    delivery = 10.0
                )
            }

            item {
                Text(
                    "Информация",
                    color= colorResource(R.color.darkPurple),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            item {
                DeliveryInfoBox()
            }
        }
    }


}

fun calculatorCart(managnmentCart: ManagmentCart,tax:MutableState<Double>){
    val percentTax=0.02
    tax.value=Math.round((managnmentCart.getTotalFee()*percentTax)*100)/100.0

}