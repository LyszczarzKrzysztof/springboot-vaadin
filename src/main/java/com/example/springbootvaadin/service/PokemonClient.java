package com.example.springbootvaadin.service;

import com.example.springbootvaadin.model.Pokemon;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.spec.PKCS8EncodedKeySpec;

@Service
public class PokemonClient {

    //@EventListener(ApplicationReadyEvent.class)
    public Pokemon getPokemon() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Pokemon> exchange = restTemplate.exchange(
                "https://api.pokemontcg.io/v1/cards?name=charmander",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Pokemon.class);
        System.out.println(exchange.getBody());
        return null;
    }
}
