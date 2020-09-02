package com.example.supers.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Super_Heroes_Table")
data class HeroesEntityPojo (
    var response:Boolean,
    @PrimaryKey val id:Int,
    @ColumnInfo (name="name")var name:String,
    @ColumnInfo (name="url")var imageUrl:String,
    )
