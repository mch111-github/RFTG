package com.btssio.applicationrftg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FilmsAdapter extends ArrayAdapter<Films> {

    public FilmsAdapter(Context context, List<Films> dataList) {
        super(context, 0, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Films currentItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_afficherlistedvds, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.titleTextView);
        TextView descriptionTextView = convertView.findViewById(R.id.descriptionTextView);
        TextView releaseYearTextView = convertView.findViewById(R.id.releaseYearTextView);
        TextView lastUpdateTextView = convertView.findViewById(R.id.lastUpdateTextView);

        titleTextView.setText(currentItem.getTitle());
        descriptionTextView.setText(currentItem.getDescription());
        releaseYearTextView.setText(currentItem.getRelease_year());
        lastUpdateTextView.setText(currentItem.getLast_update());

        return convertView;
    }
}
