package com.example.myapplication0325;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    Fragment4 fragment4;

    BottomNavigationView navi;
    final String TAG = "Fragment";

    Bundle mBundle;
    TextView timeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 =new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        navi = findViewById(R.id.navigation);

        // 프레그먼트 매니저 객체 생성
        // -> 첫 화면 설정
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame,fragment1).commit();

        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.tab1){
                    Log.d(TAG, "메인 화면 호출!");
                    manager.beginTransaction().replace(R.id.frame,fragment1).commit();

                }else if(item.getItemId() == R.id.tab2){
                    Log.d(TAG, "카메라 화면 호출!");
                    manager.beginTransaction().replace(R.id.frame,fragment2).commit();

                }else if(item.getItemId() == R.id.tab3){
                    Log.d(TAG, "뉴스 화면 호출!");
                    manager.beginTransaction().replace(R.id.frame,fragment3).commit();

                }else{
                    Log.d(TAG, "환경설정 화면 호출!");
                    manager.beginTransaction().replace(R.id.frame,fragment4).commit();

                }

                return true;  // true로 해줘야 클릭된 버튼이 활성화
            }
        });

    } // end

    // Bundel : 데이터를 보관하는 객체  -> 액티비티와 프래그먼트끼리 데이터를 전달해주기 위해!!!!
    // Bundel 객체 초기화 & 접근 메소드 구현


    public Bundle getmBundle() {
        return mBundle;
    }

    public void setmBundle(Bundle mBundle) {
        this.mBundle = mBundle;
    }
}