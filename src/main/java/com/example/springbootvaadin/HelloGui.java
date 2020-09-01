package com.example.springbootvaadin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("hello")
@StyleSheet("/css/style.css")
public class HelloGui extends VerticalLayout {
    public HelloGui() {
        TextField textFieldHello = new TextField("Podaj imie: ");
        Button leftButtonHello = new Button("Hello", new Icon(VaadinIcon.ACADEMY_CAP));
        Label labelHello = new Label();
        leftButtonHello.addClickListener(buttonClickEvent -> {
            labelHello.setText("Hello "+textFieldHello.getValue());
            add(new Image("https://media2.giphy.com/media/LY8yDak6Tngb6FfPrt/giphy.gif","Nie ma obrazka!"));
        });

        add(textFieldHello);
        add(leftButtonHello);
        add(labelHello);
    }
}
