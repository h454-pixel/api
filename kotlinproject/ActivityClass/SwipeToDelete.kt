package com.pinit.kotlinproject.ActivityClass
import android.R.attr
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.pinit.kotlinproject.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.snackbar.Snackbar
import com.pinit.kotlinproject.Adpter.RecyclerAdaperSwipe
import androidx.annotation.NonNull
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import android.R.attr.direction




class SwipeToDelete : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var mAdapter: RecyclerAdaperSwipe? = null
    var stringArrayList: ArrayList<String> = ArrayList()
    var coordinatorLayout: CoordinatorLayout? = null
    private val view: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_to_delete)
        coordinatorLayout = findViewById(R.id.coordinatorLayout_1)
        recyclerView = findViewById(R.id.recyclerView_swipe);

        stringArrayList.add("Student 1")
        stringArrayList.add("Student 2")
        stringArrayList.add("Student 3")
        stringArrayList.add("Student 4")
        stringArrayList.add("Student 5")
        stringArrayList.add("Student 6")
        stringArrayList.add("Student 7")
        stringArrayList.add("Student 8")
        stringArrayList.add("Student 9")
        stringArrayList.add("Student 10")
        mAdapter = RecyclerAdaperSwipe(this, stringArrayList)
        recyclerView!!.adapter = mAdapter

        // below line is to set layout manager for our recycler view.
        val manager = LinearLayoutManager(this)
        recyclerView!!.setLayoutManager(manager)

        // setting layout manager for our recycler view.


        // below line is to set adapter
        // to our recycler view.

        // on below line we are creating a method to create item touch helper
        // method for adding swipe to delete functionality.
        // in this we are specifying drag direction and position to right
//        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//                // this method is called
//                // when the item is moved.
//                return false
//            }
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                // this method is called when we swipe our item to right direction.
//                // on below line we are getting the item at a particular position.
//                // below line is to get the position
//                // of the item at that position.
//                val position = viewHolder.adapterPosition
//                if (attr.direction == ItemTouchHelper.LEFT) {
//                    mAdapter!!.removeItem(position)
//                   // stringArrayList.removeAt(viewHolder.adapterPosition)
//
//                } else {
//
//                }
//
//
//                // this method is called when item is swiped.
//                // below line is to remove item from our array list.
//              //  stringArrayList.removeAt(viewHolder.adapterPosition)
//
//                // below line is to notify our item is removed from adapter.
//              mAdapter!!.notifyItemRemoved(viewHolder.adapterPosition)
//
//                // below line is to display our snackbar with action.
//                Snackbar.make(recyclerView!!, "", Snackbar.LENGTH_LONG).setAction("Undo", object : View.OnClickListener {
//                        override fun onClick(v: View?) {
//                            // adding on click listener to our action of snack bar.
//                            // below line is to add our item to array list with a position.
//                            stringArrayList!!.add(position.toString())
//
//                            // below line is to notify item is
//                            // added to our adapter class.
//                         //   stringArrayList?.notifyItemInserted(position)
//                        }
//                    }).show()
//            } // at last we are adding this
//
//
//
//
//            // to our recycler view.
//        }).attachToRecyclerView(recyclerView)







    }





        // initializing our adapter class with our array list and context.

    }



































//    private fun populateRecyclerView() {
//
//    }

//    private fun enableSwipeToDeleteAndUndo() {
//        val SwipeToDeleteCallback: SwipeToDeleteCallback = object :SwipeToDeleteCallback(this) {
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
//                val position = viewHolder.adapterPosition
//                val item: String = (mAdapter?.getData()?.get(position) ?: mAdapter?.removeItem(position)) as String
//                val snackbar = coordinatorLayout?.let {
//                    Snackbar
//                        .make(
//                            it,
//                            "Item was removed from the list.",
//                            Snackbar.LENGTH_LONG
//                        )
//                }
//                snackbar?.setAction("UNDO") {
//                    mAdapter?.restoreItem(item, position)
//                    recyclerView!!.scrollToPosition(position)
//                }
//                snackbar?.setActionTextColor(Color.YELLOW)
//                snackbar?.show()
//            }
//        }
//        val itemTouchhelper = ItemTouchHelper(SwipeToDeleteCallback)
//        itemTouchhelper.attachToRecyclerView(recyclerView)
//    }



