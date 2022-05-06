package com.superspecialapp.activitytestexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;

/*
    context
    baseContext
    applicationContext
MVVM -> Model, ViewModel, View
 */
public class MainActivity extends AppCompatActivity {

    //
    String TAG = "*****MainActivity";
    Button btnMainButton;
    Button btnGetImage;
    ImageView ivOurImage;
    TextInputEditText tietInput;
    static String KEY = "KEY";
    //Hey its me Goku!

    /**
     * First callback in the lifecycle
     *  called only ONCE in the lifecycle.
     * Used for opening connections, databases, files
     *  and links the layout xml to the Activity code.
     *  setContentView(layout)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        btnMainButton = findViewById(R.id.btn_main_button);
        btnGetImage = findViewById(R.id.btn_get_image);
        ivOurImage = findViewById(R.id.iv_our_image);
        tietInput = findViewById(R.id.tiet_input);

        tietInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btnMainButton.setEnabled(tietInput.getText().length() > 7);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnMainButton.setOnClickListener(view -> {
            //onClick
            //Explicit Intent
            CharSequence moveToSecond = tietInput.getText();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SecondActivity.class);
            intent.putExtra(KEY, moveToSecond);
            startActivity(intent);
        });
        // POJO == Plain Old Java Object

        btnGetImage.setOnClickListener(view -> {

            // Implicit Intent
            // webpages, read/write document, open files, send messages outside the app
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, 123);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        assert data != null;
        Uri uri = data.getData();

        if (requestCode == 123 && resultCode == Activity.RESULT_OK) {
            ivOurImage.setImageURI(uri);
        }
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