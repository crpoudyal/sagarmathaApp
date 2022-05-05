package com.example.sagarmatha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentOne extends Fragment {
    TextView tvInfo;


    public  FragmentOne (String info){
        Bundle arg = new Bundle();
        arg.putString("DES",info);
        this.setArguments(arg);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info_layout,container,false);
        tvInfo = view.findViewById(R.id.tv_info);

        Bundle arg = getArguments();
        String info= arg.getString("DES");
        if(info != null){
            tvInfo.setText(info);
        }
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.close();
         inflater.inflate(R.menu.lv_menu,menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                break;
            case R.id.action_delete:
                break;
        }
        return true;
    }
}
