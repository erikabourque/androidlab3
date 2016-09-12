package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class ActivityOne extends Activity {

    // string for logcat documentation
    private final static String TAG = "Lab-ActivityOne";


    // lifecycle counts
    int onCreateCount = 0,onStartCount = 0, onResumeCount = 0, onPauseCount = 0,
            onStopCount = 0, onDestroyCount = 0, onRestartCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        //Log cat print out
        Log.i(TAG, "onCreate called");

        // Grabbing the integers from SharedPreferences if exists
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        onCreateCount = prefs.getInt("onCreateCount", 0);
        onStartCount = prefs.getInt("onStartCount", 0);
        onResumeCount = prefs.getInt("onResumeCount", 0);
        onPauseCount = prefs.getInt("onPauseCount", 0);
        onStopCount = prefs.getInt("onStopCount", 0);
        onDestroyCount = prefs.getInt("onDestroyCount", 0);
        onRestartCount = prefs.getInt("onRestartCount", 0);

        // Grabbing the integers from bundle, if exists
        if (savedInstanceState != null)
        {
            onCreateCount = savedInstanceState.getInt("onCreateCount");
            onStartCount = savedInstanceState.getInt("onStartCount");
            onResumeCount = savedInstanceState.getInt("onResumeCount");
            onPauseCount = savedInstanceState.getInt("onPauseCount");
            onStopCount = savedInstanceState.getInt("onStopCount");
            onDestroyCount = savedInstanceState.getInt("onDestroyCount");
            onRestartCount = savedInstanceState.getInt("onRestartCount");
        }

        //Updating Count and View for all methods
        onCreateCount++;
        TextView txtView = (TextView) findViewById(R.id.create);
        String str = getResources().getString(R.string.onCreate) + onCreateCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.start);
        str = getResources().getString(R.string.onStart) + onStartCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.destroy);
        str = getResources().getString(R.string.onDestroy) + onDestroyCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.restart);
        str = getResources().getString(R.string.onRestart) + onRestartCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.pause);
        str = getResources().getString(R.string.onPause) + onPauseCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.stop);
        str = getResources().getString(R.string.onStop) + onStopCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.resume);
        str = getResources().getString(R.string.onResume) + onResumeCount;
        txtView.setText(str);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_one, menu);
        return true;
    }

    // lifecycle callback overrides

    @Override
    public void onStart() {
        super.onStart();

        //Log cat print out
        Log.i(TAG, "onStart called");

        //Updating Count and View
        onStartCount++;
        TextView txtView = (TextView) findViewById(R.id.start);
        String str = getResources().getString(R.string.onStart) + onStartCount;
        txtView.setText(str);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //Log cat print out
        Log.i(TAG, "onDestroy called");

        //Updating Count and View
        onDestroyCount++;
        TextView txtView = (TextView) findViewById(R.id.destroy);
        String str = getResources().getString(R.string.onDestroy) + onDestroyCount;
        txtView.setText(str);
    }

    @Override
    public void onRestart() {
        super.onRestart();

        //Log cat print out
        Log.i(TAG, "onRestart called");

        //Updating Count and View
        onRestartCount++;
        TextView txtView = (TextView) findViewById(R.id.restart);
        String str = getResources().getString(R.string.onRestart) + onRestartCount;
        txtView.setText(str);
    }

    @Override
    public void onPause() {
        super.onPause();

        //Log cat print out
        Log.i(TAG, "onPause called");

        //Updating Count and View
        onPauseCount++;
        TextView txtView = (TextView) findViewById(R.id.pause);
        String str = getResources().getString(R.string.onPause) + onPauseCount;
        txtView.setText(str);
    }

    @Override
    public void onStop() {
        super.onStop();

        //Log cat print out
        Log.i(TAG, "onStop called");

        //Updating Count and View
        onStopCount++;
        TextView txtView = (TextView) findViewById(R.id.stop);
        String str = getResources().getString(R.string.onStop) + onStopCount;
        txtView.setText(str);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt("onStartCount", onStartCount);
        edit.putInt("onCreateCount", onCreateCount);
        edit.putInt("onDestroyCount", onCreateCount);
        edit.putInt("onRestartCount", onCreateCount);
        edit.putInt("onPauseCount", onCreateCount);
        edit.putInt("onStopCount", onCreateCount);
        edit.putInt("onResumeCount", onCreateCount);

        edit.commit();
    }

    @Override
    public void onResume() {
        super.onResume();

        //Log cat print out
        Log.i(TAG, "onResume called");

        //Updating Count and View
        onResumeCount++;
        TextView txtView = (TextView) findViewById(R.id.resume);
        String str = getResources().getString(R.string.onResume) + onResumeCount;
        txtView.setText(str);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // save state information with a collection of key-value pairs
        // save all  count variables
        savedInstanceState.putInt("onStartCount", onStartCount);
        savedInstanceState.putInt("onCreateCount", onCreateCount);
        savedInstanceState.putInt("onDestroyCount", onCreateCount);
        savedInstanceState.putInt("onRestartCount", onCreateCount);
        savedInstanceState.putInt("onPauseCount", onCreateCount);
        savedInstanceState.putInt("onStopCount", onCreateCount);
        savedInstanceState.putInt("onResumeCount", onCreateCount);
    }

    public void launchActivityTwo(View view) {
        // This function launches Activity Two.
        // Hint: use Context’s startActivity() method.
        Intent intent = new Intent(this, ActivityTwo.class);
        startActivity(intent);
    }

    public void clear(View view) {
        // Sets all the counters to 0 and updates the views
        onCreateCount = 0;
        onStartCount = 0;
        onResumeCount = 0;
        onPauseCount = 0;
        onStopCount = 0;
        onDestroyCount = 0;
        onRestartCount = 0;

        TextView txtView = (TextView) findViewById(R.id.create);
        String str = getResources().getString(R.string.onCreate) + onCreateCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.start);
        str = getResources().getString(R.string.onStart) + onStartCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.destroy);
        str = getResources().getString(R.string.onDestroy) + onDestroyCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.restart);
        str = getResources().getString(R.string.onRestart) + onRestartCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.pause);
        str = getResources().getString(R.string.onPause) + onPauseCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.stop);
        str = getResources().getString(R.string.onStop) + onStopCount;
        txtView.setText(str);

        txtView = (TextView) findViewById(R.id.resume);
        str = getResources().getString(R.string.onResume) + onResumeCount;
        txtView.setText(str);
    }


}
