package com.resttutor.prostiraccapp.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.resttutor.prostiraccapp.R;
import com.resttutor.prostiraccapp.model.repository.AccountRepository;
import com.resttutor.prostiraccapp.models.Account;
import com.resttutor.prostiraccapp.models.Device;
import com.resttutor.prostiraccapp.presentation.home.HomePresenter;
import com.resttutor.prostiraccapp.presentation.home.HomeView;
import com.resttutor.prostiraccapp.utils.OnItemClickListener;

import java.util.List;

import static com.resttutor.prostiraccapp.ProstirApp.getAccountApi;

public class HomeFragment extends Fragment implements HomeView {
    View view;
    RecyclerView recyclerView;
    AccountAdapter adapter;

    HomePresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        if (presenter == null) {
            presenter = new HomePresenter(this, new AccountRepository(getAccountApi()));
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.home_toolbar);
        toolbar.setTitle(getString(R.string.home_title));

        recyclerView = view.findViewById(R.id.accounts_rv);
        recyclerView.setSaveEnabled(true);
        adapter = new AccountAdapter(callback);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        presenter.setList();
    }

    OnItemClickListener.OnItemClickCallback callback = new OnItemClickListener.OnItemClickCallback() {
        @Override
        public void onItemClicked(View view, int position) {
            presenter.openDevices(position);
        }
    };

    @Override
    public void setList(List<Account> accountList) {
        adapter.setData(accountList);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity(), getString(R.string.error_message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openDeviceFragment(List<Device> devices) {

    }
}
