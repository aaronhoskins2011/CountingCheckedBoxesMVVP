package com.aaronhoskins.countingcheckedboxesmvvp.ViewModels;

import android.databinding.BaseObservable;

public class MainActivityViewModel extends BaseObservable{

    public String selectedCount;

    public MainActivityViewModel(int selectedCount) {
        this.selectedCount = String.valueOf(selectedCount);
    }

    public String getSelectedCount() {
        return selectedCount;
    }

    public void setSelectedCount(int selectedCount) {
        this.selectedCount = String.valueOf(selectedCount);
    }

}
