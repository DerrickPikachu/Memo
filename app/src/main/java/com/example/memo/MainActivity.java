package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private class MainListener implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            toEdit.putExtra("No", i+1);
            toEdit.putExtra("Memo Data", numberList[i]);

            startActivityForResult(toEdit, i);
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            numberList[i] = (i+1) + ".";
            listAdapter.notifyDataSetChanged();
            return true;
        }
    }

    String[] numberList = {"1.Click ot edit", "2.Long click ot erase memo", "3.", "4.", "5.", "6."};
    ArrayAdapter<String> listAdapter;
    ListView memoList;
    Intent toEdit;
    MainListener listener = new MainListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberList);
        memoList = findViewById(R.id.memoList);
        memoList.setAdapter(listAdapter);
        memoList.setOnItemClickListener(listener);
        memoList.setOnItemLongClickListener(listener);

        toEdit = new Intent(this, EditActivity.class);
    }

    @Override
    protected void onActivityResult(int id, int resultCode, Intent intent) {
        System.out.println("in onActivityResult!");

        if (resultCode == RESULT_OK) {
            String data = intent.getStringExtra("Data");
            String modifiedDate = "modified at \n" + intent.getStringExtra("Date");

            numberList[id] = (id+1) + "." + data;
            Toast.makeText(this, modifiedDate, Toast.LENGTH_LONG).show();
        }
        else if (resultCode == RESULT_CANCELED) {
            System.out.println("no content");
        }

        listAdapter.notifyDataSetChanged();
        super.onActivityResult(id, resultCode, intent);
    }
}
