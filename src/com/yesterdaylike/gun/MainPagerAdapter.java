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

	private String[] mGunsName;
	private Context mContext;

	public MainPagerAdapter ( Context context, List<View> views ) {
		this.mViews = views;
		mContext = context;
		mCount = views.size();
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

		int index = position*6;
		ImageButton gun = (ImageButton)view.findViewById(R.id.gun_00);
		int resId = GunInfo.gunsThumbnails[index++];
		//gun.setImageResource(resId);
		MemCache.loadBitmap(resId, gun, mContext);

		gun = (ImageButton)view.findViewById(R.id.gun_01);
		resId = GunInfo.gunsThumbnails[index++];
		MemCache.loadBitmap(resId, gun, mContext);

		gun = (ImageButton)view.findViewById(R.id.gun_02);
		resId = GunInfo.gunsThumbnails[index++];
		MemCache.loadBitmap(resId, gun, mContext);

		gun = (ImageButton)view.findViewById(R.id.gun_10);
		resId = GunInfo.gunsThumbnails[index++];
		MemCache.loadBitmap(resId, gun, mContext);

		gun = (ImageButton)view.findViewById(R.id.gun_11);
		resId = GunInfo.gunsThumbnails[index++];
		MemCache.loadBitmap(resId, gun, mContext);

		gun = (ImageButton)view.findViewById(R.id.gun_12);
		resId = GunInfo.gunsThumbnails[index++];
		MemCache.loadBitmap(resId, gun, mContext);

		( ( ViewPager ) container).addView( view );
		//((ImageButton)view.findViewById(R.id.gun_category)).setImageResource(mGuns[position]);
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
