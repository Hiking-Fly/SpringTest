package com.zjnu.service.impl;

import com.zjnu.domain.Account;
import com.zjnu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountService accountService;
    @Override
    public void save(Account account) {
        accountService.save(account);
    }

    @Override
    public List<Account> findAll() {
       return accountService.findAll();
    }
}
