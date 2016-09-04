package com.example.mahir.receipe;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class receipelist extends ListActivity {

    String[] ReceipeList; //declration of array
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ReceipeList = this.getResources().getStringArray(R.array.receipelist);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ReceipeList);
        ListView myview = this.getListView();
        myview.setAdapter(adapter);

        myview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(receipelist.this,receipe.class);
                intent.putExtra("Item id",position);
                receipelist.this.startActivity(intent);
            }
        });

    }
}
