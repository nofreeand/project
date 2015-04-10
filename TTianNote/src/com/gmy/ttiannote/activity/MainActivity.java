package com.gmy.ttiannote.activity;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.fragment.LeftFragment;
import com.gmy.ttiannote.fragment.MidFragment;
import com.gmy.ttiannote.fragment.RightFragment;
import com.gmy.ttiannote.widget.ContainerViewPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivity implements OnClickListener {
	public static int screenWidth;
	public static int screenHeight;
	private ContainerViewPager mViewPager;
	private Fragment  mMidFragment, mRightFragment;
	private LeftFragment mLeftFragment;
	private ArrayList<Fragment> fragmentLists;
	private MyFragementAdapter mAdapter;
	//private Button leftBottomButton, midBottomButton, rightBottomButton; 底部选择图标

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById();
		initData();
		initLayout();

	}
	private void findViewById() {
		// TODO Auto-generated method stub
		mViewPager = (ContainerViewPager) findViewById(R.id.main_vp);
//		leftBottomButton = (Button) findViewById(R.id.leftbottom_tv);
//		midBottomButton = (Button) findViewById(R.id.midbottom_tv);
//		rightBottomButton = (Button) findViewById(R.id.rightbottom_tv);
	}

	private void initData() {
		// TODO Auto-generated method stub
		WindowManager mWindowManager = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		screenWidth = mWindowManager.getDefaultDisplay().getWidth();
		screenHeight = mWindowManager.getDefaultDisplay().getHeight();

		mLeftFragment = new LeftFragment();
		mMidFragment = new MidFragment();
		mRightFragment = new RightFragment();

		fragmentLists = new ArrayList<Fragment>();
		fragmentLists.add(mLeftFragment);
		fragmentLists.add(mMidFragment);
		fragmentLists.add(mRightFragment);

	}

	private void initLayout() {
		// 初始化两侧侧滑布局
		final SlidingMenu mSlidingMenu = new SlidingMenu(this);
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		mSlidingMenu.setShadowWidth(10);
		mSlidingMenu.setShadowDrawable(R.drawable.ic_launcher);
		mSlidingMenu.setMenu(R.layout.left_slidingmenu);
		mSlidingMenu.setBehindOffset((screenWidth * 3) / 5);
		mSlidingMenu.setFadeDegree(0.35f);
		mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT); // 关键设置
		mSlidingMenu.setMode(SlidingMenu.LEFT);

		mAdapter = new MyFragementAdapter(getSupportFragmentManager(),
				fragmentLists);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setPageTransformer(true, new ViewPagerAnimaiton());
		// 监听事件绑定

//		leftBottomButton.setOnClickListener(this);
//		midBottomButton.setOnClickListener(this);
//		rightBottomButton.setOnClickListener(this);
		mViewPager.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				if(mViewPager.getCurrentItem()==0 && mLeftFragment!=null){
					mLeftFragment.onActivityTouch(event);
				}
				return false;
			}
		});
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if (arg0 != 0) {
					mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
				} else {
					mSlidingMenu
							.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.leftbottom_tv:
			mViewPager.setCurrentItem(0, true);
			break;
		case R.id.midbottom_tv:
			mViewPager.setCurrentItem(1, true);
			break;
		case R.id.rightbottom_tv:
			mViewPager.setCurrentItem(2, true);
			break;
		default:
			break;
		}
	}
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return super.onTouchEvent(event);
	}
	
	
	private class MyFragementAdapter extends FragmentPagerAdapter {
		private ArrayList<Fragment> list;

		public MyFragementAdapter(FragmentManager fm, ArrayList<Fragment> list) {
			super(fm);
			this.list = list;
		}

		@Override
		public Fragment getItem(int arg0) {
			// TODO Auto-generated method stub
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}
		
	}
	
	//viewpager页面切换动画实现类
	private class ViewPagerAnimaiton implements PageTransformer{

		@Override
		public void transformPage(View view, float position) {
			// TODO Auto-generated method stub
			if(position<-1){
				view.setAlpha(0);
			}else if (position<=0) {//-1,0 09 08 07 06
				view.setAlpha(1+position);
				view.setPivotX(0.5f);
				view.setPivotY(0.5f);
				view.setScaleX(1-position);
				view.setScaleY(1-position);
			}else if (position<=1) {//0,1 
				view.setAlpha(1-position);
			}else {
//				view.setAlpha(0);
			}
		}
		
	}
}
