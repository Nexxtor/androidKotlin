package com.naldana.pokedex.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naldana.pokedex.data.dao.PokemonDao
import com.naldana.pokedex.data.entity.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokedexDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var INSTANCE: PokedexDatabase? = null

        fun getDatabase(context: Context): PokedexDatabase {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    PokedexDatabase::class.java, "pokedexDb"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}