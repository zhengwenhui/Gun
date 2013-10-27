package com.yesterdaylike.gun;

import java.util.List;

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
	private GunInfo []guninfo;

	private GunInfo [][]mGunsInfo = {
			{
				new GunInfo( R.drawable.handgun0, R.drawable.bg0, R.drawable.flash, R.raw.deagle_fire),
				new GunInfo( R.drawable.handgun1, R.drawable.bg1, R.drawable.flash, R.raw.r700_fire),
				new GunInfo( R.drawable.handgun2, R.drawable.bg2, R.drawable.flash, R.raw.scout_fire),
				new GunInfo( R.drawable.handgun3, R.drawable.bg3, R.drawable.flash, R.raw.sg550_fire),
				new GunInfo( R.drawable.handgun4, R.drawable.bg4, R.drawable.flash, R.raw.aug_fire),
				new GunInfo( R.drawable.handgun5, R.drawable.bg5, R.drawable.flash, R.raw.deagle_fire),
				new GunInfo( R.drawable.handgun6, R.drawable.bg6, R.drawable.flash, R.raw.fs2000_fire),
			},

			{
				new GunInfo( R.drawable.rifles0, R.drawable.bg7, R.drawable.flash, R.raw.r700_fire),
				new GunInfo( R.drawable.rifles1, R.drawable.bg8, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.rifles2, R.drawable.bg9, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles3, R.drawable.bg10, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles4, R.drawable.bg11, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles5, R.drawable.bg12, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles6, R.drawable.bg13, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles7, R.drawable.bg14, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles8, R.drawable.bg15, R.drawable.flash, R.raw.barrettm82a1c_fire),
				new GunInfo( R.drawable.rifles9, R.drawable.bg16, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.rifles10, R.drawable.bg17, R.drawable.flash, R.raw.ak47_fire),
			},
			{
				new GunInfo( R.drawable.tactical_rifle_0, R.drawable.bg18, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.tactical_rifle_1, R.drawable.bg19, R.drawable.flash, R.raw.barrettm82a1c_fire),
				new GunInfo( R.drawable.tactical_rifle_2, R.drawable.bg20, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.tactical_rifle_3, R.drawable.bg21, R.drawable.flash, R.raw.deagle_fire),
				new GunInfo( R.drawable.tactical_rifle_4, R.drawable.bg22, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.tactical_rifle_5, R.drawable.bg0, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.tactical_rifle_6, R.drawable.bg1, R.drawable.flash, R.raw.fs2000_fire),
				new GunInfo( R.drawable.tactical_rifle_7, R.drawable.bg2, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.tactical_rifle_8, R.drawable.bg3, R.drawable.flash, R.raw.deagle_fire),
				new GunInfo( R.drawable.tactical_rifle_9, R.drawable.bg4, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.tactical_rifle_10, R.drawable.bg5, R.drawable.flash, R.raw.deagle_fire),
			},
			{
				new GunInfo( R.drawable.shotgun_0, R.drawable.bg6, R.drawable.flash, R.raw.beretta96_fire),
				new GunInfo( R.drawable.shotgun_1, R.drawable.bg7, R.drawable.flash, R.raw.sg552_fire),
				new GunInfo( R.drawable.shotgun_2, R.drawable.bg8, R.drawable.flash, R.raw.beretta96_fire),
				new GunInfo( R.drawable.shotgun_3, R.drawable.bg9, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.shotgun_4, R.drawable.bg10, R.drawable.flash, R.raw.beretta96_fire),
				new GunInfo( R.drawable.shotgun_5, R.drawable.bg11, R.drawable.flash, R.raw.sg552_fire),
				new GunInfo( R.drawable.shotgun_6, R.drawable.bg12, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.shotgun_7, R.drawable.bg13, R.drawable.flash, R.raw.sg552_fire),
			},
			{
				new GunInfo( R.drawable.tactical_shotgun_0, R.drawable.bg14, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.tactical_shotgun_1, R.drawable.bg15, R.drawable.flash, R.raw.aug_fire),
				new GunInfo( R.drawable.tactical_shotgun_2, R.drawable.bg16, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.tactical_shotgun_3, R.drawable.bg17, R.drawable.flash, R.raw.aug_fire),
				new GunInfo( R.drawable.tactical_shotgun_4, R.drawable.bg18, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.tactical_shotgun_5, R.drawable.bg19, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.tactical_shotgun_6, R.drawable.bg20, R.drawable.flash, R.raw.awp_fire),
				new GunInfo( R.drawable.tactical_shotgun_7, R.drawable.bg21, R.drawable.flash, R.raw.aug_fire),
				new GunInfo( R.drawable.tactical_shotgun_8, R.drawable.bg22, R.drawable.flash, R.raw.awp_fire),
			},
			{
				new GunInfo( R.drawable.combo_gun_0, R.drawable.bg0, R.drawable.flash, R.raw.deagle_fire),
				new GunInfo( R.drawable.combo_gun_1, R.drawable.bg1, R.drawable.flash, R.raw.deagle_fire),
				new GunInfo( R.drawable.combo_gun_2, R.drawable.bg2, R.drawable.flash, R.raw.browning_takedown_fire),
				new GunInfo( R.drawable.combo_gun_3, R.drawable.bg3, R.drawable.flash, R.raw.browning_takedown_fire),
				new GunInfo( R.drawable.combo_gun_4, R.drawable.bg4, R.drawable.flash, R.raw.browning_takedown_fire),
				new GunInfo( R.drawable.combo_gun_5, R.drawable.bg5, R.drawable.flash, R.raw.browning_takedown_fire),
				new GunInfo( R.drawable.combo_gun_6, R.drawable.bg6, R.drawable.flash, R.raw.browning_takedown_fire),
			},
			{
				new GunInfo( R.drawable.black_powder_rifle_0, R.drawable.bg7, R.drawable.flash, R.raw.fs2000_fire),
				new GunInfo( R.drawable.black_powder_rifle_1, R.drawable.bg8, R.drawable.flash, R.raw.fs2000_fire),
				new GunInfo( R.drawable.black_powder_rifle_2, R.drawable.bg9, R.drawable.flash, R.raw.m4a1_fire),
				new GunInfo( R.drawable.black_powder_rifle_3, R.drawable.bg10, R.drawable.flash, R.raw.fs2000_fire),
				new GunInfo( R.drawable.black_powder_rifle_4, R.drawable.bg11, R.drawable.flash, R.raw.fs2000_fire),
				new GunInfo( R.drawable.black_powder_rifle_5, R.drawable.bg12, R.drawable.flash, R.raw.m4a1_fire),
			},
			{
				new GunInfo( R.drawable.revolver_0, R.drawable.bg13, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_1, R.drawable.bg14, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_2, R.drawable.bg15, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_3, R.drawable.bg16, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_4, R.drawable.bg17, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_5, R.drawable.bg18, R.drawable.flash, R.raw.sg552_fire),
				new GunInfo( R.drawable.revolver_6, R.drawable.bg19, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_7, R.drawable.bg20, R.drawable.flash, R.raw.ak47_fire),
				new GunInfo( R.drawable.revolver_8, R.drawable.bg21, R.drawable.flash, R.raw.sg552_fire),
			},
			{
				new GunInfo( R.drawable.specialty_0, R.drawable.bg22, R.drawable.flash, R.raw.sg552_fire),
				new GunInfo( R.drawable.specialty_1, R.drawable.bg0, R.drawable.flash, R.raw.w1200_fire),
				new GunInfo( R.drawable.specialty_2, R.drawable.bg1, R.drawable.flash, R.raw.aa12_fire),
				new GunInfo( R.drawable.specialty_3, R.drawable.bg2, R.drawable.flash, R.raw.aug_fire),
				new GunInfo( R.drawable.specialty_4, R.drawable.bg3, R.drawable.flash, R.raw.awp_fire),
				new GunInfo( R.drawable.specialty_5, R.drawable.bg4, R.drawable.flash, R.raw.mk23_fire),
				new GunInfo( R.drawable.specialty_6, R.drawable.bg5, R.drawable.flash, R.raw.mp5_navy_fire),
				new GunInfo( R.drawable.specialty_7, R.drawable.bg6, R.drawable.flash, R.raw.sg552_fire),
			}
	};

	public PlayPagerAdapter ( SoundBox soundBox, List<View> views, int typeNo) {
		this.mViews = views;
		//mSoundBox = soundBox;
		mTypeNo = typeNo;
		guninfo = mGunsInfo[mTypeNo];
		mCount = guninfo.length;
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
		index %= mViews.size();
		View view = mViews.get(index);
		Item item = (Item) view.getTag();
		GunInfo gf = guninfo[position%guninfo.length];

		item.gun.setImageResource(gf.gun);
		item.fire.setBackgroundResource(gf.fire);
		item.background.setBackgroundResource(gf.bg);
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
