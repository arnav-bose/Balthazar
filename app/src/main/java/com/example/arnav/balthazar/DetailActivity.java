package com.example.arnav.balthazar;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private ViewPager viewPagerDetail;
    private ViewPagerAdapterDetail viewPagerAdapterDetail;
    private TabLayout tabLayoutDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tabLayoutDetail = (TabLayout)findViewById(R.id.tab_layout_detail);
        viewPagerDetail = (ViewPager)findViewById(R.id.viewPager_detail);
        getSupportActionBar().setTitle("Details Activity");

        viewPagerAdapterDetail = new ViewPagerAdapterDetail(getSupportFragmentManager());
        viewPagerDetail.setAdapter(viewPagerAdapterDetail);

        final TabLayout.Tab tabAbout = tabLayoutDetail.newTab();
        final TabLayout.Tab tabOffers = tabLayoutDetail.newTab();
        final TabLayout.Tab tabMap = tabLayoutDetail.newTab();

        tabAbout.setText("About");
        tabOffers.setText("Offers");
        tabMap.setText("Map");

        tabLayoutDetail.addTab(tabAbout);
        tabLayoutDetail.addTab(tabOffers);
        tabLayoutDetail.addTab(tabMap);

        tabLayoutDetail.setTabTextColors(ContextCompat.getColorStateList(this, R.color.year));
        tabLayoutDetail.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorAccent));

        tabLayoutDetail.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPagerDetail));
        viewPagerDetail.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutDetail));

        tabLayoutDetail.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPagerDetail.setCurrentItem(0);
                        getSupportActionBar().setTitle("About");
                        break;
                    case 1:
                        viewPagerDetail.setCurrentItem(1);
                        getSupportActionBar().setTitle("Offers");
                        break;
                    case 2:
                        viewPagerDetail.setCurrentItem(2);
                        getSupportActionBar().setTitle("Map");
                    default:
                        viewPagerDetail.setCurrentItem(tab.getPosition());
                        getSupportActionBar().setTitle("Map");
                        break;
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
