package com.example.springbootvaadin;

import com.example.springbootvaadin.model.PokemonLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonDeck {

    private List<PokemonLocal> pokemonLocals;



    public PokemonDeck() {
        this.pokemonLocals = new ArrayList<>();
    }

    public List<PokemonLocal> getPokemonLocals() {
        return pokemonLocals;
    }

    public void setPokemonLocals(List<PokemonLocal> pokemonLocals) {
        this.pokemonLocals = pokemonLocals;
    }

    @Override
    public String toString() {
        return "PokemonDeck{" +
                "pokemonLocals=" + pokemonLocals +
                '}';
    }
}
