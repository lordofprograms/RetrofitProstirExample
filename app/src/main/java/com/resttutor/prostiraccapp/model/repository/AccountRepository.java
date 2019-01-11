package com.resttutor.prostiraccapp.model.repository;

import com.resttutor.prostiraccapp.utils.AccountCallback;
import com.resttutor.prostiraccapp.model.api.AccountApi;
import com.resttutor.prostiraccapp.models.Account;
import com.resttutor.prostiraccapp.models.Accounts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepository {

    private AccountApi accountApi;

    public AccountRepository(AccountApi accountApi) {
        this.accountApi = accountApi;
    }

    public void getAccountsList(final AccountCallback callback) {
        accountApi.getAccounts().enqueue(new Callback<Accounts>() {
            @Override
            public void onResponse(Call<Accounts> call, Response<Accounts> response) {
                List<Account> accountList = response.body().getAccounts();
                accountList.addAll(accountList);
                // set data to callback
                callback.setAccountList(accountList);
            }

            @Override
            public void onFailure(Call<Accounts> call, Throwable t) {
                // error callback
                callback.setError(t.getMessage());
            }
        });
    }

}
