package com.example.zhang.app_android_6_day07.p;

import com.example.zhang.app_android_6_day07.Data.Bean;
import com.example.zhang.app_android_6_day07.m.DataModule;
import com.example.zhang.app_android_6_day07.m.ModuleInterface;
import com.example.zhang.app_android_6_day07.v.MvpView;

import java.util.List;

public class MvpPresenter implements ModuleInterface {
    private DataModule dataModule = new DataModule(this);
    private MvpView mvpView;

    public MvpPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
    }

    public void handleData(){
        dataModule.getData();


    }

    @Override
    public void LoadSuccess(List<Bean> list) {
        mvpView.setListItem(list);


    }

    @Override
    public void Loadfailded() {
        mvpView.failed();

    }
}
