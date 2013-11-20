package com.yesterdaylike.gun;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.SoundPool;
import android.preference.PreferenceManager;

public class SoundBox{
	static final String OPEN_SOUND = "OPEN_SOUND";
	private SoundPool mSoundPool;
	public boolean mOpenSound = true;
	//private int [] SoundId;
	private Map<Integer,Integer> loadSoundMap;

	public int mDifficulty;
	private Context mContext;
	private float mVolume;

	@SuppressLint("UseSparseArrays")
	public SoundBox(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
		getOpenSound();
		//指定声音池的最大音频流数目为10，声音品质为5
		mSoundPool = new SoundPool(10 , AudioManager.STREAM_SYSTEM, 5);  
		//载入音频流，返回在池中的id
		loadSoundMap = new HashMap<Integer, Integer>();

		AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		//音乐音量
		int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
		int current = mAudioManager.getStreamVolume( AudioManager.STREAM_MUSIC );
		mVolume = current/Float.valueOf(max);

		loadInitSound();
	}

	public boolean getOpenSound(){
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mContext);
		mOpenSound = settings.getBoolean(OPEN_SOUND, true);
		return mOpenSound;
	}

	public void setOpenSound(boolean isChecked ){
		Editor editor  = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
		editor.putBoolean(OPEN_SOUND, isChecked);
		editor.commit();
		mOpenSound = isChecked;
	}

	public void playSoundPool(int resId){
		if(mOpenSound){
			int value;
			if (!loadSoundMap.containsKey(resId)){
				value = mSoundPool.load(mContext, resId, 0);
				loadSoundMap.put(resId, value);
			}
			else{
				value = loadSoundMap.get(resId);
			}
			mSoundPool.play(value, mVolume, mVolume, 0, 0, 1);
		}
	}

	private void loadInitSound(){
		int [] initSoundResId = {
				R.raw.deagle_fire,
				R.raw.r700_fire,
				R.raw.scout_fire,
				R.raw.sg550_fire,
				R.raw.aug_fire,
				R.raw.fs2000_fire,
				R.raw.mk23_fire,
				R.raw.ak47_fire,
				R.raw.barrettm82a1c_fire,
				R.raw.beretta96_fire,
				R.raw.sg552_fire,
				R.raw.browning_takedown_fire,
				R.raw.m4a1_fire,
				R.raw.w1200_fire,
				R.raw.aa12_fire,
				R.raw.awp_fire,
				R.raw.mp5_navy_fire,
		};
		int value;
		for (int resId : initSoundResId) {
			if (!loadSoundMap.containsKey(resId)){
				value = mSoundPool.load(mContext, resId, 0);
				loadSoundMap.put(resId, value);
			}
		}
	}


	public void loadSoundPool(int resId){
		int value;
		if (!loadSoundMap.containsKey(resId)){
			value = mSoundPool.load(mContext, resId, 0);
			loadSoundMap.put(resId, value);
		}
	}

	/*public static String[] soundNames = {
		"aa12_fire",
		"ak47_fire",
		"ak74_fire",
		"ar15a3_fire",
		"at4_fire",
		"at4_reload",
		"aug_fire",
		"awp_fire",
		"ballistic_knife",
		"bang",
		"barrettm82a1c_fire",
		"benelli_m3_super90_fire",
		"beretta96_fire",
		"block",
		"bomb_beep",
		"bomb_explode",
		"bomb_pin_drop",
		"browning_takedown_fire",
		"cheytacm200_fire",
		"click",
		"colt1911_fire",
		"deagle_fire",
		"dragnov_fire",
		"famasf1_fire",
		"fn_five_seven_fire",
		"fn_p90",
		"fs2000_fire",
		"g36c_fire",
		"g3sg1_fire",
		"gewehr43_fire",
		"glock18_fire",
		"ground",
		"hk416_fire",
		"ingram_mac10_fire",
		"jericho941_fire",
		"k2_fire",
		"knife0",
		"knife1",
		"knife2",
		"l85a1_fire",
		"load_bullet",
		"m134d_fire",
		"m14_fire",
		"m16_fire",
		"m1919_fire",
		"m21_fire",
		"m249_fire",
		"m249_fire_bak",
		"m4a1_fire",
		"m60_fire",
		"mauserc96_fire",
		"mg42_fire",
		"microgalil_fire",
		"mk23_fire",
		"mp40_fire",
		"mp443_fire",
		"mp5_navy_fire",
		"mp7a1_fire",
		"mp9_fire",
		"p99_fire",
		"ppsh41_fire",
		"r700_fire",
		"raging_bull_fire",
		"rpg29_fire",
		"rpg29_reload",
		"rpg7_fire",
		"rpg7_reload",
		"ruger_sr9_fire",
		"scarh_fire",
		"scout_fire",
		"sg550_fire",
		"sg552_fire",
		"sig_p228_fire",
		"spas12_fire",
		"spin",
		"steyr_tmp_fire",
		"stg44_fire",
		"tar21_fire",
		"thompson_fire",
		"ump45_fire",
		"usp_fire",
		"w1200_fire",
		"xm8_fire",
	};

	public static int[] soundRes = {
			R.raw.aa12_fire,
			R.raw.ak47_fire,
			R.raw.ak74_fire,
			R.raw.ar15a3_fire,
			R.raw.at4_fire,
			R.raw.at4_reload,
			R.raw.aug_fire,
			R.raw.awp_fire,
			R.raw.ballistic_knife,
			R.raw.bang,
			R.raw.barrettm82a1c_fire,
			R.raw.benelli_m3_super90_fire,
			R.raw.beretta96_fire,
			R.raw.block,
			R.raw.bomb_beep,
			R.raw.bomb_explode,
			R.raw.bomb_pin_drop,
			R.raw.browning_takedown_fire,
			R.raw.cheytacm200_fire,
			R.raw.click,
			R.raw.colt1911_fire,
			R.raw.deagle_fire,
			R.raw.dragnov_fire,
			R.raw.famasf1_fire,
			R.raw.fn_five_seven_fire,
			R.raw.fn_p90,
			R.raw.fs2000_fire,
			R.raw.g36c_fire,
			R.raw.g3sg1_fire,
			R.raw.gewehr43_fire,
			R.raw.glock18_fire,
			R.raw.ground,
			R.raw.hk416_fire,
			R.raw.ingram_mac10_fire,
			R.raw.jericho941_fire,
			R.raw.k2_fire,
			R.raw.knife0,
			R.raw.knife1,
			R.raw.knife2,
			R.raw.l85a1_fire,
			R.raw.load_bullet,
			R.raw.m134d_fire,
			R.raw.m14_fire,
			R.raw.m16_fire,
			R.raw.m1919_fire,
			R.raw.m21_fire,
			R.raw.m249_fire,
			R.raw.m249_fire_bak,
			R.raw.m4a1_fire,
			R.raw.m60_fire,
			R.raw.mauserc96_fire,
			R.raw.mg42_fire,
			R.raw.microgalil_fire,
			R.raw.mk23_fire,
			R.raw.mp40_fire,
			R.raw.mp443_fire,
			R.raw.mp5_navy_fire,
			R.raw.mp7a1_fire,
			R.raw.mp9_fire,
			R.raw.p99_fire,
			R.raw.ppsh41_fire,
			R.raw.r700_fire,
			R.raw.raging_bull_fire,
			R.raw.rpg29_fire,
			R.raw.rpg29_reload,
			R.raw.rpg7_fire,
			R.raw.rpg7_reload,
			R.raw.ruger_sr9_fire,
			R.raw.scarh_fire,
			R.raw.scout_fire,
			R.raw.sg550_fire,
			R.raw.sg552_fire,
			R.raw.sig_p228_fire,
			R.raw.spas12_fire,
			R.raw.spin,
			R.raw.steyr_tmp_fire,
			R.raw.stg44_fire,
			R.raw.tar21_fire,
			R.raw.thompson_fire,
			R.raw.ump45_fire,
			R.raw.usp_fire,
			R.raw.w1200_fire,
			R.raw.xm8_fire,
	};*/
}

