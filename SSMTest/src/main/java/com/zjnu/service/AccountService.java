package com.zjnu.service;

import com.zjnu.domain.Account;

import java.util.List;

public interface AccountService {


    void save(Account account);

    List<Account> findAll();

}
