package com.jojo.layouts;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class layoutListAdapter  extends FragmentPagerAdapter {
    public layoutListAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new RelativeClass();
            case 1:
                return new LinearClass();
            case 2:
                return new ConstraintClass();
            case 3:
                return new FrameClass();
            case 4:
                return new TableClass();
            case 5:
                return new ListClass();
            case 6:
                return new GridClass();
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return 7;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "3";
            case 3:
                return "4";
            case 4:
                return "5";
            case 5:
                return "6";
            case 6:
                return "7";
            default:
                return null;
        }
    }
}