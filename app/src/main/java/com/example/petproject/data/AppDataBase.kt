package com.example.petproject.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [
        RegionDbModel::class
    ],
    version = 1
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun regionsDao(): RegionsDao

    companion object{

        //проверяем существует ли экземпляр, если да то новый не создаем
        // а возвращаем существующий
        private var INSTANCE: AppDataBase? = null
        //объект  синхронизации
        private val LOCK = Any()
        //имя БД
        private const val DB_NAME = "Regions"
        //проверка существования экземпляра
        fun getInstance(application: Application):AppDataBase{
            INSTANCE?.let{
                return it
            }
            //это нужно, если два потока зайдут в этот метод
            //то они оба дойдут до этого метода, а здесь будут заходить по
            //очереди и Instance не перезапишется
            synchronized(LOCK){
                INSTANCE?.let{
                    return it
                }
            }
            val db = Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DB_NAME
            ).build()
            INSTANCE = db
            return db
        }

    }
}