package zhangs.flightsearch.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zhangs.flightsearch.model.Flight;
import zhangs.flightsearch.model.ModelWrapper;
import zhangs.flightsearch.service.FlightService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "*")
public class FlightController {
    private FlightService flightService;
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/search")
    public ModelWrapper<List<Flight>> searchFlight(@RequestParam(value = "date") String date,
                                     @RequestParam(value = "flightNumber") String flightNumber,
                                     @RequestParam(value = "origin") String origin,
                                     @RequestParam(value = "destination") String destination) {
        ModelWrapper<List<Flight>> result = new ModelWrapper<>();
        List<Flight> flights;
        try {
            flights = this.flightService.searchFlight(date, flightNumber, origin, destination);
            result.setModel(flights.isEmpty() ? Collections.emptyList() : flights);
            result.setNoResult(result.getModel().isEmpty());
        } catch (Exception e) {
            result.setMessage(e.getMessage());
            result.setNoResult(true);
        }
        return result;
    }
}
