package fr.polytech.archiserv.tp3.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import fr.polytech.archiserv.tp3.MyData;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Form;

public class MyClient {
    public static void main(String[] args){
        System.setProperty(
                ClientBuilder.JAXRS_DEFAULT_CLIENT_BUILDER_PROPERTY,
                "org.apache.cxf.jaxrs.client.spec.ClientBuilderImpl"
        );

        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://localhost:9000/data");
        Invocation.Builder builder = target.request();
        Form form = new Form().param("nom", "Toto");
        MyData response = builder.post(Entity.form(form), MyData.class);
        System.out.println("Response of POST: " + response);

        target = target.queryParam("id", response.getId());
        builder = target.request();
        response = builder.get(MyData.class);
        System.out.println("Response of GET: " + response);

        form = new Form().param("nom", "Titi");
        response = builder.put(Entity.form(form), MyData.class);
        System.out.println("Response of PUT: " + response);

        response = builder.delete(MyData.class);
        System.out.println("Response of DELETE: " + response);

        response = builder.delete(MyData.class);
        System.out.println("Response of DELETE: " + response);
    }
}
