package com.example.myapplication0325;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


public class Fragment3 extends Fragment {
    int pos = 0;
    public Fragment3() {

    }

    // onCreate() -> onCreateView() 실행된다.
    // 프레그 먼트 화면에 정의한 View id 연결, 이벤트 등등

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View fragment = inflater.inflate(R.layout.fragment_3, container, false);


       SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
       String bg = sharedPref.getString("bg","white"); // editor.putString("bg","black"); -> fragment_3에서 전달해준 데이터 값 받아주기
       String color = sharedPref.getString("color","black");

       Log.d("Fragment",bg+","+color);

       ConstraintLayout frag3_layout = fragment.findViewById(R.id.frag3_layout);
       TextView textView = fragment.findViewById(R.id.textView);
       ImageView img = fragment.findViewById(R.id.imgs);
       ImageButton btn_L = fragment.findViewById(R.id.btn_L);
       ImageButton btn_R = fragment.findViewById(R.id.btn_R);
       ImageButton btn_1 = fragment.findViewById(R.id.btn_1);
       ImageButton btn_2 = fragment.findViewById(R.id.btn_2);
       ImageButton btn_3 = fragment.findViewById(R.id.btn_3);
       ImageButton btn_4 = fragment.findViewById(R.id.btn_4);


       int[] imgs = {R.drawable.tt, R.drawable.cc, R.drawable.kk}; // 상단바 이미지 배열에 저장

       // 왼쪽/오른쪽 버튼 누르면 이미지 변환
       btn_L.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               pos -= 1;
               if(pos<0){
                   pos=2;
               }
               img.setImageResource(imgs[pos]);
           }
       });
       btn_R.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               pos += 1;
               if(pos>2){
                   pos=0;
               }
               img.setImageResource(imgs[pos]);
           }
       });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Btn_1_Activity.class);
                startActivity(intent);

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Btn_2_Activity.class);
                startActivity(intent);
            }
        });
       btn_3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),Btn_3_Activity.class);
               startActivity(intent);
           }
       });
       btn_4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),Btn_4_Activity.class);
               startActivity(intent);
           }
       });

        
       frag3_layout.setBackgroundColor(Color.parseColor(bg)); // bg가 String 타입으로 저장이 되어있기 때문에 parseColor 을 써줘서 int타입으로 변경


       return fragment;
    }
}