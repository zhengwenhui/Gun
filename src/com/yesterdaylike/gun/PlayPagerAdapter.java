package com.yesterdaylike.gun;

import java.util.List;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.yesterdaylike.gun.PlayActivity.Item;

public class PlayPagerAdapter extends PagerAdapter {

	private int mCount;
	//界面列表
	private List<View> mViews;
	private OnInstantiateItemListener mOnInstantiateItemListener;
	//private SoundBox mSoundBox;
	private int mTypeNo;
	private Context mContext;

	public static GunInfo []mGunsInfo = {
			//0
			new GunInfo( R.drawable.handgun0, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			new GunInfo( R.drawable.handgun1, R.drawable.background, R.drawable.flash, R.raw.r700_fire),
			new GunInfo( R.drawable.handgun2, R.drawable.background, R.drawable.flash, R.raw.scout_fire),
			new GunInfo( R.drawable.handgun3, R.drawable.background, R.drawable.flash, R.raw.sg550_fire),
			new GunInfo( R.drawable.handgun4, R.drawable.background, R.drawable.flash, R.raw.aug_fire),
			new GunInfo( R.drawable.handgun5, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			//1
			new GunInfo( R.drawable.handgun6, R.drawable.background, R.drawable.flash, R.raw.fs2000_fire),
			new GunInfo( R.drawable.rifles0, R.drawable.background, R.drawable.flash, R.raw.r700_fire),
			new GunInfo( R.drawable.rifles1, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.rifles2, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.rifles3, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.rifles4, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			//2
			new GunInfo( R.drawable.rifles5, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.rifles6, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.rifles7, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.rifles8, R.drawable.background, R.drawable.flash, R.raw.barrettm82a1c_fire),
			new GunInfo( R.drawable.rifles9, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.rifles10, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			//3
			new GunInfo( R.drawable.tactical_rifle_0, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.tactical_rifle_1, R.drawable.background, R.drawable.flash, R.raw.barrettm82a1c_fire),
			new GunInfo( R.drawable.tactical_rifle_2, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.tactical_rifle_3, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			new GunInfo( R.drawable.tactical_rifle_4, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.tactical_rifle_5, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			//4
			new GunInfo( R.drawable.tactical_rifle_6, R.drawable.background, R.drawable.flash, R.raw.fs2000_fire),
			new GunInfo( R.drawable.tactical_rifle_7, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.tactical_rifle_8, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			new GunInfo( R.drawable.tactical_rifle_9, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.tactical_rifle_10, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			new GunInfo( R.drawable.shotgun_0, R.drawable.background, R.drawable.flash, R.raw.beretta96_fire),
			//5
			new GunInfo( R.drawable.shotgun_1, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),
			new GunInfo( R.drawable.shotgun_2, R.drawable.background, R.drawable.flash, R.raw.beretta96_fire),
			new GunInfo( R.drawable.shotgun_3, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			new GunInfo( R.drawable.shotgun_4, R.drawable.background, R.drawable.flash, R.raw.beretta96_fire),
			new GunInfo( R.drawable.shotgun_5, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),
			new GunInfo( R.drawable.shotgun_6, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			//5
			new GunInfo( R.drawable.shotgun_7, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),
			new GunInfo( R.drawable.tactical_shotgun_0, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			new GunInfo( R.drawable.tactical_shotgun_1, R.drawable.background, R.drawable.flash, R.raw.aug_fire),
			new GunInfo( R.drawable.tactical_shotgun_2, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			new GunInfo( R.drawable.tactical_shotgun_3, R.drawable.background, R.drawable.flash, R.raw.aug_fire),
			new GunInfo( R.drawable.tactical_shotgun_4, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			//6
			new GunInfo( R.drawable.tactical_shotgun_5, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			new GunInfo( R.drawable.tactical_shotgun_6, R.drawable.background, R.drawable.flash, R.raw.awp_fire),
			new GunInfo( R.drawable.tactical_shotgun_7, R.drawable.background, R.drawable.flash, R.raw.aug_fire),
			new GunInfo( R.drawable.tactical_shotgun_8, R.drawable.background, R.drawable.flash, R.raw.awp_fire),
			new GunInfo( R.drawable.combo_gun_0, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			new GunInfo( R.drawable.combo_gun_1, R.drawable.background, R.drawable.flash, R.raw.deagle_fire),
			//7
			new GunInfo( R.drawable.combo_gun_2, R.drawable.background, R.drawable.flash, R.raw.browning_takedown_fire),
			new GunInfo( R.drawable.combo_gun_3, R.drawable.background, R.drawable.flash, R.raw.browning_takedown_fire),
			new GunInfo( R.drawable.combo_gun_4, R.drawable.background, R.drawable.flash, R.raw.browning_takedown_fire),
			new GunInfo( R.drawable.combo_gun_5, R.drawable.background, R.drawable.flash, R.raw.browning_takedown_fire),
			new GunInfo( R.drawable.combo_gun_6, R.drawable.background, R.drawable.flash, R.raw.browning_takedown_fire),
			new GunInfo( R.drawable.black_powder_rifle_0, R.drawable.background, R.drawable.flash, R.raw.fs2000_fire),
			//8
			new GunInfo( R.drawable.black_powder_rifle_1, R.drawable.background, R.drawable.flash, R.raw.fs2000_fire),
			new GunInfo( R.drawable.black_powder_rifle_2, R.drawable.background, R.drawable.flash, R.raw.m4a1_fire),
			new GunInfo( R.drawable.black_powder_rifle_3, R.drawable.background, R.drawable.flash, R.raw.fs2000_fire),
			new GunInfo( R.drawable.black_powder_rifle_4, R.drawable.background, R.drawable.flash, R.raw.fs2000_fire),
			new GunInfo( R.drawable.black_powder_rifle_5, R.drawable.background, R.drawable.flash, R.raw.m4a1_fire),
			new GunInfo( R.drawable.revolver_0, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			//9
			new GunInfo( R.drawable.revolver_1, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.revolver_2, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.revolver_3, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.revolver_4, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.revolver_5, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),
			new GunInfo( R.drawable.revolver_6, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			//11
			new GunInfo( R.drawable.revolver_7, R.drawable.background, R.drawable.flash, R.raw.ak47_fire),
			new GunInfo( R.drawable.revolver_8, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),
			new GunInfo( R.drawable.specialty_0, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),
			new GunInfo( R.drawable.specialty_1, R.drawable.background, R.drawable.flash, R.raw.w1200_fire),
			new GunInfo( R.drawable.specialty_2, R.drawable.background, R.drawable.flash, R.raw.aa12_fire),
			new GunInfo( R.drawable.specialty_3, R.drawable.background, R.drawable.flash, R.raw.aug_fire),
			//12
			new GunInfo( R.drawable.specialty_4, R.drawable.background, R.drawable.flash, R.raw.awp_fire),
			new GunInfo( R.drawable.specialty_5, R.drawable.background, R.drawable.flash, R.raw.mk23_fire),
			new GunInfo( R.drawable.specialty_6, R.drawable.background, R.drawable.flash, R.raw.mp5_navy_fire),
			new GunInfo( R.drawable.specialty_7, R.drawable.background, R.drawable.flash, R.raw.sg552_fire),

	};

	public PlayPagerAdapter ( SoundBox soundBox, List<View> views, int typeNo, Context context) {
		mContext = context;
		this.mViews = views;
		//mSoundBox = soundBox;
		mTypeNo = typeNo;
		//guninfo = mGunsInfo[mTypeNo];
		mCount = mGunsInfo.length;
	}

	@Override
	public void destroyItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		View view = mViews.get( position % mViews.size() );
		( ( ViewPager ) container).removeView( view );
	}

	@Override
	public void finishUpdate(View container) {
		// TODO Auto-generated method stub
		//super.finishUpdate(container);
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub
		int index = position % mViews.size();
		//index %= mViews.size();
		View view = mViews.get(index);
		Item item = (Item) view.getTag();
		//GunInfo gf = guninfo[position%guninfo.length];
		GunInfo gf = mGunsInfo[position%mGunsInfo.length];

		//item.gun.setImageResource(gf.gun);
		MemCache.loadBitmap(gf.gun, item.gun, mContext);
		//item.fire.setBackgroundResource(gf.fire);
		//item.background.setBackgroundResource(gf.bg);
		MemCache.loadBitmap(gf.fire, item.fire, mContext);
		MemCache.loadBitmap(gf.bg, item.background, mContext);
		item.sound = gf.sound;

		( ( ViewPager ) container).addView( view );
		//((ImageButton)view.findViewById(R.id.gun)).setImageResource(gf.gun);

		if( null != mOnInstantiateItemListener ){
			mOnInstantiateItemListener.OnInstantiateItem(index,position);
		}

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

	public void setOnInstantiateItemListener(OnInstantiateItemListener l) {
		mOnInstantiateItemListener = l;
	}

	public interface OnInstantiateItemListener {
		boolean OnInstantiateItem(int index, int position);
	}
}
