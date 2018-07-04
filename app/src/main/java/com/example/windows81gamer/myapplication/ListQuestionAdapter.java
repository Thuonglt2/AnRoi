package com.example.windows81gamer.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class ListQuestionAdapter extends RecyclerView.Adapter {
    private List<String> answerList;

    ListQuestionAdapter(Question question) {
        this.answerList = question.answerList;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView txtAnswerView;
        private RadioButton mRadioButton;
        private boolean isSelected;

        ListViewHolder(View itemView) {
            super(itemView);
            txtAnswerView = itemView.findViewById(R.id.answers_content);
            mRadioButton = itemView.findViewById(R.id.single_list_item_check_button);
        }

        void bindView(String answer) {

            txtAnswerView.setText(answer);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isSelected) {
                        mRadioButton.setChecked(true);
                    } else {
                        mRadioButton.setChecked(false);
                    }
                    isSelected = !isSelected;
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_question, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(answerList.get(position));
    }

    @Override
    public int getItemCount() {
        return answerList == null ? 0 : answerList.size();
    }
}
