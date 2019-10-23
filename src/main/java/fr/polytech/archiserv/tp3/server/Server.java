package fr.polytech.archiserv.tp3.server;


import java.util.Scanner;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class Server {

    public static void main(String[] args) {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setProvider(new JacksonJaxbJsonProvider());
        sf.setResourceClasses(DataService.class);
        sf.setResourceProvider(
                DataService.class,
                new SingletonResourceProvider(new DataService())
        );
        sf.setAddress("http://localhost:9000/");
        sf.create();

        System.out.println("Saisir car+return pour stopper le serveur");
        new Scanner(System.in).next();

        System.out.println("Fin");
    }
}
