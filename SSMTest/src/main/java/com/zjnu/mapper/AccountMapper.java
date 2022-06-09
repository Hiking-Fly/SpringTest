package com.zjnu.mapper;

import com.zjnu.domain.Account;

import java.util.List;

public interface AccountMapper {

    void save(Account account);

    List<Account> findAll();
}
