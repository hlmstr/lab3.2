package com.example.jespercrimefighter.labb3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;

/**
 * Created by jespercrimefighter on 12/2/16.
 */

public class ListDisplay extends View{

    private JSONArray itemList;
    private Paint paint;

    public ListDisplay(Context context){
        super(context);
        paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.RED);
        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500));

    }

    public void update(JSONArray itemList){
        this.itemList = itemList;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float yPos = 100;
        float xPos = 20;
        try {
            for (int i = 0; i < itemList.length(); i++) {
                canvas.drawText(itemList.get(i).toString() , xPos , yPos , paint);
                yPos += 100;
            }
        }catch (Exception e){
            //@// TODO: 12/2/16 do something
            e.printStackTrace();
        }

    }
}
