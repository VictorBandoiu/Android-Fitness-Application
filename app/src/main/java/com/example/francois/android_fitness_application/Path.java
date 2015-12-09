package com.example.francois.android_fitness_application;

import android.location.Location;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by francois on 09-12-15.
 */
public class Path {
    LinkedList<PathData> locations;

    public  Path(){
        locations = new LinkedList();
    }
    public void newLocation(Location location, Date timeStamp){
        locations.add(new PathData(location,timeStamp));
    }

    public  float speed(){
        return distance()/(duration()*1000);
    }
    public float distance(){
        float distance = 0;
        Location start = locations.getFirst().location;
        Location stop = locations.get(1).location;
        for (int i=2; i<locations.size(); i++){
            distance =+ deltaTwoPoints(start,stop);
            start = stop;
            stop = locations.get(i).location;
        }
        return distance;
    }

    //TODO delete

    public int numberOfPoints(){
        return locations.size();
    }

    //END
    public float duration(){
        float duration = 0;
        Date start = locations.getFirst().timestamp;
        Date stop = locations.get(1).timestamp;
        for (int i=2; i<locations.size(); i++){
            duration =+ deltaTwoDates(start,stop);
            start = stop;
            stop = locations.get(i).timestamp;
        }
        return duration;
    }
    private float deltaTwoPoints(Location start, Location stop){
        return start.distanceTo(stop);
    }

    private long deltaTwoDates(Date start, Date stop){
        return stop.getTime() - start.getTime();
    }
}

class PathData{
    Location location;
    Date timestamp;

    public PathData(Location location, Date timestamp){
        this.location = location;
        this.timestamp = timestamp;
    }
}
