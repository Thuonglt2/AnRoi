package com.example.windows81gamer.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuestionFragment extends Fragment {

    Question question;
    RecyclerView recyclerView;
    TextView questionTxt;
    Button buttonContinue, btnCheck;
    RadioButton selectedAnswer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question_fragment_layout, container, false);

        Bundle bundle = getArguments();
        if (bundle != null) {
            question = bundle.getParcelable("QUESTION");
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        questionTxt = view.findViewById(R.id.question);
        question.isChecked = false;

        btnCheck = view.findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListQuestionAdapter listQuestionAdapter = new ListQuestionAdapter(question);
        recyclerView.setAdapter(listQuestionAdapter);
        questionTxt.setText(question.aQuestion);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
