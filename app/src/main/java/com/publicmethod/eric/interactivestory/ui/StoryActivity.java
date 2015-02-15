package com.publicmethod.eric.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.publicmethod.eric.interactivestory.R;
import com.publicmethod.eric.interactivestory.model.Page;
import com.publicmethod.eric.interactivestory.model.Story;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class StoryActivity extends ActionBarActivity {

    private static final String TAG = StoryActivity.class.getSimpleName();
    @InjectView(R.id.storyImageView)
    ImageView mStoryImageView;
    @InjectView(R.id.storyTextView)
    TextView mStoryTextView;
    @InjectView(R.id.choiceButton1)
    Button mChoiceButton1;
    @InjectView(R.id.choiceButton2)
    Button mChoiceButton2;

    private Story mStory = new Story();
    private String mName;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if (mName == null) {
            mName = getString(R.string.key_name);
        }
        Log.d(TAG, mName);
        
        loadPage(0);

    }

    private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);
        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mStoryImageView.setImageDrawable(drawable);
        
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName);
        mStoryTextView.setText(pageText);
        
        if (mCurrentPage.isFinal()) {
        
            mChoiceButton2.setVisibility(View.INVISIBLE);
            mChoiceButton1.setText(getString(R.string.play_again));
            mChoiceButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            mChoiceButton1.setText(mCurrentPage.getChoice1().getText());
            mChoiceButton2.setText(mCurrentPage.getChoice2().getText());

            mChoiceButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoiceButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }
    }
}
