package com.soft1841.sm.service;


public interface CashierService {

    /**
     * 登录功能
     * @param account
     * @param password
     * @return
     */
    boolean login(String account , String password);
}
