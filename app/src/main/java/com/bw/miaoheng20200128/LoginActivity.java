package com.bw.miaoheng20200128;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.miaoheng20200128.base.BaseActivity;
import com.bw.miaoheng20200128.contract.IContract;
import com.bw.miaoheng20200128.entity.LoginEntity;
import com.bw.miaoheng20200128.entity.RegisterEntity;
import com.bw.miaoheng20200128.presenter.Presenter;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<Presenter> implements IContract.IView {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_register)
    Button btRegister;

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_login;
    }

    /**
     * 成功
     *
     * @param object
     */
    @Override
    public void success(Object object) {
          if(object instanceof RegisterEntity){
              Toast.makeText(this, ""+((RegisterEntity) object).getMessage(), Toast.LENGTH_SHORT).show();
          }else if(object instanceof LoginEntity){
              //登陆成功
              Intent intent = new Intent(this, MainActivity.class);
              //传递头像信息
              intent.putExtra("headlerPic",((LoginEntity) object).getResult().getHeadPic());
              startActivity(intent);
          }
    }

    /**
     * 失败
     *
     * @param throwable
     */
    @Override
    public void failur(Throwable throwable) {

    }


    @OnClick({R.id.bt_login, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                //获取输入框输入的内容
                String phone = etPhone.getText().toString();
                String pwd = etPwd.getText().toString();
                HashMap<String,String> params=new HashMap<>();
                params.put("phone",phone);
                params.put("pwd",pwd);

                presenter.login(params);
                break;
            case R.id.bt_register:
                //获取输入框输入的内容
                String phone1 = etPhone.getText().toString();
                String pwd1 = etPwd.getText().toString();
                HashMap<String,String> params1=new HashMap<>();
                params1.put("phone",phone1);
                params1.put("pwd",pwd1);
                presenter.register(params1);
                break;
        }
    }
}
