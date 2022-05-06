package com.superspecialapp.activitytestexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    String TAG = "*****SecondActivity";
    Button btnSecondButton;
    Button btnOpenSecond;
    TextView tvSecondTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate");

        btnSecondButton = findViewById(R.id.btn_second_button);
        btnOpenSecond = findViewById(R.id.btn_open_second);
        tvSecondTitle = findViewById(R.id.tv_second_title);

        Intent newIntent = getIntent();
        tvSecondTitle.setText(newIntent.getCharSequenceExtra(MainActivity.KEY));


        btnSecondButton.setOnClickListener(view -> {
            Intent intent = new Intent(
                    SecondActivity.this,
                    MainActivity.class
            );
            startActivity(intent);
        });
        btnOpenSecond.setOnClickListener(view -> {
            Intent intent = new Intent(
                    SecondActivity.this,
                    SecondActivity.class
            );
            startActivity(intent);
        });
    }

    /**
     * Called immediately after the inflate process completes.
     *  Used to modify the content of the view.
     *  The view/layout is visible, but not interactive
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * Your 'running' state.
     *  The UI is visible and interactive
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    /**
     * Called when the Activity is going into a transition.
     * Layout is visible but not interactive
     * Save User's data state.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    /**
     * Your layout is no longer visible, but is still in memory.
     * Used to close connected, dispose files.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    /**
     * Your app is about to be disposed.
     * Sometimes it is not invoked.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    /**
     * Calls the onStart
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}