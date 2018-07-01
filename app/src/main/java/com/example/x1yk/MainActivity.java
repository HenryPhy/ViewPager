package com.example.x1yk;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private RadioGroup radioGroup;
    private List<Fragment> list = new ArrayList<>();
    private CheckBox checkbox1;
    private TextView one_delete;
    private ViewPager vp;
    private RadioButton rb_main_chat;
    private RadioButton rb_main_contact;
    private RadioButton rb_main_setting;
    private RadioGroup rg_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        final oneFragment oneFragment = new oneFragment();
        TwoFragment twoFragment = new TwoFragment();
        threeFragment threeFragment = new threeFragment();
        list.add(oneFragment);
        list.add(twoFragment);
        list.add(threeFragment);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), this, list);
        viewPager.setAdapter(adapter);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_main_chat:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_main_contact:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.rb_main_setting:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    oneAdapter.isChecked=true;
                    oneFragment.one.notifyDataSetChanged();
                    checkbox1.setText("取消全选");
                }else {
                    oneAdapter.isChecked=false;
                    oneFragment.one.notifyDataSetChanged();
                    checkbox1.setText("全选");
                }
            }
        });
    }
    private void initView() {
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        one_delete = (TextView) findViewById(R.id.one_delete);
        vp = (ViewPager) findViewById(R.id.vp);
        rb_main_chat = (RadioButton) findViewById(R.id.rb_main_chat);
        rb_main_contact = (RadioButton) findViewById(R.id.rb_main_contact);
        rb_main_setting = (RadioButton) findViewById(R.id.rb_main_setting);
        rg_main = (RadioGroup) findViewById(R.id.rg_main);
        viewPager = findViewById(R.id.vp);
        radioGroup = findViewById(R.id.rg_main);
    }

    class FragmentAdapter extends FragmentPagerAdapter {
        public FragmentAdapter(FragmentManager fm, Context context, List<Fragment> list) {
            super(fm);
            this.context = context;
            this.list = list;
        }
        private Context context;
        private List<Fragment> list;

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
    }
}