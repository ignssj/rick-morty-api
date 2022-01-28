package com.wanakin.rickmorty.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ListEpisodesResponse {
    private List<EpisodeResponse>  results;
}
