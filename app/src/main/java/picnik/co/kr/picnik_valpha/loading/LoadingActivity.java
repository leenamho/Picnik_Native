package picnik.co.kr.picnik_valpha.loading;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;

import picnik.co.kr.picnik_valpha.R;
import picnik.co.kr.picnik_valpha.main.MainFormActivity;
import picnik.co.kr.picnik_valpha.util.ImageManager;
import picnik.co.kr.picnik_valpha.util.ParentActivity;

public class LoadingActivity extends ParentActivity {

    // 선언문
    private AnimationDrawable ad_picnik_loading;
    private ImageView iv_loading;
    private int num_loadingCount = 4;   // 로딩 하는 이미지 카운트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        // 실질적인 화면의 크기
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        // 로딩 화면 설정하는 소스코드
        //drawble 전역 변수 배열 선언
        iv_loading = (ImageView) findViewById(R.id.iv_loading);

        Bitmap[] picArr = new Bitmap[num_loadingCount];

        ImageManager iv = ImageManager.getInstance();
        picArr[0] = iv.changeBitmap(1, getResources(), R.mipmap.loading01, width, height);
        picArr[1] = iv.changeBitmap(1, getResources(), R.mipmap.loading02, width, height);
        picArr[2] = iv.changeBitmap(1, getResources(), R.mipmap.loading03, width, height);
        picArr[3] = iv.changeBitmap(1, getResources(), R.mipmap.loading04, width, height);

        ArrayList<Drawable> frame = new ArrayList<Drawable>();
        //onCreate안에 drawable배열 안에 Bitmap으로 된 이미지 저장
        //여기서 Bitmap은 picArr이라는 Bitmap배열에서 비트맵을 for문을 돌려 추가해 주었다
        for (int i = 0; i < num_loadingCount; i++) {
            frame.add(new BitmapDrawable(picArr[i]));
        }
        //시간설정
        int duration = 1000;

        //AnimationDrawable생성
        AnimationDrawable mAnimation = new AnimationDrawable();

        //AnimationDrawable에 for문을 돌려 Drawable배열에 저장되어 있는 Bitmap을 추가해 주었다.
        for (int i = 0; i < num_loadingCount; i++) {
            mAnimation.addFrame(frame.get(i), duration);
        }

        iv_loading.setBackgroundDrawable(mAnimation);
        mAnimation.setOneShot(true);

        // 16 버전 이하단은 status bar 처리
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            // status bar 숨기기
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

        // 액션바 셋팅
        ActionBarInit();
        // 애니메이션 스타트
        mAnimation.start();

        // 로딩 메서드
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                // 첫 로딩을 만드는 부분
                Intent intent = new Intent(LoadingActivity.this, MainFormActivity.class);
                startActivity(intent);
            }
        };

        // 4초 이후 화면 전환
        handler.sendEmptyMessageDelayed(0, 4000);
    }

    // 액션바 셋팅ppp
    private void ActionBarInit() {
        ActionBar actionBar = getSupportActionBar();
        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
        actionBar.hide();
    }
}
