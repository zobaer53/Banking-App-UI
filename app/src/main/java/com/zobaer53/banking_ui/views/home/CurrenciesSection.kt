package com.zobaer53.banking_ui.views.home

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowCircleDown
import androidx.compose.material.icons.rounded.ArrowCircleUp
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zobaer53.banking_ui.data.Curriencies
import com.zobaer53.banking_ui.ui.theme.GreenStart


val currencies = listOf(
    Curriencies(
        name = "USD",
        buy = 23.34f,
        sell = 34.34f,
        icon = Icons.Rounded.AttachMoney
    ),
    Curriencies(
        name = "EUR",
        buy = 23.34f,
        sell = 34.34f,
        icon = Icons.Rounded.Euro
    ),
    Curriencies(
        name = "USD",
        buy = 23.34f,
        sell = 34.34f,
        icon = Icons.Rounded.AttachMoney
    ),
    Curriencies(
        name = "EUR",
        buy = 23.34f,
        sell = 34.34f,
        icon = Icons.Rounded.Euro
    ),
)

@Preview
@Composable
fun CurrenciesSection() {

    var isVisible by remember {
        mutableStateOf(false)
    }


    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }



    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable {
                        isVisible = !isVisible
                        iconState = if (!isVisible) Icons.Rounded.ArrowCircleDown
                        else Icons.Rounded.ArrowCircleUp
                    }) {
                    Icon(
                        imageVector = iconState, contentDescription = null,
                        modifier = Modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                )

            }

            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(
                            RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                        )
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstrains =
                        this // BoxWithConstraints goves access to this which can be used to divide space of box
                    val width = boxWithConstrains.maxWidth / 3

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        //Spacer(modifier = Modifier.height(15.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                modifier = Modifier.width(width), text = "Currency",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                modifier = Modifier.width(width), text = "Buy",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.End,
                                color = MaterialTheme.colorScheme.onBackground
                            )

                            Text(
                                modifier = Modifier.width(width), text = "Sell",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                textAlign = TextAlign.End,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        LazyColumn {
                            items(currencies.size) {
                                CurrencyItem(it, width)
                            }
                        }

                    }

                }
            }
        }
    }


}


@Composable
fun CurrencyItem(index: Int,width:Dp) {
    val currency = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .width(width)
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier
                    .padding(start = 16.dp), text = currency.name, fontWeight = FontWeight.Bold
            )
        }

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp, bottom = 16.dp), textAlign = TextAlign.End, text = "$ ${currency.buy}", fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp, bottom = 16.dp), textAlign = TextAlign.End,text = "$ ${currency.sell}", fontWeight = FontWeight.Bold
        )



}
}











