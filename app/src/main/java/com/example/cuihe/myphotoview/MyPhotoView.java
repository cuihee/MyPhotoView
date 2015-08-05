package com.example.cuihe.myphotoview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class MyPhotoView extends ActionBarActivity {
    private int currentImage;	//当前显示图片
    private ImageView image_all;
    protected Integer[] images ={R.drawable.c2, R.drawable.mumu, R.drawable.qop, R.drawable.ti5};
    protected Integer image_number = images.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_photo_view);

        image_all = (ImageView) findViewById(R.id.image_all);
        Button prov = (Button) findViewById(R.id.prov_page);
        prov.setOnClickListener(new ProvOnClickListener());
        Button next = (Button) findViewById(R.id.next_page);
        next.setOnClickListener(new NextOnClickListener());
    }
    private class ProvOnClickListener implements View.OnClickListener{
        public void onClick(View view){
            image_all.setImageResource(images[--currentImage % image_number]);
        }
    }
    private class NextOnClickListener implements View.OnClickListener{
        public void onClick(View view){
            image_all.setImageResource(images[++currentImage % image_number]);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_photo_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
