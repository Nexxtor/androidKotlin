package com.naldana.booktrackersec02.data.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity( tableName = "book_table")
data class Book(
    val title: String,
    val publicationYear: String,
    val pageCount: Int,
    val subject: String,
    val summary: String,
    val isbn: String,
    val publisherId: Long
) {
    /* TODO(1) : Cambios en el modelo
        La anotacion Ignore no funciona, si esta en el contructor por defecto
        Sea agrego autoGenerate al id
     */
    @PrimaryKey(autoGenerate = true) var id: Long = 0L
    /* TODO: Los siguiente atributos cambiaran al tener ROOM con las entidades relaccionadas */
    @Ignore val authors: List<Author>? = null
}
