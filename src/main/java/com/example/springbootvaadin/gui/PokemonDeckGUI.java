package com.example.springbootvaadin.gui;

import com.example.springbootvaadin.PokemonDeck;
import com.example.springbootvaadin.model.PokemonLocal;
import com.example.springbootvaadin.model.PokemonType;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


@Route
public class PokemonDeckGUI extends VerticalLayout {

    private PokemonDeck pokemonDeck;

    @Autowired
    public PokemonDeckGUI(PokemonDeck pokemonDeck) {

        this.pokemonDeck = pokemonDeck;

        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<>("Pokemon type: ",PokemonType.values());

        pokemonTypeComboBox.addValueChangeListener(click->{

            removeAll();
            add(pokemonTypeComboBox);
            List<PokemonLocal> pokemonLocals = pokemonDeck.getPokemonLocals();
            List<PokemonLocal> pokemonLocalFilteredList = pokemonLocals.stream()
                    .filter(pokemonLocal -> pokemonLocal.getPokemonType() == pokemonTypeComboBox.getValue())
                    .collect(Collectors.toList());

            Grid<PokemonLocal> grid = new Grid<>(PokemonLocal.class);
            grid.addComponentColumn(i-> new Image(i.getImage(),i.getImage())).setHeader("Image");
            grid.setItems(pokemonLocalFilteredList);
            add(grid);
        });
        add(pokemonTypeComboBox);
    }
}
