package com.soft1841.sm.service;

import com.soft1841.sm.until.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;


public class CashierServiceTest {

    private CashierService cashierService = ServiceFactory.getCashierServiceInstance();

    @Test
    public void login() {
        boolean flag = cashierService.login("chenyuhang","123456");
        assertEquals(true,flag);
    }
}