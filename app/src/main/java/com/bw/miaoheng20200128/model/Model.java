package com.bw.miaoheng20200128.model;

import com.bw.miaoheng20200128.api.CartApiService;
import com.bw.miaoheng20200128.api.LoginApiService;
import com.bw.miaoheng20200128.api.RegisterApiService;
import com.bw.miaoheng20200128.contract.IContract;
import com.bw.miaoheng20200128.entity.CartEntity;
import com.bw.miaoheng20200128.entity.LoginEntity;
import com.bw.miaoheng20200128.entity.RegisterEntity;
import com.bw.miaoheng20200128.util.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Model implements IContract.IModel {
    /**
     * 注册
     * @param params
     * @param modelCallBack
     */
    @Override
    public void register(HashMap<String, String> params, ModelCallBack modelCallBack) {
         RetrofitUtils.getInstance().creatService(RegisterApiService.class)
                 .register(params)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<RegisterEntity>() {
                     /**
                      * 成功
                      * @param registerEntity
                      * @throws Exception
                      */
                     @Override
                     public void accept(RegisterEntity registerEntity) throws Exception {
                          modelCallBack.success(registerEntity);
                     }
                 }, new Consumer<Throwable>() {
                     /**
                      * 失败
                      * @param throwable
                      * @throws Exception
                      */
                     @Override
                     public void accept(Throwable throwable) throws Exception {
                          modelCallBack.failur(throwable);
                     }
                 });
    }

    /**
     * 登陆
     * @param params
     * @param modelCallBack
     */
    @Override
    public void login(HashMap<String, String> params, ModelCallBack modelCallBack) {
         RetrofitUtils.getInstance().creatService(LoginApiService.class)
                 .login(params)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Consumer<LoginEntity>() {
                     @Override
                     public void accept(LoginEntity loginEntity) throws Exception {
                             modelCallBack.success(loginEntity);
                     }
                 }, new Consumer<Throwable>() {
                     @Override
                     public void accept(Throwable throwable) throws Exception {
                          modelCallBack.failur(throwable);
                     }
                 });
    }

    @Override
    public void getCartData(String userId, String sessionId, ModelCallBack modelCallBack) {
        RetrofitUtils.getInstance().creatService(CartApiService.class)
                .getData(userId,sessionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartEntity>() {
                    @Override
                    public void accept(CartEntity cartEntity) throws Exception {
                       modelCallBack.success(cartEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                         modelCallBack.failur(throwable);
                    }
                });
    }
}
