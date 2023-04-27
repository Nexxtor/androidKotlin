package com.naldana.booktrackersec02.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class BookAndPublisher(
    @Relation(
        parentColumn = "id",
        entityColumn = "publisherId"
    )
    val book: Book,
    @Embedded val publisher: Publisher
)