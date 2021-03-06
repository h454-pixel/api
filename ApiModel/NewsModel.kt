package com.pinit.kotlinproject.ApiModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.pinit.kotlinproject.ActivityClass.Article


 data  class NewsModel (
    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null,

    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null)
