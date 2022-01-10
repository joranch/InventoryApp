package com.example.inventory.data

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(item: Item)

    @Update
    suspend fun update(item: Item)

    @Query("SELECT * FROM item WHERE id = :id")
    fun getItem(id: Int) : Flow<Item>

    @Query("SELECT * from item ORDER BY name ASC")
    fun getItems(): Flow<List<Item>>

    @Delete
    suspend fun delete(item: Item)
}