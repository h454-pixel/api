package com.pinit.kotlinproject.Adpter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pinit.kotlinproject.ActivityClass.ApIScreen
import com.pinit.kotlinproject.ActivityClass.Article
import com.pinit.kotlinproject.R
import kotlin.collections.ArrayList

class RecyclerAdapter(var context: ApIScreen, private val mList: ArrayList<Article>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.desine_api, parent, false)
        return ViewHolder(view, context)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Article=mList.get(position)
        // sets the image to the imageview from our itemHolder class
        //  holder.imageView.setImageResource(ItemsViewModel.image)
        // sets the text to the textview from our itemHolder class
        holder.textView.text = Article.title
        //holder.imageView.setOnClickListener{
// //            val toast: Toast = Toast.makeText(context,"first", Toast.LENGTH_LONG)
//            toast.show()
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View, context: Context) : RecyclerView.ViewHolder(ItemView) {

        // val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.txt_view_api)
    }

}


