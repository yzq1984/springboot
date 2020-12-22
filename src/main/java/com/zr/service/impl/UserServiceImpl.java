package com.zr.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.dao.AccountDao;
import com.zr.model.Account;
import com.zr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findById(String cardid) {
        return accountDao.selectByPrimaryKey(cardid);
    }

    @Override
    @Transactional
    public void add(String cardid) {
        Account account = new Account();
        account.setCardid(cardid);
        accountDao.insertSelective(account);
    }

    @Override
    public List<Account> findAll() {
        PageHelper.startPage(1, 2);
        List<Account> accountList = accountDao.selectList();
        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
        System.out.println(pageInfo.getTotal());
        return accountList;
    }
}
