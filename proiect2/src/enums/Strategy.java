package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Strategy {
    @JsonProperty("id")
    ID_STRATEGY("id"),

    @JsonProperty("niceScore")
    NICE_SCORE_CHILDREN_STRATEGY("niceScore"),

    @JsonProperty("niceScoreCity")
    NICE_SCORE_CITIES_STRATEGY("niceScoreCity");

    private final String value;

    Strategy(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
