package com.bawei.liujiang0415.zhucemvp;

import com.bawei.liujiang0415.MainActivity;
import com.bawei.liujiang0415.loginmvp.LoginConstract;

public interface ZhuceConstract {
    //IView层
    interface Iview{
        void getDataPre(String data);
    }
    //IModel层
    interface Imodel{
        void getRequester(String url,String username,String pwd,LoginConstract.IModel.ModelCallBack modelCallBakc);
        interface ModelCallBack{
            void onSuccess(String data);

            void onFail();
        }

    }
    //IPresenter层
    interface Ipresenter{
        void accth(MainActivity mainActivity);

        void detch();

        void login(String url, String username, String pwd);

    }
}
