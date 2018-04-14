package com.example.administrator.boostertest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/14.
 */

public class Data {
    public static int[] score ={0,0,0,0,0};




    public static void setScore(int i, int s){
        score[i]=s;
    }
    public static int count(){
        int count = 0;
        for(int a = 0;a< score.length;a++){
            count =count+ score[a];
        }
        return count;
    }
    public static boolean isFinished(){
        boolean finish = true;
        for(int a = 0;a< score.length;a++){
            if(score[a]==0){
                finish=false;
            }
        }
        return finish;
    }

}
