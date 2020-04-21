package com.example.allinoneron;

public class Passenger {
    private String Type;
    private String Time;
    private String Station;

    public Passenger(String type, String time, String station) {
        Type = type;
        Time = time;
        Station = station;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
    public String getStation() {
        return Station;
    }

    public void setStation(String station) {
        Station = station;
    }

    public String Call() {
        return "";
    }
    public String Sound() {
        return "";
    }

    @Override
    public String toString() {
        return "Passenger -" + "\n" +
                "Type : " + Type + '\n' +
                "Time : " + Time + '\n' +
                "Station : " + Station + "\n"+".";
    }
}

