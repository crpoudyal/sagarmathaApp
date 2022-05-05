package com.example.sagarmatha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogExample extends DialogFragment {
    EditText edtTitle,description;
    Button btnOk,btnCancel;

    public static  DialogExample init(String title){
        DialogExample fragment = new DialogExample();
        Bundle arg = new Bundle();
        arg.putString("Title",title);
        fragment.setArguments(arg);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.custom_dialog,container,false);
        edtTitle = view.findViewById(R.id.edt_title);
        description = view.findViewById(R.id.edt_description);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);


        if(getArguments() != null){
            String title = getArguments().getString("Title");
            edtTitle.setText(title);
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogExample.this.dismiss();

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogExample.this.dismiss();

            }
        });
        return view;
    }
}
