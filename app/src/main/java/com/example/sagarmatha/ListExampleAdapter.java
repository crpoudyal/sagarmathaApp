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
import java.util.List;

public class ListExampleAdapter extends ArrayAdapter<ListData> {

//    if private use 'm' ahead of variable name eg 'mXYZ'

    private  Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ListData> listData;

    public ListExampleAdapter(@NonNull Context context,  @NonNull ArrayList<ListData> listItems) {
        super(context,R.layout.list_item_view, listItems);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.listData = listItems;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        ListData item = listData.get(position);

        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item_view,parent,false);
            viewHolder = new ViewHolder();

            viewHolder.tvDescription = convertView.findViewById(R.id.tv_des);
            viewHolder.tvTitle = convertView.findViewById(R.id.tv_header);

            convertView.setTag(viewHolder);

        }else{
          viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvTitle.setText(item.getTitle());
        viewHolder.tvDescription.setText(item.getDescription());

        return convertView;

    }

    @Override
    public int getCount() {
        return listData.size();
    }

    public  class ViewHolder{
        public TextView tvTitle,tvDescription;
    }
}
