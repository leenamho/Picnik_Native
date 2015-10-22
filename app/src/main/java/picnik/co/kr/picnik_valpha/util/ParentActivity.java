package picnik.co.kr.picnik_valpha.util;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Cha-sc on 2015-10-21.
 */
public class ParentActivity extends AppCompatActivity {
    private ActivityManager am = ActivityManager.getInstance();

    // 생성자
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        am.addActivity(this);
    }

    // 파괴자
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        am.removeActivity(this);
    }
}
