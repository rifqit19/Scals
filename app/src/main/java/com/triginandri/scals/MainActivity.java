package com.triginandri.scals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout tlShape;
    ViewPager vpShape;
    ViewPagerAdapter viewPagerAdapter;
    ImageView ivShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tlShape = findViewById(R.id.tl_shape);
        vpShape = findViewById(R.id.vp_shape);
        ivShape = findViewById(R.id.img_bg);

        viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager());
        vpShape.setAdapter(viewPagerAdapter);

        // It is used to join TabLayout with ViewPager.
        tlShape.setupWithViewPager(vpShape);

        tlShape.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("position", " :"+position);

                if (position == 0){
                    ivShape.setImageResource(R.drawable.square);
                }else if (position == 1){
                    ivShape.setImageResource(R.drawable.triangle);
                }else if (position == 2){
                    ivShape.setImageResource(R.drawable.circle);
                }else{
                    ivShape.setImageResource(R.drawable.logo1);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}