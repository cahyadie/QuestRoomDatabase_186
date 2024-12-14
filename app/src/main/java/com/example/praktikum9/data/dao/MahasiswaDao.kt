package com.example.praktikum9.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.praktikum9.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow


@Dao
interface MahasiswaDao {
    //fungsi get all data
    @Query("select * From mahasiswa ")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}