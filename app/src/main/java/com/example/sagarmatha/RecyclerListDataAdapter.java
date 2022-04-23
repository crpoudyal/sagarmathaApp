package com.example.sagarmatha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerListDataAdapter extends RecyclerView.Adapter<RecyclerListDataAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ListData> listItems;
    private LayoutInflater mInflater;

    public RecyclerListDataAdapter(Context context, ArrayList<ListData> ListItems){
        this.mContext = context;
        this.listItems = ListItems;
        this.mInflater = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListData data = listItems.get(position);

        holder.tvTitle.setText(data.getTitle());
        holder.tvDescription.setText(data.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tv_header);
            tvDescription = itemView.findViewById(R.id.tv_des);

        }
    }
}
