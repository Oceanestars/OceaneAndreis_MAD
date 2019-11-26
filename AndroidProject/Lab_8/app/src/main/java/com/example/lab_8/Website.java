package com.example.lab_8;

public class Website {

    private String Entertainment;
    private String EntertainmentURL;

    private void setViews(Integer points){
        switch (points){
            case 0: //Reading
                Entertainment="New York Times";
                EntertainmentURL="https://www.nytimes.com/";
                break;
            case 1: //Watching
                Entertainment="Youtube";
                EntertainmentURL="http://www.youtube.com";
                break;
            case 2: //Walking
                Entertainment="All Trails";
                EntertainmentURL="https://www.alltrails.com";
                break;
            case 3: //Travelling
                Entertainment="Trip it ";
                EntertainmentURL="https://www.tripit.com/web";
                break;
            default:
                Entertainment="none";
                EntertainmentURL="https://www.google.com/search?q=boulder+coffee+shops&ie=utf-8&oe=utf-8";
        }
    }

    public String getEntertainmentName(){
        return Entertainment;
    }

    public String getEntertainmentURL(){ return EntertainmentURL;}

    public void setEntertainmentName(Integer points){
        setViews(points);
    }

    public void setEntertainmentURL(Integer points){
        setViews(points);
    }




}
