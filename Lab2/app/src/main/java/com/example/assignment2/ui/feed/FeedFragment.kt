import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.models.Post

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_home_feed, container, false)

        val recyclerViewFeed = view.findViewById<RecyclerView>(R.id.recyclerViewFeed)
        recyclerViewFeed.layoutManager = LinearLayoutManager(requireContext())

        // Пример данных
        val posts = listOf(
            Post("user1", R.drawable.ic_profile_placeholder, R.drawable.ic_image_placeholder, "Caption 1", 120),
            Post("user2", R.drawable.ic_profile_placeholder, R.drawable.ic_image_placeholder, "Caption 2", 95)
        )

        recyclerViewFeed.adapter = FeedAdapter(posts)

        return view
    }
}
