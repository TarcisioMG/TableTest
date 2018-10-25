package com.example.alunoifpe.tabletest;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTable(4, 4);


        //ConstraintLayout mainLayout = findViewById(R.id.mainLayout);

        //mainLayout.addView(table);


        //setContentView(table);

    }

    private void createTable(int columnNumber, int rowNumber) {
        //TableLayout table = new TableLayout(this);
        TableLayout table = findViewById(R.id.tableLayout);
        table.removeAllViews();

        for(int i = 0; i < rowNumber; i++) {
            TableRow row = new TableRow(MainActivity.this);
            for(int j = 0; j < columnNumber; j++) {
                ImageView image = new ImageView(MainActivity.this);
                image.setImageResource(R.mipmap.as);
                image.setAdjustViewBounds(true);
                //image.setGravity(Gravity.CENTER);
                row.addView(image);
            }

            table.addView(row);
        }

        //table.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

        table.setStretchAllColumns(true);
        table.setGravity(Gravity.CENTER);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            createTable(6, 2);
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            createTable(4, 4);
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }
}
