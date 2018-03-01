package peacocktech.in.copydbdemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import peacocktech.in.copydbdemo.helper.LiveBaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String DB_NAME = "rapdatapeacock.db";
    private AppCompatTextView actv_addfile,actv_maintwo,actv_startService;
    private File file;
    private LiveBaseHelper liveBaseHelper = null;
    private Activity activity = null;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;

        actv_addfile = (AppCompatTextView) findViewById(R.id.actv_adddb);
        actv_addfile.setOnClickListener(this);

        actv_maintwo = (AppCompatTextView) findViewById(R.id.actv_maintwo);
        actv_maintwo.setOnClickListener(this);

        actv_startService=(AppCompatTextView)findViewById(R.id.actv_startService);
        actv_startService.setOnClickListener(this);

        liveBaseHelper = new LiveBaseHelper(activity, true, "");



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.actv_adddb:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 1);
                break;
            case R.id.actv_maintwo:
                startActivity(new Intent(activity,Main2Activity.class));
                break;

            case R.id.actv_startService:
                startActivity(new Intent(activity,Main2Activity.class));
                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        switch (requestCode) {

            case 1:

                if (resultCode == RESULT_OK) {

                    String PathHolder = data.getData().getPath();

                    Log.e("PATH", PathHolder);
                    Toast.makeText(MainActivity.this, PathHolder, Toast.LENGTH_LONG).show();
                    deleteDatabase("/data/data/peacocktech.in.copydbdemo/databases/rapdatapeacock.db");
                    liveBaseHelper = new LiveBaseHelper(activity, false,PathHolder);
                }
                break;

        }
    }
}
