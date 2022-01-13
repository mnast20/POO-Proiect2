package input;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import enums.Category;
import enums.Cities;
import enums.Elf;

import java.util.ArrayList;

@JsonDeserialize(builder = ChildInput.ChildBuilder.class)
public final class ChildInput {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Cities city;
    private Double niceScore;
    private Double niceScoreBonus;
    private ArrayList<Category> giftsPreferences;
    private Elf elf;

    private ChildInput(ChildBuilder childBuilder) {
        this.id = childBuilder.id;
        this.firstName = childBuilder.firstName;
        this.lastName = childBuilder.lastName;
        this.age = childBuilder.age;
        this.city = childBuilder.city;
        this.niceScore = childBuilder.niceScore;
        this.niceScoreBonus = childBuilder.niceScoreBonus;
        this.giftsPreferences = childBuilder.giftsPreferences;
        this.elf = childBuilder.elf;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public Cities getCity() {
        return city;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public Elf getElf() {
        return elf;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setAge(final Integer age) {
        this.age = age;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public void setNiceScoreBonus(Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public void setElf(Elf elf) {
        this.elf = elf;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class ChildBuilder {
        private final Integer id;
        private final String firstName;
        private final String lastName;
        private final Integer age;
        private final Cities city;
        private final Double niceScore;
        private Double niceScoreBonus = 0.0;
        private final ArrayList<Category> giftsPreferences;
        private final Elf elf;

        @JsonCreator
        public ChildBuilder(@JsonProperty("id") Integer id,
                            @JsonProperty("firstName") String firstName,
                            @JsonProperty("lastName") String lastName,
                            @JsonProperty("age") Integer age,
                            @JsonProperty("city") Cities city,
                            @JsonProperty("niceScore")Double niceScore,
                            @JsonProperty("giftsPreferences") ArrayList<Category> giftsPreferences,
                            @JsonProperty("elf") Elf elf) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
        }

        public ChildBuilder setNiceScoreBonus(double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        public ChildInput build() {
            return new ChildInput(this);
        }
    }
}
