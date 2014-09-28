package viewpagerdemo.android.baidao.com.androidwizard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;


public class MyActivity extends FragmentActivity implements OnPageInteractionListener, PageFragmentCallback {

    StepPagerStrip stepPagerStrip;
    ViewPager viewPager;
    WizardAdapter adapter;
    Button preButton;
    Button nextButton;
    PageContainer pageContainer = new PageContainer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new WizardAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        stepPagerStrip = (StepPagerStrip) findViewById(R.id.strip);
        stepPagerStrip.setPageCount(adapter.getCount());

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {
                stepPagerStrip.setCurrentPage(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        initWizardButtons();
    }

    private void initWizardButtons() {
        preButton = (Button) findViewById(R.id.prev_button);
        nextButton = (Button) findViewById(R.id.next_button);

        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPrev();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNext();
            }
        });
    }

    private void goPrev() {
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private void goNext() {
        if (viewPager.getCurrentItem() != adapter.getCount() - 1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    @Override
    public void onPageInteraction(Page data) {
        if (data != null) {
            System.out.println("---------------------onPageInteraction: " + data.getTitle());
        }
    }

    @Override
    public Page getPage(int id) {
        return pageContainer.getPage(id);
    }

    public class WizardAdapter extends SmartFragmentStatePagerAdapter {

        public WizardAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            return pageContainer.getPage(i).getFragment();
        }

        @Override
        public int getCount() {
            return pageContainer.size();
        }
    }
}
