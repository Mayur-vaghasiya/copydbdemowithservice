package peacocktech.in.copydbdemo.service;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.support.annotation.Nullable;
import java.net.URL;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by peacock on 23/2/18.
 */

 public class TestIntentService extends IntentService {

    private int result = Activity.RESULT_CANCELED;
    public static final String URL = "urlpath";
    public static final String FILENAME = "filename";
    public static final String FILEPATH = "filepath";
    public static final String RESULT = "result";
    public static final String NOTIFICATION = "service receiver";

    public TestIntentService() {
        super("TestIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        for(int i=0;i<=20;i++){

            publishResults(i);
        }


    }

    private void publishResults(int i) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putExtra(FILEPATH, String.valueOf(i));
        sendBroadcast(intent);
    }
}
