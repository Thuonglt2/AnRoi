package com.example.windows81gamer.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        List<String> dummyAnswer = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            dummyAnswer.add("Answer " + i);
        }

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            questions.add(new Question("Question " + i + 1, dummyAnswer));
        }

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), questions);
        viewPager.setAdapter(adapter);
    }
}