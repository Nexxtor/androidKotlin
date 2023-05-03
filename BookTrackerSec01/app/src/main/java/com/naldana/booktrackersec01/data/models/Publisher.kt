package com.naldana.booktrackersec01.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publisher_table")
data class Publisher(
    val name: String,
    val location: String,
    val website: String,
    val foundingYear: Int
) {
    @PrimaryKey(autoGenerate = true) var id: Long = 0L
}