package com.publicmethod.eric.interactivestory.model;

/**
 * Created by Owner on 2/9/2015.
 */
public class Choice {
    
    private String mText;
    private int mNextPage;
    
    public Choice(String text,int nextPage ){
        mText = text;
        mNextPage = nextPage;
        }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
