package com.marina.ruiz.learningroom.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDatabase() : RoomDatabase() {

    companion object {
        @Volatile // Avoid concurrency issues
        private var _INSTANCE: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase {
            return _INSTANCE ?: synchronized(this) {
                _INSTANCE ?: buildDatabase(context).also { db -> _INSTANCE = db }
            }
        }

        private fun buildDatabase(context: Context): PokemonDatabase {
            return Room.databaseBuilder(
                context.applicationContext, // context
                PokemonDatabase::class.java, // db
                "pokemon_db" // db name
            ).build()
        }
    }

    abstract fun pokemonDao(): PokemonDao
}