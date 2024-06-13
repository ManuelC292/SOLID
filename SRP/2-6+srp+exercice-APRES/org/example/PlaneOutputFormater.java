package org.example;

import java.util.List;

public class PlaneOutputFormater {

    boolean latitudeFirstFormat;
    
    public PlaneOutputFormater(boolean latitudeFirstFormat){
        this.latitudeFirstFormat = latitudeFirstFormat;
    }

    public String output(List<Plane> planesInRange){
        StringBuilder result = new StringBuilder();
        if (latitudeFirstFormat) {
            planesInRange.forEach(plane -> result
                    .append("(")
                    .append(plane.latitude)
                    .append(" ")
                    .append(plane.longitude)
                    .append(") "));
        } else {
            planesInRange.forEach(plane -> result
                    .append("(")
                    .append(plane.longitude)
                    .append(" ")
                    .append(plane.latitude)
                    .append(") "));
        }
        return result.toString();
    }
    
}
