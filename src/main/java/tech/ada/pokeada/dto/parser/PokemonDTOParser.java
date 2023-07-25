package tech.ada.pokeada.dto.parser;

import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.model.Pokemon;

public class PokemonDTOParser {

    public static PokemonDTO toPokemonDTO(Pokemon pokemon) {
        PokemonDTO dto = new PokemonDTO();
        dto.setId(pokemon.getId());
        dto.setName(pokemon.getName());
        dto.setAttack(pokemon.getAttack());
        dto.setDefense(pokemon.getDefense());
        dto.setHp(pokemon.getHp());
        return dto;
    }
}
