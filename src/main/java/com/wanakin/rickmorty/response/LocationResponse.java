package com.wanakin.rickmorty.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class LocationResponse {
    private int id;
    private String name;
    private String type;
    private String dimension;
}
