package picnik.co.kr.picnik_valpha.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Cha-sc on 2015-10-21.
 */
public class ImageManager {
    private static ImageManager instance = null;

    // 인스턴스 화
    public synchronized static ImageManager getInstance() {
        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }

    // 그림파일 용량 줄이는 옵션   (줄이는 비율, 리소스, R.아이디 값, 넓이, 높이)
    public Bitmap changeBitmap(int deNum, Resources resource, int r_id, int width, int height) {

        BitmapFactory.Options options = new BitmapFactory.Options();    // 그림파일 가져오는 옵션
        options.inSampleSize = deNum;   // 줄이는 비율
        Bitmap src = BitmapFactory.decodeResource(resource, r_id, options);
        Bitmap resized = Bitmap.createScaledBitmap(src, width, height, true);

        return resized;
    }
}
