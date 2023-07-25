package tech.ada.pokeada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}
