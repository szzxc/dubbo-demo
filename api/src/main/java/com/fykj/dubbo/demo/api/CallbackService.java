package com.fykj.dubbo.demo.api;

/**
 * Created by Administrator on 2016/1/7.
 */
public interface CallbackService {
    void addListener(String key, CallbackListener listener);
}
