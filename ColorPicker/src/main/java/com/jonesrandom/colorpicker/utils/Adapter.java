package com.jonesrandom.colorpicker.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.jonesrandom.colorpicker.R;

/**
 * Created by Masx Developer on 5/2/17.
 * https://masx-dev.blogspot.com
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ColorHolder> {

    private Context ctx;
    private OnColorClicked Clicked;

    public Adapter(Context ctx , OnColorClicked Clicked) {
        this.ctx = ctx;
        this.Clicked = Clicked;
    }

    @Override
    public ColorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ColorHolder(LayoutInflater.from(ctx).inflate(R.layout.row_color_bar , parent , false));
    }

    @Override
    public void onBindViewHolder(final ColorHolder holder, int position) {

        final String warna = Data.getColorData().get(position);

        WindowManager wManager = (WindowManager)ctx.getSystemService(Context.WINDOW_SERVICE);
        Display display = wManager.getDefaultDisplay();
        Point p = new Point();
        display.getSize(p);

        holder.ColorBar.getLayoutParams().height = p.x / 10;
        holder.ColorBar.requestLayout();
        holder.ColorBar.setImageDrawable(new ColorDrawable(Color.parseColor(warna)));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clicked.onColorClick(warna);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Data.getColorData().size();
    }

    public class ColorHolder extends RecyclerView.ViewHolder{

        ImageView ColorBar;

        ColorHolder(View itemView) {
            super(itemView);

            ColorBar = (ImageView) itemView.findViewById(R.id.bar);
        }
    }

    public interface OnColorClicked{
        void onColorClick(String Color);
    }
}
