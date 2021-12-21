package com.pinit.kotlinproject.ActivityClass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.chrisbanes.photoview.PhotoView
import com.pinit.kotlinproject.R

class zoom2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom2)

        val photoView = findViewById<View>(R.id.img_z) as PhotoView
        photoView.setImageResource(R.drawable.oil)
    }
}