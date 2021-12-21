package com.pinit.kotlinproject.Adpter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pinit.kotlinproject.ActivityClass.ItemsViewModel
import com.pinit.kotlinproject.R

import com.pinit.kotlinproject.ActivityClass.MainActivity

class CustomAdapter(var context: MainActivity.MyAdapter, private var mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewpager_first, parent, false)

        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)
        // sets the text to the textview from our itemHolder class
        holder.textView.text = ItemsViewModel.text



        // set the data in items
        holder.textView.setText(mList.get(position) as String)
        holder.textView.setOnClickListener(View.OnClickListener {
//         //   val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
//            alertDialogBuilder.setTitle("Confirm Exit..!!!")
//            // Icon Of Alert Dialog
//            //   alertDialogBuilder.setIcon(R.drawable.question);
//            // Setting Alert Dialog Message
//            alertDialogBuilder.setMessage("Are you sure,You want to exit")
//            alertDialogBuilder.setCancelable(false)
//            alertDialogBuilder.setPositiveButton("Yes",
//                DialogInterface.OnClickListener { arg0, arg1 -> deleteItem(position) })
//            alertDialogBuilder.setNegativeButton("No",
//                DialogInterface.OnClickListener { dialog, which ->
//                   // Toast.makeText(context, "You clicked over No", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                })
//            val alertDialog: AlertDialog = alertDialogBuilder.create()
//            alertDialog.show()
        })
    }


    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    fun deleteItem(index: Int) {
       //mList.r
        notifyItemRemoved(index)
    }


    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

}



