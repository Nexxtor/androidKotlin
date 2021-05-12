package com.naldana.pokedex.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naldana.pokedex.data.dao.PokemonDao
import com.naldana.pokedex.data.entity.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun getPokemonDao(): PokemonDao

    //** Patron singelton: Por que solo queremos que exista
    // una instancia de base de datos disponible en toda la aplicacion

    // Factory Method: Un metodo que sabe como crear la instancia de la base de datos
    companion object {

        @Volatile
        private var INSTANCE: PokedexDatabase? = null

        fun getDatabase(context: Context): PokedexDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, PokedexDatabase::class.java,
                        "pokedex_db").build()
                INSTANCE = instance
                instance
            }
        }
    }
}