package com.aaronhoskins.countingcheckedboxesmvvp.ViewModels;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.CheckBox;

import com.aaronhoskins.countingcheckedboxesmvvp.Models.SampleModel;

import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.ACTION_BROADCAST_COUNT;
import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.KEY_ITEM_COUNT;

public class SampleModelViewModel extends BaseObservable {
    public String name;
    public String itemDescription;
    public boolean isChecked;
    public SampleModel sampleModel;

    public SampleModelViewModel(SampleModel passedSampleModel) {
        this.name = passedSampleModel.name;
        this.itemDescription = passedSampleModel.itemDescription;
        this.isChecked = passedSampleModel.isChecked;
        this.sampleModel = passedSampleModel;
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

    public SampleModel getSampleModel() {
        return sampleModel;
    }

    public void setSampleModel(SampleModel sampleModel) {
        this.sampleModel = sampleModel;
    }

    public void onCheckboxClicked(View view){

        boolean isBoxChecked = ((CheckBox) view).isChecked();
        setChecked(isBoxChecked);
        Intent intent = new Intent(ACTION_BROADCAST_COUNT);
        intent.putExtra(KEY_ITEM_COUNT, (isBoxChecked ? 1 : -1));
        LocalBroadcastManager.getInstance(view.getContext()).sendBroadcast(intent);

    }

}
