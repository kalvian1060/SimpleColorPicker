package com.jonesrandom.simplecolorpicker;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jonesrandom.colorpicker.DialogPicker;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView prev = (ImageView) findViewById(R.id.preview);

        final DialogPicker picker = new DialogPicker(this, new DialogPicker.OnColorSelectedListener() {
            @Override
            public void onColor(int ColorInt, String ColorString) {
                prev.setImageDrawable(new ColorDrawable(Color.parseColor(ColorString)));
            }
        });

        Button showDialog = (Button) findViewById(R.id.showDialog);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.show();
            }
        });

    }
}
