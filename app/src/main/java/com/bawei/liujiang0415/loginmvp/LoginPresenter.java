package com.bawei.liujiang0415.loginmvp;

import com.bawei.liujiang0415.MainActivity;

import java.net.URL;

public class LoginPresenter implements LoginConstract.IPresenter {
    private MainActivity iloginView;
    private LoginModel loginModel;

    @Override
    public void accth(MainActivity mainActivity) {
        this.iloginView=mainActivity;
        loginModel = new LoginModel();

    }

    @Override
    public void detch() {
        //防止内存泄露
        if (iloginView!=null){
            iloginView=null;
        }
        if (loginModel!=null){
            loginModel=null;
        }
        System.gc();
    }

    @Override
    public void login(String url, String username, String pwd) {

      loginModel.getRequester(url, username, pwd, new LoginConstract.IModel.ModelCallBack() {
          @Override
          public void onSuccess(String data) {
              iloginView.getDataPre(data);
          }

          @Override
          public void onFail() {

          }
      });
    }
}
