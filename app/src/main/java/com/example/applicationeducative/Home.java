package com.example.applicationeducative;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import android.os.Bundle;

import com.example.applicationeducative.Fragments.AnimalsFragment;
import com.example.applicationeducative.Fragments.NumbersFragment;
import com.example.applicationeducative.Fragments.VowelsFragment;

public class Home extends AppCompatActivity {

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        smartTabLayout = findViewById(R.id.smartTabLayout);
        viewPager = findViewById(R.id.viewPager);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Animaux", AnimalsFragment.class)
                        .add("Nombres", NumbersFragment.class)
                        .add("Lettres", VowelsFragment.class)
                        .create()
        );

        // view pager
        viewPager.setAdapter(adapter);

        // tab layout
        smartTabLayout.setViewPager(viewPager);
    }
}