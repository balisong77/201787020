package com.example.hint;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MyTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_team);
        Intent intent_get = getIntent();
        setVp(intent_get.getStringExtra("RealName_myFrag"));
//        Toast.makeText(MyTeam.this,intent_get.getStringExtra("RealName_myFrag"),)
    }

    private void setVp(String name) {
        final List<Fragment> list = new ArrayList<>();

        PagerFragment fragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("RealName",name);
        fragment.setArguments(bundle);
        list.add(fragment);

        PagerFragment_MyApply fragment_myApply = new PagerFragment_MyApply();
        list.add(fragment_myApply);

        ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(vp);

        tabLayout.getTabAt(0).setText("My team");
        tabLayout.getTabAt(1).setText("My application");
    }

}
