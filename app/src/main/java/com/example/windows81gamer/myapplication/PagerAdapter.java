package com.example.windows81gamer.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public List<Question> questionList;

    public PagerAdapter(FragmentManager fm, List<Question> questions) {
        super(fm);
        questionList = questions;
    }

    @Override
    public Fragment getItem(int pos) {
        QuestionFragment questionFragment = new QuestionFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("QUESTION", questionList.get(pos));
        questionFragment.setArguments(bundle);

        return questionFragment;
    }

    @Override
    public int getCount() {
       return questionList.size();

    }
}
