package com.example.jespercrimefighter.labb3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jespercrimefighter on 11/23/16.
 */

public class PopUpList extends /*List*/PopupWindow {

    JSONArray itemList;

    public PopUpList(Context context) {
        super(context);
        init(context);
    }

    public PopUpList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }

    public PopUpList(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    public PopUpList(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    /**
     *@TODO: 2016-11-30 Skapa en en ny component som ärver från view som vi kan skriva ut listan på.
     */
    private void init(Context context) {
        LinearLayout layout = new LinearLayout(context);
        TextView textView = new TextView(context);
        textView.setText("POPUP");
        layout.addView(textView);
        this.setContentView(layout);
    }


}
