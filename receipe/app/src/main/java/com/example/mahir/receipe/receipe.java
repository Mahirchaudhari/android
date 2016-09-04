package com.example.mahir.receipe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class receipe extends Activity {
    TextView lblrecepiename,lblcontent;
    int ItemId;
    String[] ReceipeList;
    StringBuffer FileContent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_receipelist);
        this.allocatememory();
        ItemId = this.getIntent().getExtras().getInt("ItemId");
        ReceipeList = this.getResources().getStringArray(R.array.receipelist);
        Toast.makeText(this, "received item is " + ReceipeList[ItemId],
                Toast.LENGTH_SHORT).show();

        DataStorage storage = new DataStorage(this);
        if(ItemId==0)
            FileContent = storage.ReadInternalFile(R.raw.pavbhaji);
        else if(ItemId==1)
            FileContent = storage.ReadInternalFile(R.raw.masladosa);
        else if(ItemId==2)
            FileContent = storage.ReadInternalFile(R.raw.dhokla);
        else
            FileContent = storage.ReadInternalFile(R.raw.pavbhaji);

        lblcontent.setText(FileContent.toString());
        lblrecepiename.setText(ReceipeList[ItemId]);

    }
    public void allocatememory(){
        lblcontent = (TextView) this.findViewById(R.id.lblcontent);
        lblrecepiename = (TextView) this.findViewById(R.id.lblreceipename);
    }
}
