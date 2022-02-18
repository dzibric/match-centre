package com.incrowd.matchcentre.data.match.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.incrowd.matchcentre.data.models.Player

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players")
    fun getPlayers(): List<Player>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePlayer(player: Player)
}