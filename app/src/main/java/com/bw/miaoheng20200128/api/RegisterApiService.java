package com.bw.miaoheng20200128.api;

import com.bw.miaoheng20200128.entity.RegisterEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface RegisterApiService {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterEntity> register(@FieldMap HashMap<String, String> params);
}
