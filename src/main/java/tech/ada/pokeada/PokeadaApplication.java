package tech.ada.pokeada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.model.enumerator.TypeEnum;
import tech.ada.pokeada.repository.PokemonRepository;
import tech.ada.pokeada.service.PokemonService;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PokeadaApplication implements CommandLineRunner {

	@Autowired
	PokemonService pokemonService;

	@Autowired
	PokemonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PokeadaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sort sort = Sort.by(Sort.Order.asc("name"));

		Page<Pokemon> all = repository.findAll(PageRequest.of(0, 15, sort));
//		System.out.println(all)

		Optional<Pokemon> pikachu = repository.findByName("pikachu");
		System.out.println(pikachu);
//		List<Pokemon> grass = pokemonService.findPokemonsByTypes(Arrays.asList(TypeEnum.BUG.name(), TypeEnum.DRAGON.name()));
//		System.out.println(grass);
	}
}
