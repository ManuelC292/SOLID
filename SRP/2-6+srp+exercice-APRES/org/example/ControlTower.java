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

    public String getPlanesInRange(int range, List<Plane> planes, PlaneOutputFormater planeOutputFormater) {
        List<Plane> planesInRange = planes.stream()
                .filter(plane -> calculateDistance(plane) <= range)
                .collect(Collectors.toList());

        return planeOutputFormater.output(planesInRange);
    }

    private int calculateDistance(Plane plane) {
        return (int) Math.sqrt(
                Math.pow(originLatitude + plane.latitude, 2) +
                        Math.pow(originLongitude + plane.longitude, 2));
    }
}
