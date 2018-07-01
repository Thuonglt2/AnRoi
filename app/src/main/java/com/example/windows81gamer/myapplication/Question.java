package com.example.windows81gamer.myapplication;

import android.os.Parcel;
import android.os.Parcelable;


import java.util.List;

public class Question implements Parcelable {
    public String aQuestion;
    public List<String> answerList;
    public boolean isChecked;

    public Question(String aQuestion) {
        this.aQuestion = aQuestion;
    }

    public Question(String aQuestion, List<String> answerList) {
        this.aQuestion = aQuestion;
        this.answerList = answerList;
    }

    protected Question(Parcel in) {
        aQuestion = in.readString();
        answerList = in.createStringArrayList();
    }

    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(aQuestion);
        dest.writeStringList(answerList);
    }
}
