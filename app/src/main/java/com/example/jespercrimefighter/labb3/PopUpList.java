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

    private ListDisplay listDisplay;
    private int largestID;

    public PopUpList(Context context) {
        super(context);
        init(context);
    }



    private void init(Context context) {
        LinearLayout layout = new LinearLayout(context);
        listDisplay = new ListDisplay(context);
        layout.addView(listDisplay);
        this.setContentView(layout);
        largestID = -1;
    }

    public void update(JSONArray jsonArray, int newLargestID){
        largestID = newLargestID;
        listDisplay.update(jsonArray);
    }

    public int getLargestID(){
        return largestID;
    }


}
