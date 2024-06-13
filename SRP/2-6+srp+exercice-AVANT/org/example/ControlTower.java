package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class ControlTower {

    int originLatitude;
    int originLongitude;

    public ControlTower(int originLatitude, int originLongitude) {
        this.originLatitude = originLatitude;
        this.originLongitude = originLongitude;
    }

    public String getPlanesInRange(int range, List<Plane> planes, boolean latitudeFirstFormat) {
        List<Plane> planesInRange = planes.stream()
                .filter(plane -> (int) Math.sqrt(
                        Math.pow(originLatitude + plane.latitude, 2) +
                                Math.pow(originLongitude + plane.longitude, 2)) <= range)
                .collect(Collectors.toList());

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
