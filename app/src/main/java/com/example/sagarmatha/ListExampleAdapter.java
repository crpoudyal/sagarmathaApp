package com.example.sagarmatha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListExampleAdapter extends ArrayAdapter<ListData> {

//    if private use 'm' ahead of variable name eg 'mXYZ'

    private  Context mContext;
    private LayoutInflater mInflater;

    public ListExampleAdapter(@NonNull Context context,  @NonNull ArrayList<ListData> listItems) {
        super(context,R.layout.list_item_view, listItems);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
    public  class ViewHolder{
        public TextView tvTitle,tvDescription;
    }
}
