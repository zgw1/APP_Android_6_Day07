package com.example.zhang.app_android_6_day07.m;

import com.example.zhang.app_android_6_day07.Data.Bean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModule {

    private List<Bean> list  = new ArrayList<>();
    private ModuleInterface moduleInterface;

    public DataModule(ModuleInterface moduleInterface) {
        this.moduleInterface = moduleInterface;
    }

    public void getData(){
        ////http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.qubaobei.com/ios/cf/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
        ModuleInterfaceGetData moduleInterfaceGetData = retrofit.create(ModuleInterfaceGetData.class);
        moduleInterfaceGetData.getData("dish_list.php","1","20","1").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Bean bean) {
                list.add(bean);
                moduleInterface.LoadSuccess(list);

            }

            @Override
            public void onError(Throwable e) {
                    moduleInterface.Loadfailded();
            }

            @Override
            public void onComplete() {

            }
        });

    }
}
