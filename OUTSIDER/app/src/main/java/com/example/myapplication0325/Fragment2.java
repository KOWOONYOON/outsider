package com.example.myapplication0325;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class Fragment2 extends Fragment {

    public Fragment2() {
        // Required empty public constructor
    }

    // onCreate() -> onCreateView() 실행된다.
    // 프레그 먼트 화면에 정의한 View id 연결, 이벤트 등등

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.fragment_2, container, false);

        MainActivity activity =(MainActivity) getActivity();

        // 메인 액티비티의 Bundle 객체에 정보가 담겨있다면
        if(activity.getmBundle()!=null){
            Bundle bundle = activity.getmBundle();

            TextView tvData = fragment.findViewById(R.id.tvData);
            tvData.setText(bundle.getString("msg"));
        }else{
            Log.d("Fragment","데이터 접근 오류...");
        }



        return fragment;
    }
}