package com.triginandri.scals;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CustomAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentArrayList= new ArrayList<>();
    ArrayList<String> stringArrayList=new ArrayList<>();
    Activity context;

    int[] imageList={R.drawable.logo,R.drawable.logo2,R.drawable.logo};

    public CustomAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public CustomAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    // Create constructor
    public void addFragment(Fragment fragment,String s)
    {
        // Add fragment
        fragmentArrayList.add(fragment);
        // Add title
        stringArrayList.add(s);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
//        Fragment fragment = null;
//        if (position == 0)
//            fragment = new Square();
//        else if (position == 1)
//            fragment = new Square();
//        else if (position == 2)
//            fragment = new Square();
//
//        return fragment;
        return fragmentArrayList.get(position);

    }

    @Override
    public int getCount() {
//        return 3;
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        String title = null;
//        if (position == 0)
//            title = "Persegi";
//        else if (position == 1)
//            title = "Segitiga";
//        else if (position == 2)
//            title = "Lingkaran";
//        return title;

        Drawable drawable= ContextCompat.getDrawable(context.getApplicationContext()
                ,imageList[position]);

        // set bound
        drawable.setBounds(0,0,drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());

        // Initialize spannable image
        SpannableString spannableString=new SpannableString(""+stringArrayList.get(position));

        // Initialize image span
        ImageSpan imageSpan=new ImageSpan(drawable,ImageSpan.ALIGN_BOTTOM);

        // Set span
        spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // return spannable string
        return spannableString;
    }
}
