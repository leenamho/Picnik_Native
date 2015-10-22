package picnik.co.kr.picnik_valpha.main;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import picnik.co.kr.picnik_valpha.R;
import picnik.co.kr.picnik_valpha.util.ParentActivity;

public class MainFormActivity extends ParentActivity {

    // 전역변수
    LinearLayout ll_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);

        // 변수 아이디값 설정
        ll_background = (LinearLayout) findViewById(R.id.ll_background);

        // 바탕화면 색상 설정
        ll_background.setBackgroundResource(R.color.color_background);

        // status bar 색상 수정 부분
        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.color_maincolor));
        }

        // 액션바 셋팅하기ppp
        ActionBarInit();
    }

    // 액션바 셋팅ppp
    private void ActionBarInit() {

        ActionBar actionBar = getSupportActionBar();
        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        // Set custom view layout
        View mCustomView = LayoutInflater.from(this).inflate(R.layout.actionbar_main, null);
        actionBar.setCustomView(mCustomView);

        // Set no padding both side
        Toolbar parent = (Toolbar) mCustomView.getParent(); // first get parent toolbar of current action bar
        parent.setContentInsetsAbsolute(0, 0);              // set padding programmatically to 0dp


        // Set actionbar background image
        //actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.actionbar_bg));

        // Set actionbar layout layoutparams
        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(mCustomView, params);
    }
}
