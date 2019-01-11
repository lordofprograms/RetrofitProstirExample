package com.resttutor.prostiraccapp.presentation.home;

import com.resttutor.prostiraccapp.models.Account;
import com.resttutor.prostiraccapp.models.Device;

import java.util.List;

public interface HomeView {

    void setList(List<Account> accountList);
    void showError(String errorMessage);
    void openDeviceFragment(List<Device> devices);
}
