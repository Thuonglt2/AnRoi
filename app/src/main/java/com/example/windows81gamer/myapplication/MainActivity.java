package com.example.windows81gamer.myapplication;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    List<Question> questions = new ArrayList<>();
    List<String> dummyAnswer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(30);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference().child("questions");

        questions = new ArrayList<>();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                questions.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Log.d("Nam", "onDataChange: ");

                    List<String> dummyAnswer = new ArrayList<>();
                    for (DataSnapshot answerSnapshot : postSnapshot.getChildren()) {
                        for(DataSnapshot childAnswerSnapshot: answerSnapshot.getChildren()) {
                            childAnswerSnapshot.child("answer_text").getValue();
                            dummyAnswer.add(childAnswerSnapshot.child("answer_text").getValue().toString());
                        }
                    }

                    Log.d("Thuong", "size" + dummyAnswer.size());
                    Question question = new Question(postSnapshot.child("question_text").getValue().toString(), dummyAnswer);

                    questions.add(question);

                    PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), questions);
                    viewPager.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }
}