package com.personal.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsDTO {

    @JsonProperty("results")
    private List<BookDTO> results;

    public ResultsDTO() {
    }

    public ResultsDTO(List<BookDTO> results) {
        this.results = results;
    }

    public List<BookDTO> getResults() {
        return results;
    }

    public void setResults(List<BookDTO> results) {
        this.results = results;
    }
}
