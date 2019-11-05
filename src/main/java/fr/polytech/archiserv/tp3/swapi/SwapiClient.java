package fr.polytech.archiserv.tp3.swapi;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import fr.polytech.archiserv.tp3.swapi.data.*;
import fr.polytech.archiserv.tp3.swapi.data.Character;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SwapiClient {
    static private String SWAPI_URL = "https://swapi.co/api/";

    private Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);

    public int countMovies(){
        WebTarget target = client.target(SWAPI_URL + "films/");
        Invocation.Builder builder = target.request();
        SwapiResults<Movie> response = builder.get(SwapiMoviesResults.class);
        return response.getCount();
    }

    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        String nextTarget = SWAPI_URL + "people/";

        while(nextTarget != null) {
            System.err.println("Asking "+nextTarget);
            WebTarget target = client.target(nextTarget);
            Invocation.Builder builder = target.request();
            SwapiResults<Character> response = builder.get(SwapiPeopleResults.class);
            characters.addAll(Arrays.asList(response.getResults()));
            nextTarget = response.getNext();
        }

        return characters;
    }

    public static void main(String[] args) {
        System.setProperty(
                ClientBuilder.JAXRS_DEFAULT_CLIENT_BUILDER_PROPERTY,
                "org.apache.cxf.jaxrs.client.spec.ClientBuilderImpl"
        );

        SwapiClient swapiClient = new SwapiClient();

        System.out.println("number of movies : " + swapiClient.countMovies());

        System.out.println("character names :");
        for(Character c : swapiClient.getAllCharacters())
            System.out.println(c.getName());
    }

}
