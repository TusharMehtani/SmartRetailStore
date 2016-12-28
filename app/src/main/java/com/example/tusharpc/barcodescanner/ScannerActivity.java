package com.example.tusharpc.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScannerActivity extends AppCompatActivity {
    String barcode;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        barcode=result.getContents();
        if(result != null){
            if (barcode==null){
                Toast.makeText(this,"Cancelled",Toast.LENGTH_LONG).show();
            }
            else{
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
        Intent toResult = new Intent(this,ResultActivity.class);
        toResult.putExtra("barcode",barcode);
        startActivity(toResult);
    }
}
