package com.example.ocs.Domain;

import android.widget.Button;

public class ListDomains {
    String list_title;
    int price;

    public ListDomains(String list_title, int price, Button add) {
        this.list_title = list_title;
        this.price = price;
        this.add = add;
    }

    public String getList_title() {
        return list_title;
    }

    public void setList_title(String list_title) {
        this.list_title = list_title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Button getAdd() {
        return add;
    }

    public void setAdd(Button add) {
        this.add = add;
    }

    Button add;
}
