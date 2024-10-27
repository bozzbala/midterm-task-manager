package com.example.instagram.ui
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SearchPage() {
    var query by remember { mutableStateOf("") }
    val searchResults = remember { listOf("Temirlan", "Aruzhan", "Olzhas") }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(query = query, onQueryChange = { query = it })

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.padding(start = 16.dp),
            text = "Recent",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(searchResults.filter { it.contains(query, ignoreCase = true) }) { user ->
                UserProfileItem(userName = user)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        placeholder = { Text(text = "Search") },
        colors = TextFieldDefaults.colors(),
        shape = MaterialTheme.shapes.small
    )
}

@Composable
fun UserProfileItem(userName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjspNyVZ_RBiG68niLT-38T93kitl5Qk5nNw&s", // Placeholder URL
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = userName, style = MaterialTheme.typography.bodyMedium)
        }

        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Remove User",
                tint = Color.Black
            )
        }
    }
}
