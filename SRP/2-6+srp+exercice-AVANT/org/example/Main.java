package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Plane> planes = Arrays.asList(
                new Plane("p1",1,3),
                new Plane("p2",10,9),
                new Plane("p3",-5,6),
                new Plane("p4",6,-3),
                new Plane("p5",8,2)
        );

        ControlTower controlTower = new ControlTower(0,0);

        // latitude first
        System.out.println(controlTower.getPlanesInRange(7,planes,true));

        // longitude first
        System.out.println(controlTower.getPlanesInRange(7,planes,false));
    }

}