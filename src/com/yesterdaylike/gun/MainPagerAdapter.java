package com.yesterdaylike.gun;

import java.util.List;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainPagerAdapter extends PagerAdapter {

	private int mCount;
	//界面列表
	private List<View> mViews;
	private int[] mGuns = {
			R.drawable.handgun,
			R.drawable.rifles,
			R.drawable.tactical_rifle,
			R.drawable.shotgun,
			R.drawable.tactical_shotgun,
			R.drawable.combo_gun,
			R.drawable.black_powder_rifle,
			R.drawable.revolver,
			R.drawable.specialty,
	};
	
	private String[] mGunsName;

	public MainPagerAdapter ( Context context, List<View> views ) {
		this.mViews = views;
		mCount = mGuns.length;
		mGunsName = context.getResources().getStringArray(R.array.gun_kind_name);
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		View view = mViews.get( position);
		( ( ViewPager ) container).removeView( view );
	}

	@Override
	public void finishUpdate(View container) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		View view = mViews.get(position);
		( ( ViewPager ) container).addView( view );
		((ImageButton)view.findViewById(R.id.gun_category)).setImageResource(mGuns[position]);
		((TextView)view.findViewById(R.id.gun_category_name)).setText(mGunsName[position]);
		//mOnInstantiateItemListener.OnInstantiateItem(position,position);
		return view;
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}

	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
		// TODO Auto-generated method stub
		super.restoreState(state, loader);
	}

	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return super.saveState();
	}

	@Override
	public void startUpdate(View container) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mCount;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}
}
