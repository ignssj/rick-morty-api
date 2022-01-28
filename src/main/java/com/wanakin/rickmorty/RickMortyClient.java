package com.wanakin.rickmorty;

import com.wanakin.rickmorty.response.CharacterResponse;
import com.wanakin.rickmorty.response.EpisodeResponse;
import com.wanakin.rickmorty.response.ListCharactersResponse;
import com.wanakin.rickmorty.response.ListEpisodesResponse;
import com.wanakin.rickmorty.response.ListLocationsResponse;
import com.wanakin.rickmorty.response.LocationResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickMortyClient {
    private final WebClient webClient;

    public RickMortyClient(WebClient.Builder builder){
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findMyCharacter(String id){
    log.info("Searching for Character [{}]",id);
    return webClient.get().uri("/character/"+ id).accept(MediaType.APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Error in parameters"))).bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findMyLocation(String id){
        log.info("Searching for location of [{}]",id);
        return webClient.get().uri("/location/"+id).accept(MediaType.APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Error in parameters"))).bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findMyEpisode(String id){
        log.info("Searching for episode [{}]",id);
        return webClient.get().uri("/episode/"+id).accept(MediaType.APPLICATION_JSON).retrieve().onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Error in parameters"))).bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListCharactersResponse> listCharacters(){
        log.info("Listing all characters");
        return webClient.get().uri("/character/").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(ListCharactersResponse.class);
    }

    public Flux<ListLocationsResponse> listLocations(){
        log.info("Listing all locations");
        return webClient.get().uri("/location/").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(ListLocationsResponse.class);
    }
    
    public Flux<ListEpisodesResponse> listEps(){
        log.info("Listing all episodes");
        return webClient.get().uri("/episode/").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(ListEpisodesResponse.class);
    }
}
