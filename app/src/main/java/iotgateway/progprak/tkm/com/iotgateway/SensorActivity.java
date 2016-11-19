package iotgateway.progprak.tkm.com.iotgateway;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SensorActivity extends AppCompatActivity {

    ListView sensorListView;
    ListAdapter sensorListAdap;
    BluetoothAdapter bluetoothAdapter;

    private final static int REQUEST_ENABLE_BT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        ArrayList<String> blubb = new ArrayList<>();
        for (int i = 0; i< 10; i++){
            blubb.add("schubidu");
        }

        sensorListView = (ListView) findViewById(R.id.sensorListViewId);
        sensorListAdap = new SensorAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, blubb);
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();

        sensorListView.setAdapter(sensorListAdap);

        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }


    }
}
