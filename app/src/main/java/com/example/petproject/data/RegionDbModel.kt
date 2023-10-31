package com.example.petproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey


/* На основе сущности создастся таблица
   с именем "regions", первичный ключ будет генерироваться
   автоматически (пока модель базы  и модель домаин одна и та же )
   но их разделяют обычно
 */
@Entity(tableName = "regions")
data class RegionDbModel(
    @PrimaryKey(autoGenerate = true )val id: Int,
    val numOfRegion: String,
    val nameOfRegion: String
)
