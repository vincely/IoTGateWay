package iotgateway.progprak.tkm.com.iotgateway;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vince on 15.11.16.
 */

public class SensorAdapter extends ArrayAdapter<String> {


    ArrayList<String> aList;
    Context context;

    public SensorAdapter(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        aList = objects;
    }

    private class ViewHolder {

        TextView sensorName;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        String rowItem = aList.get(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listviewitems, null);
            holder = new ViewHolder();
            holder.sensorName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.sensorName.setText(rowItem);

        return convertView;
    }



}

