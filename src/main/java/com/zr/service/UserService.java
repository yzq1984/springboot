package com.zr.service;

import com.zr.model.Account;

import java.util.List;

public interface UserService {
    Account findById(String cardid);

    void add(String cardid);

    List<Account> findAll();
}
