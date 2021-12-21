package com.pinit.kotlinproject.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.PopupMenu
import com.pinit.kotlinproject.ActivityClass.SwipeToDelete
import com.pinit.kotlinproject.R

class RecyclerAdaperSwipe(var context:SwipeToDelete, private val mList: ArrayList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


      override fun onCreateViewHolder(
          parent: ViewGroup,
          viewType: Int
      ): RecyclerAdapter.ViewHolder {
          val view = LayoutInflater.from(parent.context).inflate(R.layout.desine_api, parent, false)
          return RecyclerAdapter.ViewHolder(view, context)
      }

      override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {



         // holder.
      }

      override fun getItemCount(): Int {
          return mList.size
      }





      class ViewHolder(ItemView: View, var context: Context) : RecyclerView.ViewHolder(ItemView) {

          val txt: TextView = itemView.findViewById(R.id.txt_view_api)
          val img:ImageView =itemView.findViewById(R.id.imageButton_first)

      }
  }