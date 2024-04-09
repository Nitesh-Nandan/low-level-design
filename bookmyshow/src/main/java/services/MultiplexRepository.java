package services;

import models.Multiplex;

import java.util.HashMap;
import java.util.Map;

public class MultiplexRepository {
    private Map<String, Multiplex> multiplexes = new HashMap<>();

    public void addMultiplex(Multiplex multiplex) {
        multiplexes.put(multiplex.getMulitpexId(), multiplex);
    }

    public String getAddress(String multiplexId) {
        return multiplexes.get(multiplexId).getAddress();
    }

    public Multiplex getMultiplexById(String multiplexId) {
        return multiplexes.get(multiplexId);
    }

}
