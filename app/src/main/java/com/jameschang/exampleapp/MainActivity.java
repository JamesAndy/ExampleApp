package com.jameschang.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.jameschang.db.ms100.Ms100I;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //設定日期格式
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    private DatePickerDialog picker;

    private TextView mFinishContent;
    private EditText mReceipt1,mReceipt2,mBuyDate,mTotalAmt;
    private Button mInsertReceipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ms100I ms100I = new Ms100I();
        ms100I.checkTable(getApplicationContext(),null,1);

        mFinishContent = findViewById(R.id.finishContent);

        mReceipt1 = findViewById(R.id.receipt1);
        mReceipt2 = findViewById(R.id.receipt2);
        mBuyDate = findViewById(R.id.buyDate);
        mTotalAmt = findViewById(R.id.totalAmt);
        mInsertReceipt = findViewById(R.id.insertReceipt);

        /*設定按鈕的監聽器*/
        mInsertReceipt.setOnClickListener(insertReceiptOnClick);
        mBuyDate.setOnClickListener(datePicker);
    }

    /**
     * 新增按鈕動作
     */
    private View.OnClickListener insertReceiptOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view){

            String receipt1 = mReceipt1.getText().toString();
            int receipt2 = Integer.parseInt(mReceipt2.getText().toString());
            Date buyDate;
            try {
                buyDate = sdf.parse(mBuyDate.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            double totalAmt = Double.parseDouble(mTotalAmt.getText().toString());

            String message = "輸入完成";

            mFinishContent.setText(message);
        }
    };

    /**
     * 日期選擇器
     */
    private View.OnClickListener datePicker = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            final Calendar cldr = Calendar.getInstance();
            int day = cldr.get(Calendar.DAY_OF_MONTH);
            int month = cldr.get(Calendar.MONTH);
            int year = cldr.get(Calendar.YEAR);
            // date picker dialog
            picker = new DatePickerDialog(MainActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            mBuyDate.setText(year + "/" + (monthOfYear + 1)+"/"+dayOfMonth);
                        }
                    }, year, month, day);
            picker.show();
        }
    };

    private void checkMs100(){

    }
}