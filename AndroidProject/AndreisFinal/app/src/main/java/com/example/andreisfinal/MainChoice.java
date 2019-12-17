package com.example.andreisfinal;

public class MainChoice {
    private String Advice;
    private String WebsiteUrl;

    private void setViews(Integer points) {
        switch (points) {
            case 1:
                Advice = "The Hill:Illegal Petes";
                WebsiteUrl = "https://illegalpetes.com/";
                break;
            case 2:
                Advice = "29th Street:Chipotle";
                WebsiteUrl = "https://www.chipotle.com";
                break;
            case 3:
                Advice = "Pearl Street: Bartaco";
                WebsiteUrl = "https://bartaco.com/";
                break;
            default:
                Advice = "none";
                WebsiteUrl = "https://www.google.com/search?";
        }
    }

    public String getName(){
        return Advice;
    }

    public String getURL(){ return WebsiteUrl;}

    public void setName(Integer points){
        setViews(points);
    }


}


