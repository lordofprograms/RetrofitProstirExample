package com.resttutor.prostiraccapp.presentation.home;

import com.resttutor.prostiraccapp.utils.AccountCallback;
import com.resttutor.prostiraccapp.model.repository.AccountRepository;
import com.resttutor.prostiraccapp.models.Account;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter {

    private HomeView view;
    private AccountRepository repository;

    private List<Account> accounts = new ArrayList<>();

    public HomePresenter(HomeView view, AccountRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void setList() {
        repository.getAccountsList(new AccountCallback() {
            @Override
            public void setAccountList(List<Account> accountList) {
                accounts.addAll(accountList);
                view.setList(accounts);
            }

            @Override
            public void setError(String errorMessage) {
                view.showError(errorMessage);
            }
        });
    }

    public void openDevices(int position) {
        view.openDeviceFragment(accounts.get(position).getDevices());
    }

}
