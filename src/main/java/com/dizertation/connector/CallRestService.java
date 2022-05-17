package com.dizertation.connector;

import com.dizertation.model.Vehicles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    private static void callRestService() {
        RestTemplate restTemplate = new RestTemplate();
        Vehicles vehicle = restTemplate.getForObject("https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/vehicles?r=r1551&format=json",
                Vehicles.class);

        System.out.println("Bus id is: " + vehicle.getVehicleList().get(0).getId());
    }

    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
