package com.zobaer53.banking_ui.views.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.zobaer53.banking_ui.R
import com.zobaer53.banking_ui.data.Card
import com.zobaer53.banking_ui.ui.theme.BlueEnd
import com.zobaer53.banking_ui.ui.theme.BlueStart
import com.zobaer53.banking_ui.ui.theme.PurpleEnd
import com.zobaer53.banking_ui.ui.theme.PurpleStart
import kotlin.reflect.KClass


val cards = listOf(
    Card(
        cardName = "visa",
        cardType = "Business",
        balance = 1038.989,
        cardNumber = "23432 23434 2343",
        cardGradient = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardName = "master",
        cardType = "Savings",
        balance = 1038.989,
        cardNumber = "23432 23434 2343",
        cardGradient = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardName = "visa",
        cardType = "Business",
        balance = 1038.989,
        cardNumber = "23432 23434 2343",
        cardGradient = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardName = "master",
        cardType = "Savings",
        balance = 1038.989,
        cardNumber = "23432 23434 2343",
        cardGradient = getGradient(BlueStart, BlueEnd)
    ),
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(colors = listOf(startColor, endColor))
}


@Preview
@Composable
fun CardsSection() {

    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }

}

@Composable
fun CardItem(index: Int) {
    var card = cards[index]

    var paddingEnd = 0.dp
    if (index.equals(cards.lastIndex)) paddingEnd = 16.dp

    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardName.equals("master")) image = painterResource(id = R.drawable.ic_mastercard)


    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = paddingEnd)
    )
    {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.cardGradient)
                .width(250.dp)
                .height(168.dp)
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.width(60.dp),
                painter = image,
                contentDescription = card.cardName
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = card.cardType,
                color = Color.White,
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$ ${card.balance}",
                color = Color.White,
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = TextUnit.Unspecified,
                fontWeight = FontWeight.Bold
            )

        }

    }


}
