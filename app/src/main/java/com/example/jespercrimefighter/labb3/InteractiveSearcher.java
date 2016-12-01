package com.example.jespercrimefighter.labb3;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import org.json.JSONArray;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jespercrimefighter on 11/22/16.
 */

public class InteractiveSearcher extends LinearLayout {
    int SEARCHID = 0;

    private PopUpList popUpList;
    private InteractiveSearcher thisIS;
    private EditText searchField;

    private JSONArray itemList;

    public InteractiveSearcher(Context context) {
        super(context);
        setup(context);
    }

    private void setup(final Context context) {
        searchField = new EditText(context);
        popUpList = new PopUpList(context);
        thisIS = this;
        this.addView(searchField);
        this.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
        searchField.setLayoutParams(params);

        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Downloader(thisIS).execute(editable.toString(), String.valueOf(SEARCHID));
                SEARCHID++;
            }
        });


    }

    public void setItemList(JSONArray list){
        itemList = list;
    }


    public PopUpList getPopUpList(){
        return popUpList;
    }

    public EditText getSearchField(){
        return searchField;
    }




}
