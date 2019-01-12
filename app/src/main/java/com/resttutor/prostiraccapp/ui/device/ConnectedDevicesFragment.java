package com.resttutor.prostiraccapp.ui.device;

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

import com.resttutor.prostiraccapp.R;
import com.resttutor.prostiraccapp.models.Device;
import com.resttutor.prostiraccapp.utils.Consts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConnectedDevicesFragment extends Fragment {
    private View view;

    private RecyclerView recyclerView;
    private DeviceAdapter adapter;

    public static ConnectedDevicesFragment newInstance(List<Device> devices) {
        Bundle args = new Bundle();
        ConnectedDevicesFragment fragment = new ConnectedDevicesFragment();
        args.putSerializable(Consts.DEVICE_LIST_KEY, (Serializable) devices);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_connected_devices, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.device_toolbar);
        toolbar.setTitle(getString(R.string.connected_devices_title));

        recyclerView = view.findViewById(R.id.devices_rv);
        recyclerView.setSaveEnabled(true);
        adapter = new DeviceAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (getArguments() != null) {
            List<Device> devices = (ArrayList<Device>) getArguments().getSerializable(Consts.DEVICE_LIST_KEY);
            adapter.setData(devices);
        }

    }

}
