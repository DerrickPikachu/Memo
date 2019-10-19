package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView numberTxv;
    private EditText input;
    private Button cancelBtn, saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_activity);

        numberTxv = findViewById(R.id.inputNum);
        input = findViewById(R.id.inputTxv);
        cancelBtn = findViewById(R.id.cancelBtn);
        saveBtn = findViewById(R.id.saveBtn);

        cancelBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);

        Intent preActivity = getIntent();
        numberTxv.setText(preActivity.getIntExtra("No", 1) + ".");
        input.setText(preActivity.getStringExtra("Memo Data").substring(2) + "\n"
                    + preActivity.getStringExtra("Date"));
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
