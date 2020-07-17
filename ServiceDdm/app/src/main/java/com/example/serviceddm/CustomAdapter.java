package com.example.serviceddm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final  String[] items;
    private final Integer[] logo;
    public CustomAdapter(Context context, String[] items, Integer[] logo) {
        super(context, R.layout.custom_layout, items);
        this.context = context;
        this.items = items;
        this.logo = logo;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.custom_layout, null, true);

        TextView title = (TextView) rowView.findViewById(R.id.text);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);

        title.setText(items[position]);
        image.setImageResource(logo[position]);

        return rowView;
    }
}
