package com.naldana.composeapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.naldana.composeapp.data.Pokemon

@Composable
fun PokemonListScreen() {
    val viewModel: PokemonListViewModel = viewModel()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Text(
                "Full Pokedex",
                style = MaterialTheme.typography.titleMedium
            )
        }
        items(viewModel.state.value) { pokemon ->
            PokemonItem(pokemon = pokemon) { name ->
                viewModel.toggleFavorite(name)
            }
        }
    }
}

/*Solamente de ejemplo para el manejo de estado, no se usa en la aplicacion*/
@Preview()
@Composable
fun NewPokemon() {
    val pokemonName = remember {
        mutableStateOf("")
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TextField(
            value = pokemonName.value,
            onValueChange = { name ->
                pokemonName.value = name
            },
            modifier = Modifier.weight(2f)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "GUARDAR")
        }
    }
}

@Composable
fun PokemonItem(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
    onFavoriteClick: (String) -> Unit
) {
    val icon = if (pokemon.favorite)
        Icons.Default.Favorite
    else
        Icons.Default.FavoriteBorder

    Card(modifier = Modifier.padding(4.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.SportsSoccer,
                contentDescription = "Icono de pokemon",
                modifier = Modifier
                    .weight(0.15f)
                    .padding(8.dp)
            )
            PokemonDetail(pokemon, Modifier.weight(0.70f))
            FavoriteIcon(
                icon = icon,
                modifier = Modifier.weight(0.15f)
            ) {
                onFavoriteClick(pokemon.name)
            }
        }
    }
}

@Composable
fun FavoriteIcon(
    icon: ImageVector,
    modifier: Modifier = Modifier, onClick: () -> Unit
) {
    Icon(
        imageVector = icon,
        contentDescription = "Favorite",
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun PokemonDetail(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.titleSmall
        )
        CompositionLocalProvider(
            LocalContentColor provides MaterialTheme.colorScheme.onSurface.copy(
                alpha = 0.50f
            )
        ) {
            Text(
                text = pokemon.type,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewPokemonListScreen() {
    PokemonListScreen()
}