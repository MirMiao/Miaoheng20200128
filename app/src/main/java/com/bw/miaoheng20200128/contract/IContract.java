package com.bw.miaoheng20200128.contract;

import com.bw.miaoheng20200128.base.mvp.IBaseModel;
import com.bw.miaoheng20200128.base.mvp.IBaseView;

import java.util.HashMap;

public interface IContract {
    interface IModel extends IBaseModel{
         void register(HashMap<String, String> params, ModelCallBack modelCallBack);
         void login(HashMap<String, String> params, ModelCallBack modelCallBack);
         void getCartData(String userId, String sessionId, ModelCallBack modelCallBack);
         interface ModelCallBack{
              void success(Object object);
              void failur(Throwable throwable);
         }
    }
    interface IView extends IBaseView{
        void success(Object object);
        void failur(Throwable throwable);
    }
    interface IPresenter{
        void register(HashMap<String, String> params);
        void login(HashMap<String, String> params);
        void getCartData(String userId, String sessionId);
    }
}
