package com.yesterdaylike.gun;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yesterdaylike.gun.PlayPagerAdapter.OnInstantiateItemListener;

public class PlayActivity extends Activity
implements OnPageChangeListener, OnTouchListener, OnInstantiateItemListener{
	private GunViewPager mViewPager;
	private PlayPagerAdapter mAdapter;
	private int a =1;
	private int soundIndex = 0;
	private List<View> mViewList;

	private SoundBox soundBox;

	private int mTypeNo;
	private int mCurrentIndex = 0;
	private Button mPageNumberButton;
	private Animation mAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);

		mAnimation = AnimationUtils.loadAnimation(this, R.anim.horizontal_scale);

		mPageNumberButton = (Button) findViewById(R.id.page_number_btn);
		mPageNumberButton.setText( String.valueOf( mCurrentIndex+1 ) );

		mTypeNo = getIntent().getIntExtra(MainActivity.TYPE_NO, -1);
		Log.i(MainActivity.TYPE_NO, ""+mTypeNo);

		soundBox = new SoundBox(this);
		mViewList = new ArrayList<View>();

		LayoutInflater layoutInflater = getLayoutInflater();

		for (int i = 0; i < 4; i++) {
			Item item = new Item();
			View view = layoutInflater.inflate(R.layout.play_item, null);
			item.background = (View)view.findViewById(R.id.background);
			item.fire = (View)view.findViewById(R.id.fire);
			item.gun = (ImageButton)view.findViewById(R.id.gun);
			item.gun.setTag(item);
			view.setTag(item);
			mViewList.add( view );
		}

		mViewPager = (GunViewPager)findViewById(R.id.gun_viewpager);
		mAdapter = new PlayPagerAdapter( soundBox,mViewList,mTypeNo);
		mAdapter.setOnInstantiateItemListener(this);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
		mViewPager.setOnTouchListener(this);
		onPageSelected( 0 );
	}

	public class Item{
		View background;
		View fire;
		ImageButton gun;
		int sound;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		//Display display = getWindowManager().getDefaultDisplay();
		//width = display.getWidth(); 
		//height = display.getHeight();
		super.onResume();
	}

	/*@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if(helpPanel.isOpen()){
			helpPanel.onClick();
			return;
		}

		if(mPlaying){
			mPlaying = false;
			//hideSystemUi(mPlaying);
			mViewPager.setPlaying(mPlaying);
			//handler.removeCallbacks(runnable);
			//closingTimeTextView.setText(Calendar.getInstance().getTime().toString());
			return;
		}
		super.onBackPressed();
	}*/

	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
	}

	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
	}

	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		mCurrentIndex = arg0;
		mPageNumberButton.startAnimation(mAnimation);
		mPageNumberButton.setText( String.valueOf( mCurrentIndex+1 ) );
		//sound_name.setText(SoundBox.soundNames[++soundTest]);
		//float rating = mSudokus[arg0].degreeOfDifficulty;
		//ratingBar.setRating( rating );
		//sudokuId.setText( String.valueOf( mSudokus[arg0]._id ) );
		//mSquaresViews = mSquareViewList.get( arg0 % mSquareViewList.size() );
		//mData = mSudokus[arg0].data;

		//timerTextView.setText("");
		//closingTimeTextView.setText("");
	}

	public void onClick( View view ){

		switch (view.getId()) {

		/*case R.id.timer_button:
			//开始计时
			mPlaying = true;
			hideSystemUi(mPlaying);
			mViewPager.setPlaying(mPlaying);
			recLen = 0;
			handler.postDelayed(runnable, 1000);
			break;

		case R.id.help_button:
			helpPanel.onClick();
			break;*/

		case R.id.page_number_btn:
			if( mCurrentIndex == 0 ){
				a = 1;
			}
			else if( (mCurrentIndex+1) == mAdapter.getCount() ){
				a = -1;
			}
			mViewPager.setCurrentItem( mCurrentIndex+a, false);
			//mViewPager.setCurrentItem(item, smoothScroll);
			break;

		case R.id.start_button:
			View viewCur = mViewList.get(mViewPager.getCurrentItem()%mViewList.size());
			final Item item = (Item)viewCur.getTag();
			shoot(item);
			break;

		case R.id.gun:
			//boolean blank = (Boolean) view.getTag(R.id.blank);
			final Item itemGun = (Item)view.getTag();
			shoot(itemGun);
			break;

		default:

			break;
		}
	}
	
	private void shoot(final Item item){
		Animation shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_y);
		Animation fireAnim = AnimationUtils.loadAnimation(this, R.anim.fire);
		Animation gunAnim = AnimationUtils.loadAnimation(this, R.anim.gun);
		fireAnim.setAnimationListener(new AnimationListener() {

			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				item.fire.setVisibility(View.VISIBLE);
			}

			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				item.fire.setVisibility(View.INVISIBLE);
			}
		});

		item.fire.startAnimation(fireAnim);
		item.background.startAnimation(shakeAnim);
		item.gun.startAnimation(gunAnim);
		//soundBox.playSoundPool(item.sound);
		if(soundIndex>=SoundBox.soundRes.length){
			soundIndex=0;
		}
		Toast.makeText(this, ""+soundIndex, Toast.LENGTH_SHORT).show();
		soundBox.playSoundPool(SoundBox.soundRes[soundIndex++]);
	}

	/**
	 * 是否隐藏状态栏和标题栏（即是否全屏）。
	 * @param hide
	 */
	/*private void hideSystemUi(boolean hide) {
		Window window = getWindow();
		if (hide) {
			titleBarLayout.setVisibility(View.GONE);
			//downBarLayout.setVisibility(View.GONE);
			window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		} else {
			window.setFlags(0, WindowManager.LayoutParams.FLAG_FULLSCREEN);
			titleBarLayout.setVisibility(View.VISIBLE);
			//downBarLayout.setVisibility(View.VISIBLE);
		}
	}*/

	/*public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if(helpPanel.isOpen()){
			helpPanel.onClick();
			return true;
		}

		if( mPlaying ){
			//不允许viewpager滑动
			return true;
		}
		return false;
	}*/

	public boolean OnInstantiateItem(int index, int position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}


	/*	private void DrawFlash(Canvas paramCanvas, Rect paramRect)
	{
		Paint localPaint = new Paint();
		Rect localRect = new Rect();
		Bitmap localBitmap = LoadBitmap(R.drawable.fire);

		localRect.top = 200;
		localRect.left = 0;
		localRect.right = 200;
		localRect.bottom = 280;

		paramCanvas.drawBitmap(localBitmap, null, localRect, localPaint);
		localRect.top = 0;
		localRect.left = 0;
		localRect.right = 800;
		localRect.bottom = 480;
		paramCanvas.drawBitmap(LoadBitmap(R.drawable.flash), null, localRect, localPaint);
	}

	public Bitmap LoadBitmap(int paramInt)
	{
		BitmapFactory.Options localOptions = new BitmapFactory.Options();
		localOptions.inSampleSize = 1;
		if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 4)
			localOptions.inScaled = false;
		return BitmapFactory.decodeResource(getResources(), paramInt, localOptions);
	}*/
}
