package com.example.githubsearchapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.githubsearchapp.utils.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class RepoDetailsEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int?= null,

    @ColumnInfo(name = "name")
    val name : String
)
