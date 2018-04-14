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


public class Question3 extends Fragment implements View.OnClickListener {

    private int question_num;
    private RadioGroup radioGroup;
    Question4 question4;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Data.score[2]=0;
        View view = inflater.inflate(R.layout.question3,container,false);
        radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        view.findViewById(R.id.radio_1).setOnClickListener(this);
        view.findViewById(R.id.radio_2).setOnClickListener(this);
        view.findViewById(R.id.radio_3).setOnClickListener(this);
        view.findViewById(R.id.radio_4).setOnClickListener(this);
        view.findViewById(R.id.radio_5).setOnClickListener(this);
        view.findViewById(R.id.button_next3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Data.score[2]==0){
                    Toast.makeText(getActivity(), "You haven't finished this question", Toast.LENGTH_LONG ).show();
                }else {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction transaction = fm.beginTransaction();
                    question4 = new Question4();
                    transaction.replace(R.id.content, question4);
                    transaction.commit();
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
                Data.score[2]=1;
                break;
            case R.id.radio_2:
                Data.score[2]=3;
                break;
            case R.id.radio_3:
                Data.score[2]=5;
                break;
            case R.id.radio_4:
                Data.score[2]=7;
                break;
            case R.id.radio_5:
                Data.score[2]=10;
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
