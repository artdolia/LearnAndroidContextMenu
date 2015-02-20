package com.dolia.artsiom.p0151_contextmenu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    final int MENU_COLOR_RED    = 1;
    final int MENU_COLOR_GREEN  = 2;
    final int MENU_COLOR_BLUE   = 3;

    final int MENU_SIZE_22  = 4;
    final int MENU_SIZE_26  = 5;
    final int MENU_SIZE_30  = 6;

    TextView tvColor, tvSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvColor = (TextView) findViewById(R.id.tvColor);
        tvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(tvColor);
        registerForContextMenu(tvSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        switch (v.getId()){

            case R.id.tvColor:
                menu.add(0, MENU_COLOR_RED, 0, "RED");
                menu.add(0, MENU_COLOR_GREEN, 0, "GREEN");
                menu.add(0, MENU_COLOR_BLUE, 0, "BLUE");
                break;

            case R.id.tvSize:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case MENU_COLOR_RED:
                tvColor.setTextColor(Color.RED);
                tvColor.setText("Text color = red");
                break;

            case MENU_COLOR_GREEN:
                tvColor.setTextColor(Color.GREEN);
                tvColor.setText("Text color = green");
                break;

            case MENU_COLOR_BLUE:
                tvColor.setTextColor(Color.BLUE);
                tvColor.setText("Text color = blue");
                break;

            case MENU_SIZE_22:
                tvSize.setTextSize(22);
                tvSize.setText("Font size = 22");
                break;

            case MENU_SIZE_26:
                tvSize.setTextSize(26);
                tvSize.setText("Font size = 26");
                break;

            case MENU_SIZE_30:
                tvSize.setTextSize(30);
                tvSize.setText("Font size = 30");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
