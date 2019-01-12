package com.resttutor.prostiraccapp.ui.device;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.resttutor.prostiraccapp.R;
import com.resttutor.prostiraccapp.models.Device;
import com.resttutor.prostiraccapp.utils.Consts;

import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private List<Device> deviceList = new ArrayList<>();

    public void setData(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder deviceViewHolder, int position) {
        Device device = deviceList.get(position);
        deviceViewHolder.bind(device);
    }

    @Override
    public int getItemCount() {
        return deviceList.size();
    }

    class DeviceViewHolder extends RecyclerView.ViewHolder {
        ImageView deviceTypeIv;
        TextView deviceTv;
        TextView lastDateTv;

        DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            this.deviceTypeIv = itemView.findViewById(R.id.device_type_iv);
            this.deviceTv = itemView.findViewById(R.id.device_tv);
            this.lastDateTv = itemView.findViewById(R.id.device_date_tv);
        }

        void bind(Device device) {
            if (device.getDeviceType().equals(Consts.SMARTPHONE)) {
                deviceTypeIv.setBackgroundResource(R.drawable.ic_smartphone);
            }
            else deviceTypeIv.setBackgroundResource(R.drawable.ic_tablet);

            deviceTv.setText(device.getDeviceName());
            lastDateTv.setText(device.getLastUseDate());
        }

    }

}
