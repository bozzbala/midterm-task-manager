import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment2.R
import com.example.assignment2.models.Post

class FeedAdapter(private val posts: List<Post>) : RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    // ViewHolder для каждого элемента поста
    class FeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profilePicture: ImageView = itemView.findViewById(R.id.profilePicture)
        val username: TextView = itemView.findViewById(R.id.username)
        val postImage: ImageView = itemView.findViewById(R.id.postImage)
        val likesCount: TextView = itemView.findViewById(R.id.likesCount)
        val postCaption: TextView = itemView.findViewById(R.id.postCaption)
        val viewComments: TextView = itemView.findViewById(R.id.viewComments)
    }

    // Создание нового ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_feed, parent, false)
        return FeedViewHolder(itemView)
    }

    // Привязка данных к ViewHolder
    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val post = posts[position]

        // Устанавливаем данные поста
        holder.username.text = post.username
        holder.profilePicture.setImageResource(post.profileImageRes)
        holder.postImage.setImageResource(post.postImageRes)
        holder.likesCount.text = "${post.likesCount} likes"
        holder.postCaption.text = post.caption

        // Для примера, скрываем комментарии, если их нет
        holder.viewComments.visibility = View.GONE
    }

    // Возвращаем количество элементов
    override fun getItemCount(): Int = posts.size
}
