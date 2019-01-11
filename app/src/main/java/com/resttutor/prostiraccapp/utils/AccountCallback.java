package com.resttutor.prostiraccapp.utils;

import com.resttutor.prostiraccapp.models.Account;

import java.util.List;

public interface AccountCallback {

    void setAccountList(List<Account> accountList);
    void setError(String errorMessage);

}
