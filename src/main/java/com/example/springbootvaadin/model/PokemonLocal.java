package com.example.springbootvaadin.model;

import org.springframework.stereotype.Component;

public class PokemonLocal {
    private String name;
    private PokemonType pokemonType;
    private String image;

    public PokemonLocal() {
    }

    public PokemonLocal(String name, PokemonType pokemonType, String image) {
        this.name = name;
        this.pokemonType = pokemonType;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PokemonLocal{" +
                "name='" + name + '\'' +
                ", pokemonType=" + pokemonType +
                ", image='" + image + '\'' +
                '}';
    }
}
