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
	private Guninfo []guninfo;

	private Guninfo [][]mGunsInfo = {
			{
				new Guninfo( R.drawable.handgun0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.handgun1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.handgun2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.handgun3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.handgun4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.handgun5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.handgun6, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
			},

			{
				new Guninfo( R.drawable.rifles0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.rifles1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.rifles2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.rifles3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.rifles4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.rifles5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.rifles6, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.rifles7, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.rifles8, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.rifles9, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.rifles10, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
			},
			{
				new Guninfo( R.drawable.tactical_rifle_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.tactical_rifle_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.tactical_rifle_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.tactical_rifle_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.tactical_rifle_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.tactical_rifle_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.tactical_rifle_6, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.tactical_rifle_7, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.tactical_rifle_8, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.tactical_rifle_9, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.tactical_rifle_10, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
			},
			{
				new Guninfo( R.drawable.shotgun_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.shotgun_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.shotgun_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.shotgun_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.shotgun_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.shotgun_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.shotgun_6, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.shotgun_7, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
			},
			{
				new Guninfo( R.drawable.tactical_shotgun_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.tactical_shotgun_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.tactical_shotgun_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.tactical_shotgun_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.tactical_shotgun_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.tactical_shotgun_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.tactical_shotgun_6, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.tactical_shotgun_7, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
				new Guninfo( R.drawable.tactical_shotgun_8, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
			},
			{
				new Guninfo( R.drawable.combo_gun_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.combo_gun_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.combo_gun_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.combo_gun_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.combo_gun_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.combo_gun_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.combo_gun_6, R.drawable.bg6, R.drawable.flash, R.raw.aug_fire),
			},
			{
				new Guninfo( R.drawable.black_powder_rifle_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.black_powder_rifle_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.black_powder_rifle_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.black_powder_rifle_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.black_powder_rifle_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.black_powder_rifle_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
			},
			{
				new Guninfo( R.drawable.revolver_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.revolver_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.revolver_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.revolver_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.revolver_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.revolver_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.revolver_6, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.revolver_7, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.revolver_8, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
			},
			{
				new Guninfo( R.drawable.specialty_0, R.drawable.bg0, R.drawable.flash, R.raw.aa12_fire),
				new Guninfo( R.drawable.specialty_1, R.drawable.bg1, R.drawable.flash, R.raw.ak47_fire),
				new Guninfo( R.drawable.specialty_2, R.drawable.bg2, R.drawable.flash, R.raw.ak74_fire),
				new Guninfo( R.drawable.specialty_3, R.drawable.bg3, R.drawable.flash, R.raw.ar15a3_fire),
				new Guninfo( R.drawable.specialty_4, R.drawable.bg4, R.drawable.flash, R.raw.at4_fire),
				new Guninfo( R.drawable.specialty_5, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.specialty_6, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
				new Guninfo( R.drawable.specialty_7, R.drawable.bg5, R.drawable.flash, R.raw.at4_reload),
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
		Guninfo gf = guninfo[position%guninfo.length];

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
