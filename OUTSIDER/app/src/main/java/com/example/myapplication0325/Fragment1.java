package com.example.myapplication0325;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment {

    public Fragment1() {
        // Required empty public constructor
    }

    // onCreate() -> onCreateView() 실행된다.
    // 프레그 먼트 화면에 정의한 View id 연결, 이벤트 등등

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // fragment --> fragment_1.xml을 가리킨다.
        View fragment = inflater.inflate(R.layout.fragment_1, container, false);


        // frgment_1.xml에서 btnSave 찾기!
        Button btnSave =fragment.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle(); // 객체 생성
                bundle.putString("msg","Hello~ 예은, 덕연, 명서");

                // 메인 액티비티에 정의된 Bundle 객체에 저장
                MainActivity activity =(MainActivity)getActivity(); // (MainActivity)로 변경해서 값을 getActivity();가져와야함.
                activity.setmBundle(bundle); //초기화
           
            }
        });
        //fragment.findViewById();



        return fragment;
    }
}