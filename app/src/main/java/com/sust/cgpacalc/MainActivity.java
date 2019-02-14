package com.sust.cgpacalc;

import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    Database database;
    RecyclerView recyclerView;
    CgpaAdapter adapter;
    List<Cgpa> cgpaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new CGPADatabase(this);
        cgpaList = database.read();
        adapter = new CgpaAdapter(cgpaList);
        recyclerView = findViewById(R.id.cgpa_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,cgpaList.get(position).getItemId() + " Removed",Toast.LENGTH_SHORT).show();
        database.delete(cgpaList.get(position).getItemId());
        cgpaList.remove(position);
        recyclerView.removeViewAt(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position,cgpaList.size());
    }
}
