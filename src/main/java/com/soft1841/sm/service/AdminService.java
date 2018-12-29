package com.soft1841.sm.service;

import com.soft1841.sm.entity.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 登录功能
     * @param account
     * @param password
     * @return
     */
    boolean login(String account, String password);

    /**
     * 查询所有管理员
     * @return List<Admin>
     */
    List<Admin> getAllAdmins();
}
