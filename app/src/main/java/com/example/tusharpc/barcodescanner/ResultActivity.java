package com.example.tusharpc.barcodescanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String barcode = getIntent().getExtras().getString("barcode");
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        TextView name = (TextView) findViewById(R.id.textView3);
        name.setText(databaseHandler.getProductName(barcode));
        TextView price = (TextView) findViewById(R.id.textView5);
        String s = new Float(databaseHandler.getProductPrice(barcode)).toString();
        price.setText(s);
    }
}
