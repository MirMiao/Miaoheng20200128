package com.bw.miaoheng20200128.api;

import com.bw.miaoheng20200128.entity.CartEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;


public interface CartApiService {
    @GET("small/order/verify/v1/findShoppingCart")
    Observable<CartEntity> getData(@Header("userId") String userId, @Header("sessionId") String sessionId);
}
