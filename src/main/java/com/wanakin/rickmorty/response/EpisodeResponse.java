package com.wanakin.rickmorty.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class EpisodeResponse {
    private int id;
    private String name;
    private String episode;
    private List<String> characters;
    private String url;
}
