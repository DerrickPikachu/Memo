package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        toEdit.putExtra("No", i+1);
        toEdit.putExtra("Memo Data", numberList[i]);
        startActivity(toEdit);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        numberList[i] = (i+1) + ".";
        listAdapter.notifyDataSetChanged();
        return true;
    }

//    private class MainListener implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
//
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            toEdit.putExtra("No", i+1);
//            toEdit.putExtra("Memo Data", numberList[i]);
////            toEdit.putExtra("Date", new Date().toString());
//
////            startActivityForResult(toEdit, i);
//            startActivity(toEdit);
//        }
//
//        @Override
//        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//            numberList[i] = (i+1) + ".";
//            listAdapter.notifyDataSetChanged();
//            return true;
//        }
//    }

    private String[] numberList = {"1.Click ot edit", "2.Long click ot erase memo", "3.", "4.", "5.", "6."};
    private ArrayAdapter<String> listAdapter;
    private ListView memoList;
    private Intent toEdit = new Intent(this, EditActivity.class);
//    MainListener listener = new MainListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numberList);
        memoList = findViewById(R.id.memoList);
        memoList.setAdapter(listAdapter);
        memoList.setOnItemClickListener(this);
        memoList.setOnItemLongClickListener(this);
    }

//    protected void onActivityResult(int id, int resultNo, Intent intent) {
//        if (resultNo == RESULT_CANCELED) {
//            numberList[id] = id + ",";
//        }
//        else if (resultNo == RESULT_OK) {
//            String data = intent.getStringExtra("Data");
//            numberList[id] = id + "." + data;
//        }
//
//        listAdapter.notifyDataSetChanged();
//        super.onActivityResult(id, resultNo, intent);
//    }
}
