package com.nnkti.friendlocator.models;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nnkti on 10/24/2017.
 */

public class SimpleLocation {
    private double latitude;
    private double longitude;
    private String nickname;

    public SimpleLocation(double latitude, double longitude, String nickname) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nickname = nickname;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static ArrayList<SimpleLocation> parseMessageToSimpleLocation(String message) {
        if (!message.isEmpty()) {
            ArrayList<SimpleLocation> simpleLocations = new ArrayList<>();
            Scanner scanner = new Scanner(message);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // process the line
                simpleLocations.add(getSimpleLocationFromLine(line));
            }
            scanner.close();
            return simpleLocations;
        }
        return null;
    }

    private static SimpleLocation getSimpleLocationFromLine(String line) {
        SimpleLocation thisLocation = new SimpleLocation(0, 0, "");
        thisLocation.setLongitude(
                Double.parseDouble(
                        line.substring(line.lastIndexOf(" "), line.length())
                ));
        thisLocation.setLatitude(
                Double.parseDouble(
                        line.substring(
                                line.lastIndexOf((" "), line.lastIndexOf(" ") - 1) + 1,
                                line.lastIndexOf(" ")
                        )
                )
        );
        thisLocation.setNickname(line.substring(
                0,
                line.lastIndexOf((" "), line.lastIndexOf(" ") - 1)
        ));
        return thisLocation;
    }
}
