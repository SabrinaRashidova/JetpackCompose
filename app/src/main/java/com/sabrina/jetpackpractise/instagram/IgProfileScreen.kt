package com.sabrina.jetpackpractise.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sabrina.jetpackpractise.instagram.ImageWithText
import com.sabrina.jetpackpractise.R

@Composable
fun IgProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 6.dp)
    ) {
        TopBar(name = "sabrina_r_official ")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            highlights = listOf(
                ImageWithText(
                    image = painterResource(R.drawable.ic_youtube),
                    text = "YouTube"
                ),
                ImageWithText(
                    image = painterResource(R.drawable.pinterest),
                    text = "Pinterest"
                ),
                ImageWithText(
                    image = painterResource(R.drawable.ic_discord),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(R.drawable.ic_tg),
                    text = "Telegram"
                )
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithTexts = listOf(
                ImageWithText(
                    image = painterResource(R.drawable.ic_grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(R.drawable.ic_reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(R.drawable.ic_igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(R.drawable.profile),
                    text = "Profile "
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostSection(
                posts = listOf(
                    painterResource(R.drawable.flower1),
                    painterResource(R.drawable.flower3),
                    painterResource(R.drawable.flower5),
                    painterResource(R.drawable.flower6),
                    painterResource(R.drawable.flower1),
                    painterResource(R.drawable.flower3),
                    painterResource(R.drawable.flower5),
                    painterResource(R.drawable.flower6),

                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(R.drawable.ic_bell),
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            painter = painterResource(R.drawable.ic_dotmenu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(R.drawable.judy),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            StatSection(
                modifier = Modifier.weight(7f)
            )
        }
        ProfileDescription(
            displayName = "Sabrina's Blog",
            description = " \uD83C\uDF3C You deserve a little sunshine.\n Handpicked flowers delivered to your door. \uD83D\uDC90\n Order yours",
            url = "https://flowers.com/sabrinas'flowers",
            followedBy = listOf("Us flowers", "Fresh Flowers"),
            otherCount = 17
        )
    }
}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat("204", "Posts")
        ProfileStat("100k", "Followers")
        ProfileStat("64", "Following")
    }
}

@Composable
fun ProfileStat(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
        )
    }
}


@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int,
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(height)
                .height(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}


@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithTexts: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit,
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        contentColor = Color.Black
    ) {
        imageWithTexts.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
 ) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)
    ) {
        items(posts.size){
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}