package com.publicmethod.eric.interactivestory.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.publicmethod.eric.interactivestory.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends Activity {

    @InjectView(R.id.imageView)
    ImageView mImageView;
    @InjectView(R.id.editText)
    EditText mNameField;
    @InjectView(R.id.startButton)
    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameField.getText().toString();
                startStory(name);


            }
        });

    }

    private void startStory(String name) {
        Intent intent = new Intent(getApplicationContext(),StoryActivity.class);
        intent.putExtra(getString(R.string.key_name),name);
        startActivity(intent);

    }

    // Here we can call the onResume method, in it we can place any changes to the activity like
    // changing the name field to blank.
    @Override
    protected void onResume() {
        super.onResume();
        // mNameField.setText("");
    }
}
