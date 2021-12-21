package com.pinit.kotlinproject.Retrofit
import com.pinit.kotlinproject.ApiModel.NewsModel
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import okhttp3.RequestBody
import retrofit2.http.POST
import retrofit2.http.Multipart
//https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=49c3c9be3cda4ebf986c1215fa83da55

interface Myapi {

    @GET("top-headlines")
    fun getList(@Query("sources") limit: String?,@Query("apiKey") limit2: String?): Call<NewsModel?>?

    @Multipart
    @POST("upload_image.php")
    suspend fun uploadFile(@Part body: MultipartBody.Part)

    @Multipart
    @POST("upload")
    fun uploadImage(@Part part: MultipartBody.Part?, @Part("somedata") requestBody: RequestBody?): Call<RequestBody?>?

}