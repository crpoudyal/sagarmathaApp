package com.example.sagarmatha;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.net.URI;
import java.util.ArrayList;

public class ListExampleActivity extends AppCompatActivity {

    Toolbar toolbar;

    public ListView lvTest;
    public ArrayList<ListData> listItems;
    private ListExampleAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);




        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvTest = findViewById(R.id.lv_text);

        listItems = new ArrayList<>();
        listItems.add(new ListData("Android","This is description for title"));
        listItems.add(new ListData("Android","This is description for title"));
        mAdapter = new ListExampleAdapter(this,listItems);

        lvTest.setAdapter(mAdapter);
        lvTest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Toast.makeText(ListExampleActivity.this, "Item Clicked "+position, Toast.LENGTH_SHORT).show();

            }
        });

        lvTest.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
            showCustomDialog();
                return true;
            }
        });

    }

    private void showConformationDialog(){
        AlertDialog.Builder builder = new  AlertDialog.Builder(ListExampleActivity.this).setTitle("Warning").
                setMessage("Did you want to Delete?").
                setCancelable(false).
                setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create(); //Create only not display
        dialog.show();
    }



    private void showOptionDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ListExampleActivity.this).setTitle("Choose any option")
                .setItems(R.array.dialog_item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(ListExampleActivity.this, "You have clicked position "+i, Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create(); //Create only not display
        dialog.show();

    }

    private void showMultipleOptionDialog(){

        final int[] count  = {0};
        AlertDialog.Builder builder  = new AlertDialog.Builder(ListExampleActivity.this)
                .setTitle("Select option ")
                .setMultiChoiceItems(R.array.dialog_item, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean b) {
                    if(b){
                        count[0] = count[0]+1;
                    }else{
                        count[0]=count[0]-1;
                    }

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Toast.makeText(ListExampleActivity.this, "Selected option count:"+ count[0], Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.lv_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_add:
//                listItems.add(new ListData("New title","This is description for title"));
//                mAdapter.notifyDataSetChanged();
//                break;
//            case R.id.action_delete:
////                listItems.remove(0);   // Remove first items
//                listItems.remove(listItems.size()-1);  // Remove last items
//                mAdapter.notifyDataSetChanged();
//                break;
//            case android.R.id.home:
//                finish();
//                break;
//            default:
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

    public void showCustomDialog(){
        View dialogView = LayoutInflater.from(this)
                .inflate(R.layout.custom_dialog,null,false);


        EditText edtTitle,edtDescription;
        Button btnOk,btnCancel;

        edtTitle = dialogView.findViewById(R.id.edt_title);
        edtDescription = dialogView.findViewById(R.id.edt_description);
        btnOk = dialogView.findViewById(R.id.btn_ok);
        btnCancel = dialogView.findViewById(R.id.btn_cancel);

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtTitle.getText().toString().isEmpty() && !edtDescription.getText().toString().isEmpty()){
                    listItems.add(new ListData(edtTitle.getText().toString(),edtDescription.getText().toString()));
                    mAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else{
                    if(edtTitle.getText().toString().isEmpty()){
                        edtTitle.setError("No Title found");
                    }else if(edtDescription.getText().toString().isEmpty()){
                        edtDescription.setError("No Description found");
                    }
                }

            }
        });
    }


}
