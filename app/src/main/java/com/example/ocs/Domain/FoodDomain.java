package com.example.ocs.Domain;

public class FoodDomain {
    private String title;
    private String pic;
    private Double fee;
    private String star;
    private int time;
    private int calories;

    public FoodDomain(String title, String pic, Double fee, String  star, int time, int calories) {
        this.title = title;
        this.pic = pic;
        this.fee = fee;
        this.star = star;
        this.time = time;
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }



}
