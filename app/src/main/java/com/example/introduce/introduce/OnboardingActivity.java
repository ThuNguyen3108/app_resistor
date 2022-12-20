package com.example.introduce.introduce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.introduce.R;

import me.relex.circleindicator.CircleIndicator;

public class OnboardingActivity extends AppCompatActivity {
    private TextView tvSkip;
    private ViewPager viewPager;
    private RelativeLayout layoutBottom;
    private CircleIndicator circileIndicator;
    private LinearLayout layoutNext;

    private ViewPageAdapter viewPagerAdapter;
// OnboardingActivity dùng để ánh xạ view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        initUI();
// khoi tao ViewPager lên gồm có 2 tham số
        viewPagerAdapter = new ViewPageAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        // dung de gan ViewPager này vào circleIndicator
        circileIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // đến trang cuối cùng thì mình sẽ ẩn nút Skip, và layout ở dưới đi

            @Override
            public void onPageSelected(int position) {
                if(position == 2){
                    tvSkip.setVisibility(View.GONE);
                    layoutBottom.setVisibility(View.GONE);
                }
                else{
                    tvSkip.setVisibility(View.VISIBLE);
                    layoutBottom.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    // haàm này dùng để ánh xạ View
    private void initUI(){
        tvSkip = findViewById(R.id.tv_skip);
        viewPager = findViewById(R.id.view_paper);
        layoutBottom = findViewById(R.id.layout_bottom);
        circileIndicator = findViewById(R.id.circle_indicator);
        layoutNext = findViewById(R.id.layout_next);
        // xét sự kiện cho skip
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });
        layoutNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tức là chưa tới trang cuối cùng thì mình sẽ bấm next để tới trang tiếp theo
                if(viewPager.getCurrentItem() < 2){
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
            }
        });
    }
}