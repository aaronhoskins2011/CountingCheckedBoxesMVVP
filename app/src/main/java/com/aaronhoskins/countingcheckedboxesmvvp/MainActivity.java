package com.aaronhoskins.countingcheckedboxesmvvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.aaronhoskins.countingcheckedboxesmvvp.Adapters.SampleRecycleViewAdapter;
import com.aaronhoskins.countingcheckedboxesmvvp.Models.MainActivityModel;
import com.aaronhoskins.countingcheckedboxesmvvp.Models.SampleModel;
import com.aaronhoskins.countingcheckedboxesmvvp.ViewModels.SampleModelViewModel;
import com.aaronhoskins.countingcheckedboxesmvvp.databinding.MainActivityBinding;

import java.util.ArrayList;

import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.ACTION_BROADCAST_COUNT;
import static com.aaronhoskins.countingcheckedboxesmvvp.Constant.KEY_ITEM_COUNT;

public class MainActivity extends AppCompatActivity {
    MainActivityBinding mainActivityBinding;
    protected SampleRecycleViewAdapter sampleRecycleViewAdapter;
    protected RecyclerView rvSampleRecycleView;

    MainActivityModel mainActivityModel;
    protected int checkedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityModel = new MainActivityModel(checkedCount);
        mainActivityBinding.setMainViewModel(mainActivityModel);
        initializeSampleRecycleView();
        checkedCount = sampleRecycleViewAdapter.itemsSelected();
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter(ACTION_BROADCAST_COUNT));
    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkedCount+= intent.getIntExtra(KEY_ITEM_COUNT, 0);
            mainActivityModel.setSelectedCount(checkedCount);
        }
    };

    public void initializeSampleRecycleView() {
        rvSampleRecycleView = findViewById(R.id.rv_sample_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        sampleRecycleViewAdapter = new SampleRecycleViewAdapter(testingData());
        rvSampleRecycleView.setLayoutManager(linearLayoutManager);
        rvSampleRecycleView.setAdapter(sampleRecycleViewAdapter);

    }

    private ArrayList<SampleModelViewModel> testingData() {
        ArrayList<SampleModel> sampleModelArrayList = new ArrayList<>();
        ArrayList<SampleModelViewModel> sampleModelViewModelArrayList = new ArrayList<>();
        sampleModelArrayList.add(new SampleModel("James Kirk", "Captian", false));
        sampleModelArrayList.add(new SampleModel("Data", "Science Officer", false));
        sampleModelArrayList.add(new SampleModel("Scotty Montgomery", "Chief Engineer", false));
        sampleModelArrayList.add(new SampleModel("Luke Skywalker", "Jedi", false));
        sampleModelArrayList.add(new SampleModel("Darth Vader", "Sith Lord", false));

        for(SampleModel model : sampleModelArrayList) {
            sampleModelViewModelArrayList.add(new SampleModelViewModel(model));
        }

        return sampleModelViewModelArrayList;
    }
}
