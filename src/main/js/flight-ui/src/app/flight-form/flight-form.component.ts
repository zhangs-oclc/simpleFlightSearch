import { Component, OnInit } from '@angular/core';
import { FormBuilder } from "@angular/forms";
import { FlightService } from "../flight.service";
import { HttpParams } from "@angular/common/http";
import { Flight } from "../flight";

@Component({
  selector: 'app-flight-form',
  templateUrl: './flight-form.component.html',
  styleUrls: ['./flight-form.component.css']
})
export class FlightFormComponent implements OnInit {

  flights: Flight[];
  airports;
  model;
  flightTitles;
  show: boolean;
  message: string;
  noResult: string;


  constructor(private formBuilder: FormBuilder, private flightService: FlightService) {
    this.model = {
      destination: "",
      flightNumber: "",
      origin: "",
      departure: ""
    };
    this.flightTitles = ['flightNumber', 'carrier', 'origin', 'departure', 'destination', 'arrival', 'aircraft', 'distance', 'travelTime', 'status'];
    this.airports = ['IAH', 'ORD']
  }
  ngOnInit() {
  }

  onSubmit() {
    const params = new HttpParams()
      .set('date', this.model.departure)
      .set('destination', this.model.destination)
      .set('origin', this.model.origin)
      .set('flightNumber', this.model.flightNumber);
    this.flightService.searchFlight(params).subscribe(data => {
      this.flights = data.model;
      this.show = !data.noResult;
      this.message = data.message;
      this.noResult = data.noResult ? "No Result" : "";
    });
  }

}
