package peacocktech.in.copydbdemo;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListener extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_THRESHOLD = 100, SWIPE_VELOCITY_THRESHOLD = 100;

    private Activity activity;

    public GestureListener(Activity activity) {

        this.activity = activity;

    }

    @Override
    public boolean onDown(MotionEvent e) {

        return true;

    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
                           float velocityY) {

        boolean result = false;

        try {

            float diff1 = event1.getX();

            float diff2 = event2.getX();

            if (Math.abs(diff2) > Math.abs(diff1)) {

                /*if (Math.abs(diff2) > SWIPE_THRESHOLD && Math.abs(velocityX) >
                        SWIPE_VELOCITY_THRESHOLD) {*/

                    activity.finish();

                    activity.overridePendingTransition(R.anim.activity_back_in,
                            R.anim.activity_back_out);

                //}
            }
        } catch (Exception exception) {

            exception.printStackTrace();

        }

        return result;

    }
}
