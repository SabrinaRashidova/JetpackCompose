package com.sabrina.jetpackpractise

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ProfilePage() {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(6.dp))
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (image, nameText,countryText,rowStats,buttonFollow,buttonMessage) = createRefs()
            val guideLine = createGuidelineFromTop(0.1f)

            Image(
                painter = painterResource(R.drawable.androidparty), contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = CircleShape
                    )
                    .constrainAs(image) {
                        top.linkTo(guideLine, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                contentScale = ContentScale.Crop
            )

            Text(
                "Task Completed",
                modifier = Modifier.constrainAs(nameText) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }.padding(top = 8.dp))
            Text("Germany",
                modifier = Modifier.constrainAs(countryText) {
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)}
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(rowStats){
                        top.linkTo(countryText.bottom)
                    }
            ) {
                ProfileStats("150", "Followers")
                ProfileStats("100", "Following")
                ProfileStats("30", "Posts")
            }

            Button(onClick = {},
                modifier = Modifier.constrainAs(buttonFollow){
                    top.linkTo(rowStats.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(buttonMessage.start)
                }) {
                Text("Follow user")
            }
            Button(onClick = {},
                modifier = Modifier.constrainAs(buttonMessage){
                    top.linkTo(rowStats.bottom, margin = 16.dp)
                    start.linkTo(buttonFollow.end)
                    end.linkTo(parent.end)
                    }){
                Text("Direct message")
            }
        }
    }
}

@Composable
fun ProfileStats(count: String, title: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(count, fontWeight = FontWeight.Bold)
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}