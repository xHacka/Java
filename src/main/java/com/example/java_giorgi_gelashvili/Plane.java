package com.example.java_giorgi_gelashvili;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Plane {
    private Long id;
    @NonNull private String source;
    @NonNull private String destination;
    @NonNull private Date date;
    @NonNull private Integer seats;
    @NonNull private Integer seatsOccupied;
    @NonNull private Double price;

    public Object getField(String field) {
        return switch (field.toLowerCase()) {
            case "source"        -> getSource();
            case "destination"   -> getDestination();
            case "date"          -> getDate();
            case "seats"         -> getSeats();
            case "seatsOccupied" -> getSeatsOccupied();
            case "price"         -> getPrice();
            default              -> null;
        };
    }

}
