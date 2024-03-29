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

    private ChildInput(final ChildBuilder childBuilder) {
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

    public void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public void setElf(final Elf elf) {
        this.elf = elf;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class ChildBuilder {
        private final Integer id; // mandatory
        private final String firstName; // mandatory
        private final String lastName; // mandatory
        private final Integer age; // mandatory
        private final Cities city; // mandatory
        private final Double niceScore; // mandatory
        private Double niceScoreBonus = 0.0; // optional
        private final ArrayList<Category> giftsPreferences; // mandatory
        private final Elf elf; // mandatory

        @JsonCreator
        public ChildBuilder(@JsonProperty("id") final Integer id,
                            @JsonProperty("firstName") final String firstName,
                            @JsonProperty("lastName") final String lastName,
                            @JsonProperty("age") final Integer age,
                            @JsonProperty("city") final Cities city,
                            @JsonProperty("niceScore") final Double niceScore,
                            @JsonProperty("giftsPreferences")
                                    final ArrayList<Category> giftsPreferences,
                            @JsonProperty("elf") final Elf elf) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
            this.niceScore = niceScore;
            this.giftsPreferences = giftsPreferences;
            this.elf = elf;
        }

        /**
         * Method setting the optional nice score bonus property to a given value
         */
        public ChildBuilder setNiceScoreBonus(final Double bonusNiceScore) {
            this.niceScoreBonus = bonusNiceScore;
            return this;
        }


        /**
         * Method building the child
         */
        public ChildInput build() {
            return new ChildInput(this);
        }
    }
}
