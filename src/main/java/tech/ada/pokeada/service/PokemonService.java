package tech.ada.pokeada.service;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.dto.parser.PokemonDTOParser;
import tech.ada.pokeada.dto.parser.PokemonHomeParser;
import tech.ada.pokeada.exceptions.PokemonNaoEncontradoException;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonHomeDTO> findAll() {
        return pokemonRepository.findAll()
                .stream()
                .map(PokemonHomeParser::toPokemonDTO)
                .collect(Collectors.toList());
    }


    public PokemonDTO findById(Long id) {
        Optional<Pokemon> pokemonOptional  = pokemonRepository.findById(id);

        return PokemonDTOParser.toPokemonDTO(pokemonOptional
                .orElseThrow(() ->
                        new PokemonNaoEncontradoException("Não encontrado pokemon de ID " + id)));
    }

}
