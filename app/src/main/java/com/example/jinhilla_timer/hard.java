package com.example.jinhilla_timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hard extends AppCompatActivity {
    int time = 1800, phase=1, now=0, min=0, max=0;
    int[] ar = new int[1000];
    int[] ar2 = new int[1000];
    TextView tv;
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard);
        tv = (TextView)findViewById(R.id.textView);
        btn1=(Button)findViewById(R.id.phase1);
        btn2=(Button)findViewById(R.id.phase2);
        btn3=(Button)findViewById(R.id.phase3);
        time-=166;
        ar[now]=time;
        ar2[now]=phase;
        tv.setText(time/60+" : "+time%60);
    }
    void reload(){
        tv.setText(time/60+" : "+time%60);
        if(phase==1){
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
        }
        else if(phase==2){
            btn1.setEnabled(false);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
        }
        else if(phase==3){
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(true);
        }
    }
    public void undo(View view) {
        if(now<=min){
            //토스트 메시지
        }
        else{
            time=ar[--now];
            phase=ar2[now];
            reload();
        }
    }

    public void redo(View view) {
        if(now>=max){
            //토스트 메시지
        }
        else{
            time=ar[++now];
            phase=ar2[now];
            reload();
        }
    }

    public void phase1(View view) {
        if(time<152) return;
        phase=1;
        time-=152;
        ar[++now]=time;
        ar2[now]=phase;
        if(now>max)max=now;
        reload();
    }

    public void phase2(View view) {
        if(time<126) return;
        phase=2;
        time-=126;
        ar[++now]=time;
        ar2[now]=phase;
        if(now>max)max=now;
        reload();
    }

    public void phase3(View view) {
        if(time<100) return;
        phase=3;
        time-=100;
        ar[++now]=time;
        ar2[now]=phase;
        if(now>max)max=now;
        reload();
    }

    public void plus(View view) {
        if(time>1799) return;
        time+=1;
        ar[++now]=time;
        ar2[now]=phase;
        if(now>max)max=now;
        reload();
    }

    public void minus(View view) {
        if(time<1) return;
        time-=1;
        ar[++now]=time;
        ar2[now]=phase;
        if(now>max)max=now;
        reload();
    }

    public void reset(View view) {
        time=1800;
        time-=166;
        phase=1;
        now=0;
        max=0;
        ar[++now]=time;
        reload();
    }

}