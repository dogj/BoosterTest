package com.example.administrator.boostertest.questions;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.boostertest.Data;
import com.example.administrator.boostertest.R;


public class Question2 extends Fragment implements View.OnClickListener {

    private int question_num;
    private RadioGroup radioGroup;
    Question3 question3;
    Data data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Data.score[1]=0;
        View view = inflater.inflate(R.layout.question2,container,false);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        view.findViewById(R.id.radio_1).setOnClickListener(this);
        view.findViewById(R.id.radio_2).setOnClickListener(this);
        view.findViewById(R.id.radio_3).setOnClickListener(this);
        view.findViewById(R.id.radio_4).setOnClickListener(this);
        view.findViewById(R.id.radio_5).setOnClickListener(this);
        view.findViewById(R.id.button_next2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.score[1]==0){
                    Toast.makeText(getActivity(), "You haven't finished this question", Toast.LENGTH_LONG ).show();
                }else {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    question3 = new Question3();
                    transaction.replace(R.id.content, question3);
                    transaction.commit();
                    data = new Data();
                }
            }
        });
        return view;


    }

    @Override
    public void onClick(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){

            case R.id.radio_1:
                Data.score[1]=1;
                break;
            case R.id.radio_2:
                Data.score[1]=3;
                break;
            case R.id.radio_3:
                Data.score[1]=5;
                break;
            case R.id.radio_4:
                Data.score[1]=7;
                break;
            case R.id.radio_5:
                Data.score[1]=10;
                break;
        }
    }
    public int getQuestion_num() {
        return question_num;
    }

    public void setQuestion_num(int question_num) {
        this.question_num = question_num;
    }
}
