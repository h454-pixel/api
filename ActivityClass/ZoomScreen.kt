package com.pinit.kotlinproject.ActivityClass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.widget.ImageView
import com.pinit.kotlinproject.R

class ZoomScreen : AppCompatActivity() {

    private var mScaleGestureDetector: ScaleGestureDetector? = null
    private var mScaleFactor = 1.0f
    private var mImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_screen)

        // initialize the view and the gesture detector
        mImageView = findViewById<ImageView>(R.id.image_zoom)
        mScaleGestureDetector = ScaleGestureDetector(this, ScaleListener())
    }

    // this redirects all touch events in the activity to the gesture detector
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return mScaleGestureDetector!!.onTouchEvent(event)
    }

    private inner class ScaleListener : SimpleOnScaleGestureListener() {
        // when a scale gesture is detected, use it to resize the image
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            mScaleFactor*= scaleGestureDetector.scaleFactor
            mImageView?.setScaleX(mScaleFactor)
            mImageView?.setScaleY(mScaleFactor)
            return true
        }
    }
}
















