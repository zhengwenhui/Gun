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


	public static int []mGunsDrawable = {
		//0
		R.drawable.handgun0_small,
		R.drawable.handgun1, 
		R.drawable.handgun2, 
		R.drawable.handgun3, 
		R.drawable.handgun4, 
		R.drawable.handgun5,
		//1
		R.drawable.handgun6,
		R.drawable.rifles0, 
		R.drawable.rifles1, 
		R.drawable.rifles2, 
		R.drawable.rifles3, 
		R.drawable.rifles4, 
		//2
		R.drawable.rifles5, 
		R.drawable.rifles6, 
		R.drawable.rifles7, 
		R.drawable.rifles8, 
		R.drawable.rifles9, 
		R.drawable.rifles10, 
		//3
		R.drawable.tactical_rifle_0, 
		R.drawable.tactical_rifle_1, 
		R.drawable.tactical_rifle_2, 
		R.drawable.tactical_rifle_3, 
		R.drawable.tactical_rifle_4, 
		R.drawable.tactical_rifle_5, 
		//4
		R.drawable.tactical_rifle_6, 
		R.drawable.tactical_rifle_7, 
		R.drawable.tactical_rifle_8, 
		R.drawable.tactical_rifle_9, 
		R.drawable.tactical_rifle_10, 
		R.drawable.shotgun_0, 
		//5
		R.drawable.shotgun_1,
		R.drawable.shotgun_2,
		R.drawable.shotgun_3,
		R.drawable.shotgun_4,
		R.drawable.shotgun_5,
		R.drawable.shotgun_6,
		//5
		R.drawable.shotgun_7,
		R.drawable.tactical_shotgun_0,
		R.drawable.tactical_shotgun_1,
		R.drawable.tactical_shotgun_2,
		R.drawable.tactical_shotgun_3,
		R.drawable.tactical_shotgun_4,
		//6
		R.drawable.tactical_shotgun_5,
		R.drawable.tactical_shotgun_6,
		R.drawable.tactical_shotgun_7, 
		R.drawable.tactical_shotgun_8,
		R.drawable.combo_gun_0,
		R.drawable.combo_gun_1,
		//7
		R.drawable.combo_gun_2,
		R.drawable.combo_gun_3,
		R.drawable.combo_gun_4,
		R.drawable.combo_gun_5,
		R.drawable.combo_gun_6,
		R.drawable.black_powder_rifle_0,
		//8
		R.drawable.black_powder_rifle_1,
		R.drawable.black_powder_rifle_2,
		R.drawable.black_powder_rifle_3,
		R.drawable.black_powder_rifle_4,
		R.drawable.black_powder_rifle_5,
		R.drawable.revolver_0, 
		//9
		R.drawable.revolver_1,
		R.drawable.revolver_2, 
		R.drawable.revolver_3, 
		R.drawable.revolver_4, 
		R.drawable.revolver_5, 
		R.drawable.revolver_6, 
		//11
		R.drawable.revolver_7, 
		R.drawable.revolver_8, 
		R.drawable.specialty_0, 
		R.drawable.specialty_1, 
		R.drawable.specialty_2, 
		R.drawable.specialty_3, 
		//12
		R.drawable.specialty_4, 
		R.drawable.specialty_5, 
		R.drawable.specialty_6, 
		R.drawable.specialty_7, 

	};

	public MainPagerAdapter ( Context context, List<View> views ) {
		this.mViews = views;
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
		int resId = mGunsDrawable[index++];
		gun.setImageResource(resId);

		gun = (ImageButton)view.findViewById(R.id.gun_01);
		resId = mGunsDrawable[index++];
		gun.setImageResource(resId);

		gun = (ImageButton)view.findViewById(R.id.gun_02);
		resId = mGunsDrawable[index++];
		gun.setImageResource(resId);

		gun = (ImageButton)view.findViewById(R.id.gun_10);
		resId = mGunsDrawable[index++];
		gun.setImageResource(resId);

		gun = (ImageButton)view.findViewById(R.id.gun_11);
		resId = mGunsDrawable[index++];
		gun.setImageResource(resId);

		gun = (ImageButton)view.findViewById(R.id.gun_12);
		resId = mGunsDrawable[index++];
		gun.setImageResource(resId);

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
