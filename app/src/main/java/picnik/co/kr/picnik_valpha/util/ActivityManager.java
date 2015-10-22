package picnik.co.kr.picnik_valpha.util;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by Cha-sc on 2015-10-21.
 */
public class ActivityManager {

    // 전역변수
    private static ActivityManager g_activityMananger = null;
    private ArrayList<Activity> g_activityList = null;

    // 생성될 엑티비티를 담을 배열
    private ActivityManager() {
        g_activityList = new ArrayList<Activity>();
    }

    // 생성자 설정
    public static ActivityManager getInstance() {

        if (ActivityManager.g_activityMananger == null) {
            g_activityMananger = new ActivityManager();
        }
        return g_activityMananger;
    }

    /**
     * 액티비티 리스트 getter.
     *
     * @return activityList
     */
    public ArrayList<Activity> getActivityList() {
        return g_activityList;
    }

    /**
     * 액티비티 리스트에 추가.
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        g_activityList.add(activity);
    }

    /**
     * 액티비티 리스트에서 삭제.
     *
     * @param activity
     * @return boolean
     */
    public boolean removeActivity(Activity activity) {
        return g_activityList.remove(activity);
    }

    /**
     * 모든 액티비티 종료.
     */
    public void finishAllActivity() {
        for (int i = 0; i < g_activityList.size(); i++) {
            g_activityList.get(i).finish();
        }
    }
}
