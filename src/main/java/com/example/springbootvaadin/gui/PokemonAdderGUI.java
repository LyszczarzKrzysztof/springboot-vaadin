package com.example.springbootvaadin.gui;

import com.example.springbootvaadin.PokemonDeck;
import com.example.springbootvaadin.model.PokemonLocal;
import com.example.springbootvaadin.model.PokemonType;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class PokemonAdderGUI extends VerticalLayout {

    @Autowired
    public PokemonAdderGUI(PokemonDeck pokemonDeck) {
        TextField textFieldName = new TextField("name");
        TextField textFieldImage = new TextField("image");
        ComboBox<PokemonType> pokemonTypeComboBox = new ComboBox<>("Pokemon type: ",PokemonType.values());
        Button button = new Button("Add new pokemon!");



        button.addClickListener(buttonClickEvent -> {
            PokemonLocal pokemonLocal = new PokemonLocal();
            pokemonLocal.setName(textFieldName.getValue());
            pokemonLocal.setPokemonType(pokemonTypeComboBox.getValue());
            pokemonLocal.setImage(textFieldImage.getValue());
            pokemonDeck.getPokemonLocals().add(pokemonLocal);
            Notification notification = new Notification(
                    "Pokemon added!", 3000);
            System.out.println(pokemonDeck);
            notification.open();
        });

        add(textFieldName,textFieldImage,pokemonTypeComboBox,button);
    }
}
