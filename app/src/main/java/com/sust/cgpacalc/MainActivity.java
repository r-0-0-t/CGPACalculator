package com.sust.cgpacalc;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick {

    Database database;
    RecyclerView recyclerView;
    CgpaAdapter adapter;
    List<Cgpa> cgpaList;

    private EditText course,grade,credit;
    private Button addCgpa;
    private TextView calculated_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        course = findViewById(R.id.course_edit_text);
        grade = findViewById(R.id.grade_edit_text);
        credit = findViewById(R.id.credit_edit_text);
        addCgpa = findViewById(R.id.addCgpa_btn);
        calculated_value = findViewById(R.id.cgpa_calculated_text);

        setEditorBehaviors();

        database = new CGPADatabase(this);
        cgpaList = database.read();
        adapter = new CgpaAdapter(cgpaList);
        recyclerView = findViewById(R.id.cgpa_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(this);

        calculateCgpa();
    }

    private void setEditorBehaviors() {
        course.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT) {
                    credit.requestFocus();
                    return true;
                }
                return false;
            }
        });
        credit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_NEXT) {
                    grade.requestFocus();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onItemDeleteCgpa(int position) {
        Toast.makeText(this,cgpaList.get(position).getItemId() + " Removed",Toast.LENGTH_SHORT).show();
        database.delete(cgpaList.get(position).getItemId());
        cgpaList.remove(position);
        recyclerView.removeViewAt(position);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position,cgpaList.size());

        calculateCgpa();
    }


    public void onItemAddCgpa(View view) {
        database.insert((Float.valueOf(credit.getText().toString()))
                ,(Float.valueOf(grade.getText().toString()))
                ,course.getText().toString());
        cgpaList.clear();
        cgpaList.addAll(database.read());
        adapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
        hideSoftKeyboard(this);

        calculateCgpa();
    }

    public void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

    void calculateCgpa() {
        double total = 0,total_credits=0;
        for(Cgpa cgpa : cgpaList) {
            total += cgpa.getCredit()*cgpa.getGrade();
            total_credits += cgpa.getCredit();
        }
        total/=total_credits;
        calculated_value.setText("CGPA : " + total);
    }
}
