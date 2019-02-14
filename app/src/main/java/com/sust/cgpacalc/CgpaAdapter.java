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
    public void onBindViewHolder(@NonNull CgpaViewHolder cgpaViewHolder, final int i) {
        cgpaViewHolder.courseTextView.setText(cgpaList.get(i).getCourse());
        cgpaViewHolder.creditTextView.setText(((Float)cgpaList.get(i).getCredit()).toString());
        cgpaViewHolder.gradeTextView.setText(((Float)cgpaList.get(i).getGrade()).toString());
        cgpaViewHolder.eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemDeleteCgpa(i);
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
