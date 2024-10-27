package com.example.instagram.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip

@Composable
fun NotificationsPage() {
    val notifications = getSampleNotifications()

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Notifications",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        LazyColumn {
            items(notifications) { notification ->
                NotificationItem(notification)
            }
        }
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {  },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(text = notification.userName.first().toString(), color = Color.White)
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = "${notification.userName} ${notification.type.name.lowercase()}d your post.", fontWeight = FontWeight.Bold)
            Text(text = notification.timestamp, style = MaterialTheme.typography.bodySmall)
        }
    }
}


data class Notification(
    val id: Int,
    val userName: String,
    val type: NotificationType,
    val postId: Int,
    val timestamp: String
)

enum class NotificationType {
    LIKE,
    COMMENT
}

fun getSampleNotifications(): List<Notification> {
    return listOf(
        Notification(1, "Aruzhan", NotificationType.LIKE, 101, "2 minutes ago"),
        Notification(2, "Olzhas", NotificationType.COMMENT, 102, "10 minutes ago"),
        Notification(3, "Temirlan", NotificationType.LIKE, 103, "30 minutes ago"),
        Notification(4, "Uncle", NotificationType.LIKE, 103, "45 minutes ago"),
        Notification(5, "Dad", NotificationType.LIKE, 103, "46 minutes ago"),
        Notification(6, "Berik", NotificationType.COMMENT, 104, "1 hour ago")
    )
}
