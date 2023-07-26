package tech.ada.pokeada.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.service.PokemonService;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    @Query(name = "SELECT * FROM POKEMON p WHERE p.name = :name", nativeQuery = true)
    Optional<Pokemon> findByName(String name);

    Page<Pokemon> findAll(Pageable pageable);

    //Consultas Simples
    List<Pokemon> findByFirstTypeIgnoreCaseIn(List<String> types);

    Optional<Pokemon> findByNameIgnoreCase(String name);

    List<Pokemon> findBySpeedIsGreaterThan(Integer speed);

    List<Pokemon> findByHpIsGreaterThan(Integer speed);

    //Operadores Lógicos

    List<Pokemon> findBySpeedIsGreaterThanAndFirstTypeIsIn(Integer speed, List<String> types);



}
