package com.example.sagarmatha;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sagarmatha.Db.ContactDbHelper;

public class DbFragment extends Fragment {
    EditText edtId,edtName,edtPhone;
    Button btnAdd;

    ContactDbHelper contactDbHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view =inflater.inflate(R.layout.add_contact_fragment,container,false);

            edtId = view.findViewById(R.id.edt_id);
            edtName =view.findViewById(R.id.edt_name);
            edtPhone = view.findViewById(R.id.edt_phone);
            btnAdd = view.findViewById(R.id.btn_add);

            contactDbHelper = new ContactDbHelper(inflater.getContext());

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (validate()) {
                        boolean isSuccess = contactDbHelper.insertContact
                                (Integer.parseInt(edtId.getText().toString()),
                                        edtName.getText().toString(), edtPhone.getText().toString());

                    if (isSuccess) {
                        Toast.makeText(getContext(), "Added Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Added unsuccess", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            });


        return view;
    }
    public boolean validate(){
        if(edtId.getText().toString().isEmpty()){
            edtId.setError("Please enter id");
            return false;
        }else if(edtName.getText().toString().isEmpty()){
            edtName.setError("Please enter name");
            return false;

        }else if(edtPhone.getText().toString().isEmpty()){
            edtPhone.setText("Please enter phone");
            return false;

        }else{
            return true;
        }
    }
}
