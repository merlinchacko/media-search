package com.assignment.mediasearch.wrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class ITunesResultWrapper {

    private String kind;
    private String trackName;
    private String artistName;

}
