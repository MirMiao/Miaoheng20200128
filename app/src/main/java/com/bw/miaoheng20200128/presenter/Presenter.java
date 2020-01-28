package com.bw.miaoheng20200128.presenter;

import com.bw.miaoheng20200128.base.mvp.BasePresenter;
import com.bw.miaoheng20200128.contract.IContract;
import com.bw.miaoheng20200128.model.Model;

import java.util.HashMap;


public class Presenter extends BasePresenter<Model, IContract.IView> implements IContract.IPresenter{


    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void register(HashMap<String, String> params) {
         model.register(params, new IContract.IModel.ModelCallBack() {
             @Override
             public void success(Object object) {
                 getView().success(object);
             }

             @Override
             public void failur(Throwable throwable) {

             }
         });
    }

    @Override
    public void login(HashMap<String, String> params) {
           model.login(params, new IContract.IModel.ModelCallBack() {
               @Override
               public void success(Object object) {
                   getView().success(object);
               }

               @Override
               public void failur(Throwable throwable) {
                 getView().failur(throwable);
               }
           });
    }

    @Override
    public void getCartData(String userId, String sessionId) {
           model.getCartData(userId, sessionId, new IContract.IModel.ModelCallBack() {
               @Override
               public void success(Object object) {
                   getView().success(object);
               }

               @Override
               public void failur(Throwable throwable) {
                   getView().failur(throwable);
               }
           });
    }
}
