package com.example.logos;

public class MoneyChoice {
    private String Advice;
    private String WebsiteUrl;

    private void setViews(Integer points) {
        switch (points) {
            case 1: //Watching
                Advice = "Save Money";
                WebsiteUrl = "https://www.thesimpledollar.com/trimming-the-fat-forty-ways-to-reduce-your-monthly-required-spending/";
                break;
            case 2: //Walking
                Advice = "Treat Yourself";
                WebsiteUrl = "https://www.buzzfeed.com/sarahhan/treat-yourself-rightnow-september";
                break;
            case 3: //Travelling
                Advice = "Invest";
                WebsiteUrl = "https://www.nerdwallet.com/blog/investing/how-to-invest-money/";
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
