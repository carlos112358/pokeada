package tech.ada.pokeada.dto.parser;

import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.model.Pokemon;


public class PokemonHomeParser {

    public static PokemonHomeDTO toPokemonDTO(Pokemon pokemon) {
        PokemonHomeDTO pokemonHomeDTO = new PokemonHomeDTO();
        pokemonHomeDTO.setId(pokemon.getId());
        pokemonHomeDTO.setImage(pokemon.getUrlImage());
        pokemonHomeDTO.setName(pokemon.getName());
        return pokemonHomeDTO;
    }
}
