package com.example.instagram.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostPage() {
    var caption by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Box(
            modifier = Modifier
                .size(200.dp)
                .border(1.dp, Color.Gray, RectangleShape),
            contentAlignment = Alignment.Center
        ) {
                AsyncImage(
                    model = "https://visitalmaty.crocos.kz/wp-content/uploads/2022/01/%D0%9A%D0%91%D0%A2%D0%A3-1050x662.jpg",
                    contentDescription = "Selected Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = caption,
            onValueChange = { caption = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Enter caption...") },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = MaterialTheme.shapes.small
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {  },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = "Share")
        }
    }
}
