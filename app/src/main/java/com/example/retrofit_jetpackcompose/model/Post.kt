package com.example.retrofit_jetpackcompose.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Post(

	@PrimaryKey(autoGenerate = false)
	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
