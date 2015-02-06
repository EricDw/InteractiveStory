package com.publicmethod.eric.interactivestory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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
                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
            }
        });

    }
}
