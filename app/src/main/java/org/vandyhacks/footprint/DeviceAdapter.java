package org.vandyhacks.footprint;

/**
 * Created by ccirr on 10/21/2017.
 */

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.MyViewHolder> {

    private List<BluetoothDevice> devicesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }


    public DeviceAdapter(List<BluetoothDevice> devicesList) {
        this.devicesList = devicesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bt_device_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        BluetoothDevice btDevice = devicesList.get(position);
        holder.name.setText(btDevice.getName() + " - " + btDevice.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.incrementCounter();
                devicesList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return devicesList.size();
    }
}
