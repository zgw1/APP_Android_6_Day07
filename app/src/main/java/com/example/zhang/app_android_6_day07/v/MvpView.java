package com.example.zhang.app_android_6_day07.v;

import com.example.zhang.app_android_6_day07.Data.Bean;

import java.util.List;

public interface MvpView {

    void setListItem(List<Bean> listItem);

    void failed();

}
