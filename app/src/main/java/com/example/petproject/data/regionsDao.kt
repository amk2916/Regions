package com.example.petproject.data

import androidx.room.Dao
import androidx.room.Query


@Dao
interface  RegionsDao {
    @Query("SELECT * FROM regions")
    fun getRegion() : List<RegionDbModel>

}