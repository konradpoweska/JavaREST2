package fr.polytech.archiserv.tp3.server;

import fr.polytech.archiserv.tp3.MyData;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/data")
public class DataService {

    static int ID = 0;
    Map<Integer, MyData> dataStore = new HashMap<>();

    @POST
    @Produces("application/json")
    public Response postData(@FormParam("nom") String name) {
        MyData data = new MyData(ID, "Hello "+name);
        dataStore.put(ID, data);
        ID++;
        return Response.status(201).entity(data).build();
    }

    @GET
    @Produces("application/json")
    public Response getData(@QueryParam("id") int id) {
        MyData data = dataStore.get(id);
        if(data == null) {
            return Response.status(404).build();
        }
        return Response.ok(data).build();
    }

    @PUT
    @Produces("application/json")
    public MyData putData(@QueryParam("id") int id, @FormParam("nom") String name) throws Exception {
        MyData data = dataStore.get(id);
        if(data == null)
            return null;
        data.setString("Hello " + name);
        return data;
    }

    @DELETE
    @Produces("application/json")
    public MyData deleteData(@QueryParam("id") int id) {
        return dataStore.remove(id);
    }
}
