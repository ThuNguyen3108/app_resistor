package com.example.introduce.introduce;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {



    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
// tra ve fragment
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OnboardingFragment();
            case 1:
                return new OnboardingFragment2();
            case 2:
                return new OnboardingFragment3();
            default:
                return new OnboardingFragment();
        }
    }
// tra lai so luong cua trang gioi thieu, o day la 3
    @Override
    public int getCount() {
        return 3;
    }
}
