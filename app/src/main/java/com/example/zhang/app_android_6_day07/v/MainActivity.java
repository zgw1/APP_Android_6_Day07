package com.example.zhang.app_android_6_day07.v;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhang.app_android_6_day07.Data.Bean;
import com.example.zhang.app_android_6_day07.R;
import com.example.zhang.app_android_6_day07.p.MvpPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MvpView{

    private MvpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MvpPresenter(this);
        presenter.handleData();

    }

    @Override
    public void setListItem(List<Bean> listItem) {
        for (Bean b : listItem){
            Log.e("zgw"," " + b.getRet());
        }
       // Glide.with().load().apply(RequestOptions.bitmapTransform(new CircleCrop())).into()

    }

    @Override
    public void failed() {

    }
}
