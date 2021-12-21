package com.pinit.kotlinproject.ActivityClass
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pinit.kotlinproject.Adpter.RecyclerAdapter
import com.pinit.kotlinproject.ApiModel.NewsModel
import com.pinit.kotlinproject.R
import com.pinit.kotlinproject.Retrofit.Myapi
import com.pinit.kotlinproject.Retrofit.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class ApIScreen : AppCompatActivity() {

    var api: Myapi? = null
    var newsList = ArrayList<Article>()
    var recyclerView: RecyclerView? = null
    var recyclerAdapter: RecyclerAdapter? = null
    var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ap_iscreen)
        recyclerView = findViewById<View>(R.id.rcy_view) as RecyclerView
        progressBar = findViewById<View>(R.id.progress_circular_1) as ProgressBar
        progressBar!!.visibility = View.VISIBLE
        recyclerAdapter = RecyclerAdapter(this, newsList)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.setAdapter(recyclerAdapter)

        api = RetroClient.getApiService()


        val newsCall: Call<NewsModel?>? = api?.getList("techcrunch","49c3c9be3cda4ebf986c1215fa83da55")


        newsCall?.enqueue(object : Callback<NewsModel?> {

            override fun onResponse(call: Call<NewsModel?>, response: Response<NewsModel?>) {
                //  if (response.code()                                                                    == 200 && response.body().getArticles() != null) {
                if (response.isSuccessful && response.code()==200) {
                    // Log.d("resopnse running",""+String().length)
                    newsList.clear()
                    response.body()?.articles?.let { newsList.addAll(it) }
                    recyclerAdapter!!.notifyDataSetChanged()
                    Toast.makeText(this@ApIScreen ,"success", Toast.LENGTH_SHORT).show()
                    progressBar!!.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<NewsModel?>, t: Throwable) {
                progressBar!!.visibility = View.GONE
                Toast.makeText(this@ApIScreen, "unsucces" + t.message, Toast.LENGTH_SHORT).show()
            }
        })


    }

}
