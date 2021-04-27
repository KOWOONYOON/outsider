package com.example.myapplication0325;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


public class Fragment3 extends Fragment {

    public Fragment3() {
        // Required empty public constructor
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


       // 넘겨받은 배경색과 글자색 데이터를 UI 디자인으로 적용하시오
       // - 레이아웃과 텍스트 뷰에 적용
       ConstraintLayout frag3_layout = fragment.findViewById(R.id.frag3_layout);
       TextView textView = fragment.findViewById(R.id.textView);

       frag3_layout.setBackgroundColor(Color.parseColor(bg)); // bg가 String 타입으로 저장이 되어있기 때문에 parseColor 을 써줘서 int타입으로 변경
       textView.setTextColor(Color.parseColor(color));

        return fragment;
    }
}