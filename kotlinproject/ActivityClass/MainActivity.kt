package com.pinit.kotlinproject.ActivityClass
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import android.widget.ImageView
import com.pinit.kotlinproject.Adpter.CustomAdapter
import com.pinit.kotlinproject.R

class MainActivity : AppCompatActivity() {

    val animals: ArrayList<String> = ArrayList()
    val myViews : Array<Int> = arrayOf(R.drawable.oil,R.drawable.oil, R.drawable.oil )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_1)
        val viewpager = findViewById<ViewPager>(R.id.view_pager_1)


    }

    class MyAdapter (private val theViews: Array<Int>, private val context: Context) : PagerAdapter() {
        //
        override fun isViewFromObject(view: View, `object`: Any): Boolean
        { //viewpager
         //   viewpager.adapter = MyAdapter(myViews, this@MainActivity)

            // this creates a vertical layout Manager
           /// recyclerView.layoutManager = LinearLayoutManager(this)

            // ArrayList of class ItemsViewModel
            val data = ArrayList<ItemsViewModel>()

            // This loop will create 20 Views containing
            // the image with the count of view
            for (i in 1..20) {
                data.add(ItemsViewModel(R.drawable.oil, "Item " + i))
            }

            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter( this,data)

            // Setting the Adapter with the recyclerview
          //  recyclerView.adapter = adapter

            return view === `object`
        }

        // default method
        override fun getCount(): Int
        {
            return theViews.size
        }

        //
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val inflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view: View = inflater.inflate(R.layout.desine_item, container, false)
            container.addView(view)
            val imageView = view.findViewById<ImageView>(R.id.image_view)
            imageView.setImageResource(theViews.get(position))
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, view: Any)
        {
            container.removeView(view as View)
        }
    }
}