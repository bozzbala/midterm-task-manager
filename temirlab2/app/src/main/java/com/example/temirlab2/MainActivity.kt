package com.example.temirlab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.temirlab2.ui.theme.Temirlab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Home()
                }
            }
        }
    }
}

// Opt-in to use experimental Material 3 API
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(){
    // Create a top app bar
    TopAppBar(
        // Set the title of the app bar
        title = {
            Text(
                "Instagram", // The text to display
                fontFamily = lobster, // Use the custom font family "lobster"
                fontWeight = FontWeight.Bold, // Set the font weight to bold
                fontSize = 25.sp, // Set the font size to 25sp
            )
        },
        // Define the actions to include in the app bar
        actions = {
            // Create an icon button with a heart icon
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable._025703_heart_icon), // Use the heart icon resource
                    contentDescription = "Heart Icon", // Provide a description for accessibility
                    modifier = Modifier.size(24.dp) // Set the size of the icon to 24dp
                )
            }
            // Create an icon button with a messenger icon
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(R.drawable._959746_chat_communication_facebook_messenger_icon), // Use the messenger icon resource
                    contentDescription = "Messenger Icon", // Provide a description for accessibility
                    modifier = Modifier.size(24.dp) // Set the size of the icon to 24dp
                )
            }
        }
    )
}

@Composable
fun BottomNavigationBar() {
    // Create a bottom app bar
    BottomAppBar {
        // Create a row to hold the icons
        Row(
            modifier = Modifier.fillMaxWidth(), // Fill the width of the parent
            horizontalArrangement = Arrangement.SpaceEvenly // Arrange the icons evenly
        ) {
            // Create an icon button for home
            IconButton(onClick = { /* do something */ }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(R.drawable._912908791641180048), contentDescription = "Home Icon", modifier = Modifier.size(25.dp))
                }
            }
            // Create an icon button for search
            IconButton(onClick = { /* do something */ }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(R.drawable.search_line_icon), contentDescription = "Search Icon", modifier = Modifier.size(25.dp))
                }
            }
            // Create an icon button for add
            IconButton(onClick = { /* do something */ }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(painter = painterResource(R.drawable.plus_square_line_icon), contentDescription = "Add Icon", modifier = Modifier.size(25.dp))
                }
            }
            // Create an icon button for media
            IconButton(onClick = { /* do something */ }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Icon(painter = painterResource(R.drawable._6977127916352314864510), contentDescription = "Media Icon", modifier = Modifier.size(28.dp))
                }
            }
            // Create an icon button for profile picture
            IconButton(onClick = { /* do something */ }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    AsyncImage(
                        model = "https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8UGVvcGxlfGVufDB8fDB8fHww",
                        contentDescription = null,
                        modifier = Modifier
                            .size(27.dp)
                            .clip(CircleShape) // Clip the image to a circle shape
                            .border(
                                width = 2.dp,
                                brush = Brush.linearGradient(
                                    colors = listOf(Color.Yellow, Color.Red),
                                    start = Offset(0f, 0f),
                                    end = Offset(70f, 70f)
                                ),
                                shape = CircleShape
                            )
                            .clickable(onClick = {}), // Make the image clickable
                        contentScale = ContentScale.Crop // Crop the image to fill the size of the ImageView
                    )
                }
            }
        }
    }
}