package tech.ada.pokeada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

 /*
 * Escreva as seguintes buscas utilizando query methods na interface PokemonRepository:

     * Listar Pokémons que a defense maior que o valor informado.*/
     List<Pokemon> findByDefenceIsGreaterThan(Integer defense);

     //* Listar Pokémons que o firstType entre uma lista de tipos informados.
     List<Pokemon> findByFirstTypeIn(List<String> types);

     //* Listar Pokémons que o specialAttack está entre dois valores informados.
     List<Pokemon> findBySpecialAttackBetween(Integer spAtkUnder, Integer spAtkOver);
 
     //* Listar Pokémons que o specialAttack é maior ou igual que o valor informado.
     List<Pokemon> findBySpecialAttackIsGreaterThanEqual(Integer spatk);

    /* Escreva também buscas utilizando query nativa na interface PokemonRepository:

    * Obter Pokémon pelo nome.*/

    @Query(value = "SELECT * FROM POKEMON p WHERE p.name = :nome", nativeQuery = true)
    Optional<Pokemon> findByNome(String nome);

}
