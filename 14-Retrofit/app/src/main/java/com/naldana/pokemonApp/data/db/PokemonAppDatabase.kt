package com.naldana.pokemonApp.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.naldana.pokemonApp.data.db.dao.PokemonDao
import com.naldana.pokemonApp.data.db.dao.RemoteKeyDao
import com.naldana.pokemonApp.data.db.models.Pokemon
import com.naldana.pokemonApp.data.db.models.RemoteKey

@Database(entities = [Pokemon::class, RemoteKey::class], version = 1, exportSchema = false)
abstract class PokemonAppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun remoteKeyDao(): RemoteKeyDao

    companion object {
        private var INSTANCE: PokemonAppDatabase? = null
        fun getInstance(application: Application): PokemonAppDatabase =
            INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application.applicationContext,
                    PokemonAppDatabase::class.java,
                    "pokemon_app"
                )
                    .build()
                INSTANCE = instance
                instance
            }
    }

}