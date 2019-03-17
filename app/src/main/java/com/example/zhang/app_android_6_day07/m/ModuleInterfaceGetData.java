package com.example.zhang.app_android_6_day07.m;

import com.example.zhang.app_android_6_day07.Data.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ModuleInterfaceGetData {

    @GET("{path}")
    Observable<Bean>
    getData(@Path("path")

                    String path, @Query("stage_id") String stage_id
            , @Query("limit") String limit, @Query("page") String page);

}
