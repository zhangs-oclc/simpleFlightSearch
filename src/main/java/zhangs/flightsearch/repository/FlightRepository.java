package zhangs.flightsearch.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import zhangs.flightsearch.model.Flight;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FlightRepository {

    public FlightRepository() {

    }

    public List<Flight> searchFlight(Date date, String flightNumber, String origin, String destination) {
        List<Flight> flights;
        // read JSON and load json
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/flight-docs/flight-sample.json");
        try {
            flights = objectMapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            return Collections.emptyList();
        }
        return flights.stream().filter(flight -> filterFlight(flight, date, flightNumber, origin, destination)).collect(Collectors.toList());
    }

    private boolean filterFlight(Flight flight, Date date, String flightNumber, String origin, String destination) {
        Date departure;
        try {
            departure = new SimpleDateFormat("yyyy-MM-dd").parse(flight.getDeparture());
        } catch (ParseException pe) {
            return false;
        }
        return (flight.getFlightNumber().equals(flightNumber)
                || (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination))
                )
                && departure.equals(date);
    }
}
