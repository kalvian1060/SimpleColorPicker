package com.jonesrandom.colorpicker;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonesrandom.colorpicker.utils.Adapter;

/**
 * Created by Masx Developer on 5/2/17.
 * https://masx-dev.blogspot.com
 */

public class DialogPicker {

    private OnColorSelectedListener Listener;
    private Context ctx;
    private String baseColor;

    public DialogPicker(Context ctx, OnColorSelectedListener listener) {
        Listener = listener;
        this.ctx = ctx;
    }

    public void show() {

        View v = LayoutInflater.from(ctx).inflate(R.layout.color_dialog, null, false);

        final ImageView ColorChanged = (ImageView) v.findViewById(R.id.colorChanged);
        final TextView ColorString = (TextView) v.findViewById(R.id.colorString);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(ctx, 10);

        RecyclerView ColorBar = (RecyclerView) v.findViewById(R.id.colorBar);
        ColorBar.setHasFixedSize(true);
        ColorBar.setLayoutManager(gridLayoutManager);
        ColorBar.setAdapter(new Adapter(ctx, new Adapter.OnColorClicked() {
            @Override
            public void onColorClick(String warna) {
                baseColor = warna;
                ColorChanged.setImageDrawable(new ColorDrawable(Color.parseColor(warna)));
                ColorString.setText(warna);

            }
        }));

        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setView(v);
        builder.setNegativeButton("KELUAR", null);
        builder.setPositiveButton("OKE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (baseColor == null) {
                    baseColor = "#000000";
                }
                Listener.onColor(Color.parseColor(baseColor), baseColor);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public interface OnColorSelectedListener {

        void onColor(int ColorInt, String ColorString);

    }
}
