package com.pinit.kotlinproject.ActivityClass
import android.app.Activity
import retrofit2.Retrofit
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import com.pinit.kotlinproject.R
import com.pinit.kotlinproject.Retrofit.Myapi
import com.pinit.kotlinproject.Retrofit.NetworkClient
import okhttp3.*
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.IOException
import java.net.URI
import java.net.URI.create
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import android.provider.MediaStore

import android.graphics.Bitmap
import java.io.FileNotFoundException


class UploadScreen :AppCompatActivity() {

    var filePath = ""
    private val PICK_IMAGE_REQUEST = 1
    private var urimage: Uri? = null
    private var img: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_screen)
       img = findViewById<ImageView>(R.id.imageView2)
        var btn: Button = findViewById<Button>(R.id.button2)

        btn.setOnClickListener {

            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, PICK_IMAGE_REQUEST)


        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data!!.data != null) {
            Toast.makeText(this, "getdata", Toast.LENGTH_SHORT).show()
            urimage = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, urimage)
               img?.setImageBitmap(bitmap)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }



//    private fun uploadImage() {
//        val file = File(filePath)
//        val retrofit: Retrofit? = NetworkClient.getRetrofit()
//        val requestBody: RequestBody = RequestBody.create(MediaType.parse("image/*"), file)
//        val parts = MultipartBody.Part.createFormData("newimage", file.getName(), requestBody)
//        val someData = RequestBody.create(MediaType.parse("text/plain"), "This is a new Image")
//
//            val uploadApis: Myapi = retrofit!!.create( Myapi::class.java)
//            val call: Call<RequestBody?>? = uploadApis.uploadImage(parts, someData)
//            call!!.enqueue(object :retrofit2.Callback<RequestBody?> {
//
//            override fun onResponse(call: Call<RequestBody?>, response: Response<RequestBody?>) {
//                Toast.makeText(this@UploadScreen,"success", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onFailure(call: Call<RequestBody?>, t: Throwable) {
//                Toast.makeText(this@UploadScreen,"unsuccess", Toast.LENGTH_SHORT).show()
//            }
//
//
//        })
//
//
//    }



}
