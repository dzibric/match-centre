package com.incrowd.matchcentre.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.incrowd.matchcentre.data.match.local.PlayerDao
import com.incrowd.matchcentre.data.match.local.TeamDao
import com.incrowd.matchcentre.data.models.Player
import com.incrowd.matchcentre.data.models.Team

@Database(entities = [Player::class, Team::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun playerDao(): PlayerDao
    abstract fun teamDao(): TeamDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "db_match_centre").build()
        }
    }
}