package com.god.ioclkhata.Adapter;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.god.ioclkhata.Fragment.CreditFragment;
import com.god.ioclkhata.Fragment.DashBoardFragment;
import com.god.ioclkhata.Fragment.SalesFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DashBoardFragment db = new DashBoardFragment();
                return db;
            case 1:
                SalesFragment sf = new SalesFragment();
                return sf;
            case 2:
                CreditFragment cf = new CreditFragment();
                return cf;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}

