package com.aaronhoskins.countingcheckedboxesmvvp.Adapters;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.aaronhoskins.countingcheckedboxesmvvp.Models.SampleModel;
import com.aaronhoskins.countingcheckedboxesmvvp.R;
import com.aaronhoskins.countingcheckedboxesmvvp.ViewModels.SampleModelViewModel;
import com.aaronhoskins.countingcheckedboxesmvvp.databinding.SampleItemBinding;

import java.util.ArrayList;

import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.ACTION_BROADCAST_COUNT;
import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.KEY_ITEM_COUNT;
import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.SAMPLE_RV_LOG_TAG;

public class SampleRecycleViewAdapter extends RecyclerView.Adapter<SampleRecycleViewAdapter.ViewHolder>  {
    ArrayList<SampleModelViewModel> sampleModelViewModelArrayList;
    private LayoutInflater layoutInflater;

    public SampleRecycleViewAdapter(ArrayList<SampleModelViewModel> passedList) {
        sampleModelViewModelArrayList = passedList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater =LayoutInflater.from(parent.getContext());
        }
        SampleItemBinding sampleItemBinding = SampleItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(sampleItemBinding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        SampleModelViewModel sampleModelViewModel = sampleModelViewModelArrayList.get(position);
        holder.bind(sampleModelViewModel);

    }

    public int itemsSelected() {
        int returnCount = 0;
        for(SampleModelViewModel item : sampleModelViewModelArrayList) {
            if(item.isChecked()) {
                returnCount++;
            }
        }
        return returnCount;
    }

    @Override
    public int getItemCount() {
        return sampleModelViewModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected SampleItemBinding sampleItemBinding;

        public ViewHolder(SampleItemBinding passedSampleItemBinding) {
            super(passedSampleItemBinding.getRoot());
            sampleItemBinding = passedSampleItemBinding;
        }

        public void bind(SampleModelViewModel sampleModelViewModel){
            this.sampleItemBinding.setSampleViewModel(sampleModelViewModel);
        }

        public SampleItemBinding getSampleItemBinding() {
            return sampleItemBinding;
        }
    }
}
