package com.sust.cgpacalc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CgpaViewHolder extends RecyclerView.ViewHolder {

    public TextView gradeTextView;
    public TextView creditTextView;
    public TextView courseTextView;
    public Button eraseBtn;

    public CgpaViewHolder(@NonNull View itemView) {
        super(itemView);
        gradeTextView = itemView.findViewById(R.id.grade_text);
        creditTextView = itemView.findViewById(R.id.credit_text);
        courseTextView = itemView.findViewById(R.id.course_text);
        eraseBtn = itemView.findViewById(R.id.eraseBtn);
    }
}
