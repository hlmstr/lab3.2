package com.example.jespercrimefighter.labb3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        InteractiveSearcher is = new InteractiveSearcher(this);
        layout.addView(is);
        setContentView(layout);
    }
}
