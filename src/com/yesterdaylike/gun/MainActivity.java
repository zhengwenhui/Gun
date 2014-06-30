package com.yesterdaylike.gun;

import java.util.ArrayList;
import java.util.List;

import net.youmi.android.AdManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity
implements OnPageChangeListener, OnTouchListener{

	private ViewPager mViewPager;
	private MainPagerAdapter mAdapter;
	private List<View> mViewsList;
	private int mCurrentIndex = 0;
	private ImageButton mPageNumberButton;
	private Animation boardUpAnimation;
	private Animation boardDownAnimation;

	private Panel mHelpPanel;
	private TextView mHelpTextView;
	private String[] mHelpDoc;

	private Animation animationLeft;
	private Animation animationRight;
	private ImageView mLightView;

	//private Animation animationRoll;
	private Button mLeftButton;
	private Button mRightButton;

	private Vibrator vibrator;  
	public static String TYPE_NO = "Type_No";
	private Animation gunDownAnimation;

	private String FIRST_RUN="FIRST_RUN";
	private View clingView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPageNumberButton = (ImageButton) findViewById(R.id.page_number_button);
		mPageNumberButton.setImageResource(GunInfo.number[(mCurrentIndex+1)%GunInfo.number.length]);

		BoardAnim();

		/*animationRoll = AnimationUtils.loadAnimation(this, R.anim.roll);
		mStartButton = (Button) findViewById(R.id.start_button);
		mBackButton = (Button) findViewById(R.id.back_button);*/
		mLeftButton = (Button) findViewById(R.id.left_button);
		mRightButton = (Button) findViewById(R.id.right_button);
		/*mStartButton.startAnimation(animationRoll);
		mBackButton.startAnimation(animationRoll);*/

		gunDownAnimation = AnimationUtils.loadAnimation(this, R.anim.gun_down); 
		gunDownAnimation.setFillAfter(true);

		mHelpPanel = (Panel)findViewById(R.id.help_panel);
		mHelpTextView = (TextView) mHelpPanel.findViewById(R.id.panelContent);

		mHelpDoc = getResources().getStringArray(R.array.gun_kind_name);
		//feedBackPanel = (Panel)findViewById(R.id.feedback_panel);
		//messageEditText = (EditText)findViewById(R.id.message);
		//subjectEditText = (EditText)findViewById(R.id.subject);

		mViewsList = new ArrayList<View>();

		LayoutInflater layoutInflater = getLayoutInflater();
		for(int i=0; i<12; i++){
			View view = layoutInflater.inflate(R.layout.gallery_item, null);
			mViewsList.add( view );
		}

/*		View view1 = layoutInflater.inflate(R.layout.gallery_item, null);
		View view2 = layoutInflater.inflate(R.layout.gallery_item1, null);
		//View view3 = layoutInflater.inflate(R.layout.gallery_item2, null);
		View view4 = layoutInflater.inflate(R.layout.gallery_item3, null);
		View view5 = layoutInflater.inflate(R.layout.gallery_item4, null);
		View view6 = layoutInflater.inflate(R.layout.gallery_item5, null);
		View view7 = layoutInflater.inflate(R.layout.gallery_item6, null);
		View view8 = layoutInflater.inflate(R.layout.gallery_item7, null);
		View view9 = layoutInflater.inflate(R.layout.gallery_item8, null);
		View view10 = layoutInflater.inflate(R.layout.gallery_item9, null);
		View view11 = layoutInflater.inflate(R.layout.gallery_item10, null);
		View view12 = layoutInflater.inflate(R.layout.gallery_item11, null);
		View view13 = layoutInflater.inflate(R.layout.gallery_item12, null);

		mViewsList.add( view1 );
		mViewsList.add( view2 );
		//mViewsList.add( view3 );
		mViewsList.add( view4 );
		mViewsList.add( view5 );
		mViewsList.add( view6 );
		mViewsList.add( view7 );
		mViewsList.add( view8 );
		mViewsList.add( view9 );
		mViewsList.add( view10 );
		mViewsList.add( view11 );
		mViewsList.add( view12 );
		mViewsList.add( view13 );*/

		mViewPager = (ViewPager)findViewById(R.id.sudoku_type_viewpager);
		mAdapter = new MainPagerAdapter(this, mViewsList);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
		mViewPager.setOnTouchListener(this);
		onPageSelected( mCurrentIndex );

		AdManager.getInstance(this).init("e7e50267ae23cb07","0ab58313c2d0be60", false); 
		//SmartBannerManager.init(this);
		//SmartBannerManager.show(this);

		//mLightView = (ImageView) findViewById(R.id.light_layout);
		//LightAnim();
		//mLightView.startAnimation(animationLeft);

		/*SharedPreferences settings = getSharedPreferences(FIRST_RUN, 0);  
		if ( settings.getBoolean(FIRST_RUN, true) ) {
			clingView = findViewById(R.id.cling);
			clingView.setVisibility(View.VISIBLE);
			SharedPreferences.Editor editor = settings.edit();  
			editor.putBoolean(FIRST_RUN, false);
			editor.commit();
		}*/
	}

	private void LightAnim(){
		animationLeft = AnimationUtils.loadAnimation(this, R.anim.light_left);
		animationLeft.setFillAfter(true);
		animationRight = AnimationUtils.loadAnimation(this, R.anim.light_right);
		animationRight.setFillAfter(true);
		animationLeft.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				mLightView.startAnimation(animationRight);
			}
		});
		animationRight.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				mLightView.startAnimation(animationLeft);
			}
		});
	}

	private void BoardAnim(){
		boardUpAnimation = AnimationUtils.loadAnimation(this, R.anim.board_up);
		boardUpAnimation.setFillAfter(true);
		boardDownAnimation = AnimationUtils.loadAnimation(this, R.anim.board_down);
		boardDownAnimation.setFillAfter(true);
		boardUpAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				mPageNumberButton.startAnimation(boardDownAnimation);
				mPageNumberButton.setImageResource(GunInfo.number[(mCurrentIndex+1)%GunInfo.number.length]);
			}
		});
	}

	/*private void addLight(){
		RelativeLayout lightView = (RelativeLayout) findViewById(R.id.light_layout);

		CCGLSurfaceView view = new CCGLSurfaceView(this); 
		view.setBackgroundColor(Color.TRANSPARENT);
		lightView.addView(view);

		CCDirector director = CCDirector.sharedDirector();
		director.attachInView(view);
		director.setDisplayFPS(true);
		director.setAnimationInterval(1/30.0);


		CCScene scene = CCScene.node();

		GameLayer gameLayer = new GameLayer(this);
		scene.addChild(gameLayer);
		director.runWithScene(scene);
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
		mPageNumberButton.startAnimation(boardUpAnimation);
		mHelpTextView.setText(mHelpDoc[mCurrentIndex]);

		View view = mViewsList.get(arg0).findViewById(R.id.gun_category);
		view.startAnimation(gunDownAnimation);
	}

	public void onClick( View view ){

		/*if(feedBackPanel.isOpen()){
			feedBackPanel.onClick();
			return;
		}*/
		if( null != clingView ){
			clingView.setVisibility(View.GONE);
			clingView = null;
			return;
		}

		if(mHelpPanel.isOpen()){
			mHelpPanel.onClick();
			return;
		}

		int index = 0;
		switch (view.getId()) {
		case R.id.gun_12:
			index = 5;
			break;
		case R.id.gun_11:
			index = 4;
			break;
		case R.id.gun_10:
			index = 3;
			break;
		case R.id.gun_02:
			index = 2;
			break;
		case R.id.gun_01:
			index = 1;
			break;
		case R.id.gun_00:
			index = 0;
			break;
		default:
			break;
		}

		Intent intent = new Intent(this, PlayActivity.class);
		intent.putExtra(TYPE_NO, mCurrentIndex*6 + index);
		startActivity(intent);
		overridePendingTransition(0, android.R.anim.fade_out);
	}

	public void onButtonClick( View view ){

		if( null != clingView ){
			clingView.setVisibility(View.GONE);
			clingView = null;
			return;
		}

		switch (view.getId()){
		case R.id.page_number_button:
			mViewPager.setCurrentItem((mCurrentIndex + 1) % mAdapter.getCount(), true);
			break;
		case R.id.left_button:
			if( mCurrentIndex >= 1){
				mViewPager.setCurrentItem(mCurrentIndex - 1 , true);
			}
			break;
		case R.id.right_button:
			if( mCurrentIndex < ( mAdapter.getCount() - 1 ) ){
				mViewPager.setCurrentItem(mCurrentIndex + 1 , true);
			}
			break;
		case R.id.start_button:
			//¿ªÊ¼
			onClick(null);
			break;
		case R.id.back_button:
			this.finish();
			break;
		default:
			if(mHelpPanel.isOpen()){
				mHelpPanel.onClick();
			}
			break;
		}
	}

	public void sendMailByApache() {

	}  

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		/*if(feedBackPanel.isOpen()){
			feedBackPanel.onClick();
			return;
		}*/

		if(mHelpPanel.isOpen()){
			mHelpPanel.onClick();
			return;
		}
		super.onBackPressed();
	}

	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		/*if(feedBackPanel.isOpen()){
			feedBackPanel.onClick();
		}*/
		if( null != clingView ){
			clingView.setVisibility(View.GONE);
			clingView = null;
			return false;
		}

		if(mHelpPanel.isOpen()){
			mHelpPanel.onClick();
		}
		return false;
	}

	@Override  
	protected void onStop() {
		if(null!=vibrator){
			vibrator.cancel();
		}
		super.onStop();
	}
}
