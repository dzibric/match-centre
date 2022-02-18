package com.incrowd.matchcentre.data.match.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.incrowd.matchcentre.data.models.Team

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams")
    fun getTeams(): List<Team>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTeam(team: Team)
}