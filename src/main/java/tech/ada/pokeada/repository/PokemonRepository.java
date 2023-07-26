package tech.ada.pokeada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    //Query nativa

    @Query(value = "SELECT * FROM POKEMON p WHERE p.name = :nome", nativeQuery = true)
    Optional<Pokemon> findByNome(String nome);

    @Query(value = "SELECT p FROM Pokemon p where p.name = :nome")
    Optional<Pokemon> findByNomeJpql(String nome);


    //Query Methods

    Optional<Pokemon> findByNameIgnoreCase(String name);

    Optional<Pokemon> findByNameIs(String name);

    List<Pokemon> findByNameNot(String name);

    List<Pokemon> findByFirstTypeIn(List<String> types);

    List<Pokemon> findByNameLikeIgnoreCase(String name);

    List<Pokemon> findByNameAndSpeedIs(String name, Integer speed);
    List<Pokemon> findByNameOrSpeedIs(String name, Integer speed);

    List<Pokemon> findBySpeedIsGreaterThan(Integer speed);

    List<Pokemon> findBySpeedIsLessThan(Integer speed);

    List<Pokemon> findBySpeedIsLessThanEqual(Integer speed);

    List<Pokemon> findBySpeedIsGreaterThanEqual(Integer speed);

    List<Pokemon> findBySpeedIsGreaterThanOrderByNameDesc(Integer speed);


}
