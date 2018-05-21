package com.aaronhoskins.countingcheckedboxesmvvp.Models;

public class SampleModel {

    public String name;
    public String itemDescription;
    public boolean isChecked;

    public SampleModel(String name, String itemDescription, boolean isChecked) {
        this.name = name;
        this.itemDescription = itemDescription;
        this.isChecked = isChecked;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
