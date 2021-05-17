package com.naldana.pokedex.data.entity

import androidx.room.*
import com.google.gson.annotations.SerializedName


/**
 * Pokemon data class
 *
 * Pokémon are the creatures that inhabit the world of the Pokémon games.
 * They can be caught using Pokéballs and trained by battling with other Pokémon.
 * Each Pokémon belongs to a specific species but may take on a variant which makes it differ
 * from other Pokémon of the same species, such as base stats, available abilities and typings.
 */
@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey
    /** The identifier for this resource */
    var id: Int,
    /** The name for this resource. */
    var name: String,
    /** The base experience gained for defeating this Pokémon.*/
    @ColumnInfo(name = "base_experience")
    @SerializedName(value = "base_experience")
    var baseExperience: Int,
    /** Types that the pokemon owns.*/
    var height: Int,
    /** The weight of this Pokémon in hectograms.*/
    var weight: Int,
    @Embedded
    /** A set of sprites used to depict this Pokémon in the game.*/
    var sprites: PokemonSprites
) {
    @Ignore
    /** A list of details showing types this Pokémon has.*/
    lateinit var types: List<PokemonType>
}

/**
 * Entity for save locally a list of details showing types this Pokemon has.
 */
@Entity(tableName = "pokemon_types", primaryKeys = ["slot", "idPokemon"])
data class PokemonType(
    var slot: Int,
    @Embedded
    var type: NamedAPIResource
) {
    var idPokemon: Int = 0
}

/**
 * Holder of a set of sprites used to depict this Pokemon in the game.
 */
data class PokemonSprites(
    @ColumnInfo(name = "front_default")
    @SerializedName(value = "front_default")
    val frontDefault: String?,
    @ColumnInfo(name = "front_shiny")
    @SerializedName(value = "front_shiny")
    val frontShiny: String?,
    @ColumnInfo(name = "front_female")
    @SerializedName(value = "front_female")
    val frontFemale: String?,
    @ColumnInfo(name = "front_shiny_female")
    @SerializedName(value = "front_shiny_female")
    val frontShinyFemale: String?,
    @ColumnInfo(name = "back_default")
    @SerializedName(value = "back_default")
    val backDefault: String?,
    @ColumnInfo(name = "back_shiny")
    @SerializedName(value = "back_shiny")
    val backShiny: String?,
    @ColumnInfo(name = "back_female")
    @SerializedName(value = "back_female")
    val backFemale: String?,
    @ColumnInfo(name = "back_shiny_female")
    @SerializedName(value = "back_shiny_female")
    val backShinyFemale: String?,
)
