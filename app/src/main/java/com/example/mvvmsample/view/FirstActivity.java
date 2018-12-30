package com.example.mvvmsample.view;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmsample.R;
import com.example.mvvmsample.model.DataModel;
import com.example.mvvmsample.model.FeatureModel;
import com.example.mvvmsample.viewmodel.FirstViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        FirstViewModel firstViewModel = ViewModelProviders.of(this).get(FirstViewModel.class);
        final TextView textView = findViewById(R.id.text_view_1);

        firstViewModel.getMutableLiveDataModel().observe(this, new Observer<DataModel>() {
            @Override
            public void onChanged(DataModel dataModel) {
                textView.setText(String.valueOf(dataModel.getArg1()+""));
            }
        });

        FeatureModel featureModel = firstViewModel.getFeatureModel();
        featureModel.registerModelCallback(firstViewModel);
        featureModel.getCounts();
    }
}
