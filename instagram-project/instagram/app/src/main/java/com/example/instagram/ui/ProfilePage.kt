import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.instagram.R

@Composable
fun ProfilePage(
    profilePictureUrl: String,
    userName: String,
    bio: String,
    postsCount: Int,
    posts: List<String>
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item{
            TopAppBar()
        }
        item {
            ProfileHeader(
                profilePictureUrl = profilePictureUrl,
                userName = userName,
                bio = bio,
                postsCount = postsCount
            )
        }
        item {
            ProfileActionButtons()
        }

        item {
            HighlightStories()
        }

        items((posts.size + 2) / 3) { rowIndex ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                for (columnIndex in 0 until 3) {
                    val postIndex = rowIndex * 3 + columnIndex
                    if (postIndex < posts.size) {
                        AsyncImage(
                            model = posts[postIndex],
                            contentDescription = "Post $postIndex",
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .clip(RectangleShape),
                            contentScale = ContentScale.Crop
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}


@Composable
fun ProfileHeader(
    profilePictureUrl: String,
    userName: String,
    bio: String,
    postsCount: Int
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AsyncImage(
                model = profilePictureUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$postsCount", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                Text(text = "Posts", style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "5k", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                Text(text = "Followers", style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold))
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "14", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                Text(text = "Following", style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold))
            }

            Spacer(modifier = Modifier.width(16.dp))

        }
        Text(
            text = "Pacifist",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun HighlightStories() {
    LazyRow(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(5) { index ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = "https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                    contentDescription = "Highlight $index",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                )
                Text(text = "Highlight $index", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    val samplePosts = List(12) { "https://thumbs.dreamstime.com/b/excited-african-american-man-pointing-finger-background-template-text-stock-photo-149317403.jpg" } // Example images
    ProfilePage(
        profilePictureUrl = "https://i.pinimg.com/236x/68/31/12/68311248ba2f6e0ba94ff6da62eac9f6.jpg",
        userName = "Bunny Bun",
        bio = "Moneyken",
        postsCount = 120,
        posts = samplePosts
    )
}


@Composable
fun ProfileActionButtons() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                ),
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Edit Profile")
            }
            OutlinedButton(
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black
                ),
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Share Profile")
            }
        }
}

@Composable
fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Temirlan",
            fontSize = 20.sp
        )
        Row {
            IconButton(
                onClick = {  } ,
                modifier = Modifier.size(34.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.plus_square_line_icon),
                    contentDescription = "Add",
                    modifier = Modifier.size(24.dp)
                )

            }
            IconButton(
                onClick = {  },
                modifier = Modifier.size(34.dp)
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        }

    }
}