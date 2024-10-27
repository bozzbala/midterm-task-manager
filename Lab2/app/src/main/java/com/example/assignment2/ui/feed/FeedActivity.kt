import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.models.Post

class FeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_feed)

        // Найдем RecyclerView
        val recyclerViewFeed = findViewById<RecyclerView>(R.id.recyclerViewFeed)

        // Установим LayoutManager
        recyclerViewFeed.layoutManager = LinearLayoutManager(this)

        // Пример mock данных
        val posts = listOf(
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_image_placeholder, "Caption 1", 120),
            Post("user2", R.drawable.ic_profile_placeholder, R.drawable.ic_image_placeholder, "Caption 2", 95),
            Post("user3", R.drawable.ic_profile_placeholder, R.drawable.ic_image_placeholder, "Caption 3", 200)
        )

        // Устанавливаем адаптер
        recyclerViewFeed.adapter = FeedAdapter(posts)
    }
}