package com.wanakin.rickmorty.controller;

import com.wanakin.rickmorty.RickMortyClient;
import com.wanakin.rickmorty.response.CharacterResponse;
import com.wanakin.rickmorty.response.EpisodeResponse;
import com.wanakin.rickmorty.response.ListCharactersResponse;
import com.wanakin.rickmorty.response.ListEpisodesResponse;
import com.wanakin.rickmorty.response.ListLocationsResponse;
import com.wanakin.rickmorty.response.LocationResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webclient")
public class RickMortyController {
    
    RickMortyClient rickMortyClient;

    @GetMapping("/character/{id}")
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id){
    return rickMortyClient.findMyCharacter(id);
    }

    @GetMapping("/location/{id}")
        public Mono<LocationResponse> getLocationById(@PathVariable String id){
            return rickMortyClient.findMyLocation(id);
        }
        @GetMapping("/episode/{id}")
        public Mono<EpisodeResponse> getEpisodeById(@PathVariable String id){
            return rickMortyClient.findMyEpisode(id);
        }

        @GetMapping("/characters")
        public Flux<ListCharactersResponse> listCharacters(){
            return rickMortyClient.listCharacters();
        }
        
        @GetMapping("/locations")
        public Flux<ListLocationsResponse> listLocations(){
            return rickMortyClient.listLocations();
        }

        @GetMapping("/episodes")
        public Flux<ListEpisodesResponse> listEps(){
            return rickMortyClient.listEps();
        }
}
