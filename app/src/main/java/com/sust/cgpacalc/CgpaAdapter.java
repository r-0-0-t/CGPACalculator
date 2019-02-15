package com.sust.cgpacalc;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

public class CgpaAdapter extends RecyclerView.Adapter<CgpaViewHolder> {

    private List<Cgpa> cgpaList;
    private OnItemClick onItemClick;

    public CgpaAdapter(List<Cgpa> cgpaList) {
        this.cgpaList = cgpaList;
    }

    @NonNull
    @Override
    public CgpaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_row,viewGroup,false);
        return new CgpaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull final CgpaViewHolder cgpaViewHolder, final int i) {
        final Float credit = cgpaList.get(i).getCredit();
        final Float grade = cgpaList.get(i).getGrade();
        String course = cgpaList.get(i).getCourse();
        Long _id = cgpaList.get(i).getItemId();

        cgpaViewHolder.courseTextView.setText(course);
        cgpaViewHolder.creditTextView.setText(credit.toString());
        cgpaViewHolder.gradeTextView.setText(grade.toString());
        cgpaViewHolder.course.setText(course);
        cgpaViewHolder.credit.setText(credit.toString());
        cgpaViewHolder.grade.setText(grade.toString());

        cgpaViewHolder.eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemDeleteCgpa(i);
            }
        });
        cgpaViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                cgpaViewHolder.constantLayout.setVisibility(View.GONE);
                cgpaViewHolder.editableLayout.setVisibility(View.VISIBLE);
                return true;
            }
        });

        cgpaViewHolder.updCgpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float updGrade = Float.valueOf(cgpaViewHolder.grade.getText().toString());
                float updCredit = Float.valueOf(cgpaViewHolder.credit.getText().toString());
                String updCourse = cgpaViewHolder.course.getText().toString();

                onItemClick.onItemUpdateCgpa(updCredit,updGrade,updCourse,i);
                cgpaViewHolder.constantLayout.setVisibility(View.VISIBLE);
                cgpaViewHolder.editableLayout.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cgpaList.size();
    }

    public void setOnClick(OnItemClick onClick)
    {
        this.onItemClick=onClick;
    }
}
