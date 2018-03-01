package peacocktech.in.copydbdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import peacocktech.in.copydbdemo.service.TestIntentService;
import peacocktech.in.copydbdemo.service.Testservice;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Activity activity;
    private GestureDetector gestureDetector = null;
    private GestureDetectorCompat gestureDetectorCompat;
    private AppCompatTextView actv_startService, actv_download;
    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String string = bundle.getString(TestIntentService.FILEPATH);


                Toast.makeText(Main2Activity.this, "Download complete. Download URI: " + string, Toast.LENGTH_LONG).show();

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        activity = Main2Activity.this;

        actv_startService = (AppCompatTextView) findViewById(R.id.actv_startService);
        actv_startService.setOnClickListener(this);
        actv_download = (AppCompatTextView) findViewById(R.id.actv_download);
        actv_download.setOnClickListener(this);

        gestureDetectorCompat = new GestureDetectorCompat(activity, new MyGestureListener() {
        });

        findViewById(R.id.ll_swipe).setOnTouchListener(new OnSwipeTouchListener(activity) {

            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                startActivity(new Intent(activity, MainActivity.class));
                overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);
                finish();
            }

            public void onSwipeLeft() {
            }

            public void onSwipeBottom() {
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actv_startService:
                startService(new Intent(activity, Testservice.class));

                break;
            case R.id.actv_download:

                Toast.makeText(activity, "Click", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TestIntentService.class);
                startService(intent);


                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(
                TestIntentService.NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {

            Log.e("MotionE 1", "" + event1 + " -- " + velocityX);
            Log.e("MotionE 2", "" + event2 + " -- " + velocityY);

            if (event2.getX() > event1.getX() && (event1 != null && event2 != null)) {

                finish();
                overridePendingTransition(R.anim.activity_back_in, R.anim.activity_back_out);

            }

            return true;

        }
    }

}
