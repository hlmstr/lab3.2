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

    public InteractiveSearcher(Context context) {
        super(context);
        setup(context);
    }


    static PopUpList pul;
    private void setup(final Context context) {
        EditText searchField = (EditText) new EditText(context);
        pul = new PopUpList(context);
        this.addView(searchField);
        this.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(params);
        searchField.setLayoutParams(params);
        PopUpList pul = new PopUpList(context);
        //downloader.setPopUpList(pul);
        PopupWindow p = new PopupWindow(2000,200);
        p.showAtLocation(searchField, Gravity.CENTER, 50,50);


        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                new Downloader().execute(editable.toString(), String.valueOf(SEARCHID));
                SEARCHID++;
            }
        });



    }






}
