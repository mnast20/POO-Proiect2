package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Elf {
    @JsonProperty("white")
    WHITE("white"),

    @JsonProperty("black")
    BLACK("black"),

    @JsonProperty("yellow")
    YELLOW("yellow"),

    @JsonProperty("pink")
    PINK("pink");

    private final String value;

    Elf(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
