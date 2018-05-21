package com.aaronhoskins.countingcheckedboxesmvvp.Models;

import android.databinding.BaseObservable;

public class MainActivityModel extends BaseObservable{

    public String selectedCount;

    public MainActivityModel(int selectedCount) {
        this.selectedCount = String.valueOf(selectedCount);
    }

    public String getSelectedCount() {
        return selectedCount;
    }

    public void setSelectedCount(int selectedCount) {
        this.selectedCount = String.valueOf(selectedCount);
        notifyChange();
    }

}
