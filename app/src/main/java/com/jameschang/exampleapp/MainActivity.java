package com.jameschang.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText receipt1,receipt2,buyDate,totalAmt;
    private Button insertReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receipt1 = findViewById(R.id.receipt1);
        receipt2 = findViewById(R.id.receipt2);
        buyDate = findViewById(R.id.buyDate);
        totalAmt = findViewById(R.id.totalAmt);
        insertReceipt = findViewById(R.id.insertReceipt);

        /*設定按鈕的監聽器*/
        insertReceipt.setOnClickListener(insertReceiptOnClick);
    }

    /**
     * 新增按鈕動作
     */
    private View.OnClickListener insertReceiptOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view){

        }
    }
}