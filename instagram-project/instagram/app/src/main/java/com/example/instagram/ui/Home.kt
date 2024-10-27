package com.mad.instagramclone.ui

import ProfilePage
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.instagram.R
import com.example.instagram.ui.theme.InstagramTheme
import androidx.navigation.compose.*
import com.example.instagram.ui.AddPostPage
import com.example.instagram.ui.NotificationsPage
import com.example.instagram.ui.SearchPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController){
    Scaffold(
        topBar = { HomeAppBar(navController) },
        bottomBar = { BottomNavigationBar(navController) }
    ) {paddingValues ->

        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
            Column {
                Row(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp,
                            start = 16.dp,
                            end = 0.dp
                        )
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    YourStory(
                        imageUrl = "https://thispersonnotexist.org/static/img/Random_female_face_1.jpeg",
                        name = "Your Story"
                    )
                    Story(
                        imageResId = R.drawable.photo,
                        name = "Madina"
                    )
                    Story(
                        imageResId = R.drawable.photo,
                        name = "Olzhas"
                    )
                    Story(
                        imageResId = R.drawable.photo,
                        name = "Aruzhan"
                    )
                    Story(
                        imageResId = R.drawable.photo,
                        name = "Temirlan"
                    )
                }

                HomeMainContent()

                HomeMainContent()

                HomeMainContent()

            }


        }

    }


}

@Composable
fun HomeMainContent(){
    Surface(modifier = Modifier.padding(top=6.dp, bottom = 6.dp)) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 6.dp, end = 6.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                ) {
                    AsyncImage(
                        model = "https://myasgeographyaqa.wordpress.com/wp-content/uploads/2016/09/paris-at-night.jpg?w=1400",
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                brush = Brush.linearGradient(
                                    colors = listOf(Color.Yellow, Color.Red),
                                    start = Offset(0f, 0f),
                                    end = Offset(70f, 70f)
                                ),
                                shape = CircleShape
                            )
                            .clickable(onClick = {}),
                        contentScale = ContentScale.Crop
                    )
                }

                Column(
                    Modifier
                        .weight(6f)
                        .padding(end = 16.dp)
                ) {
                    Text(
                        text = "Turan",
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp
                    )
                    Text(
                        text = "Kanye West - Stronger",
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp
                    )
                }
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    Icon(Icons.Default.MoreVert,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp))
                }
            }

            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .fillMaxWidth(),

            ) {
                val images = listOf(
                    "https://images.ctfassets.net/hrltx12pl8hq/3Mz6t2p2yHYqZcIM0ic9E2/3b7037fe8871187415500fb9202608f7/Man-Stock-Photos.jpg",
                    "https://st.depositphotos.com/1518767/1390/i/450/depositphotos_13909347-stock-photo-young-employee-standing-upright-in.jpg",
                )

                ImageScrollWithTextOverlay(images)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(R.drawable.heart_thin_icon),
                            contentDescription = "Like Icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(R.drawable.instagram_comment_icon),
                            contentDescription = "Comment Icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(R.drawable.instagram_share_icon),
                            contentDescription = "Share Icon",
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(R.drawable.saved_icon),
                        contentDescription = "Save Icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Column(modifier = Modifier.padding(
                start = 10.dp,
                end = 10.dp,
                top = 1.dp,
                bottom =4.dp
            )) {
                Row{
                    Text(
                        text = "102 likes",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }

                Row{
                    Text(
                        text = "Turan ",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Find people",
                        fontWeight = FontWeight.Normal,
                        fontSize = 13.sp
                    )
                }

                Row{
                    Text(text = "view all 20 comments",
                        fontWeight = FontWeight.Thin,
                        fontSize = 13.sp
                    )
                }

                Row{
                    Text(text = "5 minutes ago",
                        fontWeight = FontWeight.Thin,
                        fontSize = 13.sp
                    )
                }
            }



        }
    }
}

@Composable
fun ImageScrollWithTextOverlay(images: List<String>) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    images.forEachIndexed { index, imageUrl ->
        Box(
            modifier = Modifier
                .width(screenWidth.dp)
                .aspectRatio(1f)
        ) {

            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )


            Text(
                text = "${index + 1}/${images.size}",
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(navController: NavHostController){
    TopAppBar(
        title = {
            Text(
                "Instagram",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
            )
        },
        actions = {
            IconButton(onClick = { navController.navigate("notifications") }) {
                Icon(
                    painter = painterResource(R.drawable._025703_heart_icon),
                    contentDescription = "Heart Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable._959746_chat_communication_facebook_messenger_icon),
                    contentDescription = "Messenger Icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    )
}



@Composable
fun YourStory(imageUrl: String, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clickable(onClick = {})
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Icon(
                Icons.Default.AddCircle,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                tint = Color(0xFF2196F3)
            )
        }

        Text(
            text = name,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    }
}



@Composable
fun Story(imageResId: Int, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = name,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeAppBarPreview(){
    InstagramTheme {
        val navController = rememberNavController()
        HomeAppBar(navController)
    }
}


@Preview(showBackground = true)
@Composable
fun HomePreview(){
    InstagramTheme {
        val navController = rememberNavController()
        Home(navController)
    }
}

@Preview
@Composable
fun HomeDarkPreview(){
    InstagramTheme(darkTheme = true) {
        val navController = rememberNavController()
        Home(navController)
    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = { navController.navigate("home") }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(R.drawable._912908791641180048), contentDescription = "Home Icon", modifier = Modifier.size(25.dp))
                }
            }
            IconButton(onClick = { navController.navigate("search") }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(R.drawable.search_line_icon), contentDescription = "Search Icon", modifier = Modifier.size(25.dp))
                }
            }
            IconButton(onClick = { navController.navigate("add")}) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(R.drawable.plus_square_line_icon), contentDescription = "Add Icon", modifier = Modifier.size(25.dp))
                }
            }
            IconButton(onClick = { }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Icon(painter = painterResource(R.drawable._6977127916352314864510), contentDescription = "Media Icon", modifier = Modifier.size(28.dp))
                }
            }
            IconButton(onClick = { navController.navigate("profile")  }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = "https://st.depositphotos.com/1518767/1390/i/450/depositphotos_13909347-stock-photo-young-employee-standing-upright-in.jpg",
                        contentDescription = null,
                        modifier = Modifier
                            .size(27.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                brush = Brush.linearGradient(
                                    colors = listOf(Color.Yellow, Color.Red),
                                    start = Offset(0f, 0f),
                                    end = Offset(70f, 70f)
                                ),
                                shape = CircleShape
                            )
                            ,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InstagramNavHost() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { Home(navController) }
            composable("profile") {
                ProfilePage(
                    profilePictureUrl = "https://st.depositphotos.com/1518767/1390/i/450/depositphotos_13909347-stock-photo-young-employee-standing-upright-in.jpg",
                    userName = "Maksat Marat",
                    bio = "Enthusiast, developer, philantrope",
                    postsCount = 12,
                    posts = List(12) { "https://t4.ftcdn.net/jpg/02/24/86/95/360_F_224869519_aRaeLneqALfPNBzg0xxMZXghtvBXkfIA.jpg" }
                )
            }
            composable("search") {
                SearchPage()
            }
            composable("add") {
                AddPostPage()
            }
            composable("notifications") {
                NotificationsPage()
            }
        }
    }
}

