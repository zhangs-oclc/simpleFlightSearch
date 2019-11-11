package zhangs.flightsearch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@EqualsAndHashCode
@NoArgsConstructor
@ToString
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    private String flightNumber;
    private String carrier;
    private String origin;
    private String departure;
    private String destination;
    private String arrival;
    private String aircraft;
    private int distance;
    private String travelTime;
    private String status;
}
