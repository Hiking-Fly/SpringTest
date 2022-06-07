package com.zjnu.service.impl;


import com.zjnu.dao.AccountDao;
import com.zjnu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Transactional(isolation = Isolation.DEFAULT)
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int a = 1/0;
        accountDao.in(inMan,money);
    }
}
