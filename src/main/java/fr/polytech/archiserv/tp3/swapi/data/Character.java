package fr.polytech.archiserv.tp3.swapi.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    String name;

//    @JsonProperty("birth_year")
//    String birthYear;

//    @JsonProperty("eye_color")
//    String eyeColor;

//    String gender;

//    @JsonProperty("hair_color")
//    String hairColor;

//    String height;

//    String mass;

//    @JsonProperty("skin_color")
//    String skinColor;

//    String homeworld;

//    List<String> films;

//    List<String> species;

//    List<String> starships;

//    List<String> vehicles;

//    String url;

//    String created;

//    String edited;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
