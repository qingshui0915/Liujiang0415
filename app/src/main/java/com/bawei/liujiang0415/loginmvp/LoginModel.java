package com.bawei.liujiang0415.loginmvp;

import com.bawei.liujiang0415.net.AsyncHttpClient;

public class LoginModel implements LoginConstract.IModel {
    @Override
    public void getRequester(String url, String username, String pwd, final ModelCallBack modelCallBakc) {
        AsyncHttpClient.getInstance().postAsync(url, username, pwd, new AsyncHttpClient.AsyncCallBack() {
            @Override
            public void onSuccee(String result) {
                modelCallBakc.onSuccess(result);
            }

            @Override
            public void onError(int code) {

            }
        });

    }
}
