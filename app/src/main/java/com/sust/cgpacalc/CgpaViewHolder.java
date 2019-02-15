package com.sust.cgpacalc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CgpaViewHolder extends RecyclerView.ViewHolder {

    public TextView gradeTextView;
    public TextView creditTextView;
    public TextView courseTextView;
    public Button eraseBtn;

    public EditText course,grade,credit;
    public Button updCgpa;


    public LinearLayout constantLayout,editableLayout;

    public CgpaViewHolder(@NonNull View itemView) {
        super(itemView);
        constantLayout = itemView.findViewById(R.id.constant_layout);
        editableLayout = itemView.findViewById(R.id.editable_layout);

        gradeTextView = itemView.findViewById(R.id.grade_text);
        creditTextView = itemView.findViewById(R.id.credit_text);
        courseTextView = itemView.findViewById(R.id.course_text);
        eraseBtn = itemView.findViewById(R.id.eraseBtn);

        course = itemView.findViewById(R.id.course_edit_text);
        grade = itemView.findViewById(R.id.grade_edit_text);
        credit = itemView.findViewById(R.id.credit_edit_text);
        updCgpa = itemView.findViewById(R.id.updateBtn);

    }
}
