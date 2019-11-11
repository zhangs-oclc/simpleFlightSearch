package zhangs.flightsearch.service;

import org.springframework.stereotype.Service;
import zhangs.flightsearch.model.Flight;
import zhangs.flightsearch.repository.FlightRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> searchFlight(String date, String flightNumber, String origin, String destination) throws ParseException {
        Date departure = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        return flightRepository.searchFlight(departure, flightNumber, origin, destination);
    }
}
