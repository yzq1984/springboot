package com.zr.dao;

import com.zr.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {
    int deleteByPrimaryKey(String cardid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String cardid);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectList();
}