package com.example.windows81gamer.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class ListQuestionAdapter extends RecyclerView.Adapter {
    private List<String> answerList;
     int mSelectedPosition = -1;

    ListQuestionAdapter(Question question) {
        this.answerList = question.answerList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_question, parent, false);
        Log.d("Thuong", "ListQuestionAdapter-onCreateViewHolder");
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("Thuong", "ListQuestionAdapter-onBindViewHolder");
        ((ListViewHolder) holder).txtAnswerView.setText(answerList.get(position));
        ((ListViewHolder) holder).mRadiobutton.setChecked(position == mSelectedPosition);
    }

    @Override
    public int getItemCount() {
        return answerList == null ? 0 : answerList.size();
    }


    private class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtAnswerView;
        private RadioButton mRadiobutton;

        ListViewHolder(View itemView) {
            super(itemView);
            txtAnswerView = itemView.findViewById(R.id.answers_content);
            mRadiobutton = itemView.findViewById(R.id.single_list_item_check_button);
            Log.d("Thuong", "ListViewHolder-ListViewHolder-Contructor");

            mRadiobutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}
