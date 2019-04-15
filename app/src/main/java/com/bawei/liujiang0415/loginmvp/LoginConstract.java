package com.bawei.liujiang0415.loginmvp;

import com.bawei.liujiang0415.MainActivity;

public interface LoginConstract {
    //IView层
    interface IView{
        void getDataPre(String data);
    }
    //IModel层
    interface IModel{
        void getRequester(String url,String username,String pwd,ModelCallBack modelCallBakc);
        interface ModelCallBack{
            void onSuccess(String data);

            void onFail();
        }

    }
    //IPresenter层
    interface IPresenter{
        void accth(MainActivity mainActivity);

        void detch();

        void login(String url, String username, String pwd);

    }
}
