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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
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
	//private Panel feedBackPanel;

	//private EditText messageEditText;
	//private EditText subjectEditText;
	private Animation animationLeft;
	private Animation animationRight;
	private ImageView mLightView;

	private Vibrator vibrator;  
	public static String TYPE_NO = "Type_No";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mPageNumberButton = (ImageButton) findViewById(R.id.page_number_button);
		mPageNumberButton.setImageResource(GunInfo.number[(mCurrentIndex+1)%10]);

		BoardAnim();

		mHelpPanel = (Panel)findViewById(R.id.help_panel);
		mHelpTextView = (TextView) mHelpPanel.findViewById(R.id.panelContent);

		mHelpDoc = getResources().getStringArray(R.array.gun_kind_name);
		//feedBackPanel = (Panel)findViewById(R.id.feedback_panel);

		//messageEditText = (EditText)findViewById(R.id.message);
		//subjectEditText = (EditText)findViewById(R.id.subject);

		mViewsList = new ArrayList<View>();

		LayoutInflater layoutInflater = getLayoutInflater();

		View view1 = layoutInflater.inflate(R.layout.main_item, null);
		View view2 = layoutInflater.inflate(R.layout.main_item, null);
		View view3 = layoutInflater.inflate(R.layout.main_item, null);
		View view4 = layoutInflater.inflate(R.layout.main_item, null);
		View view5 = layoutInflater.inflate(R.layout.main_item, null);
		View view6 = layoutInflater.inflate(R.layout.main_item, null);
		View view7 = layoutInflater.inflate(R.layout.main_item, null);
		View view8 = layoutInflater.inflate(R.layout.main_item, null);
		View view9 = layoutInflater.inflate(R.layout.main_item, null);
		View view10 = layoutInflater.inflate(R.layout.main_item, null);

		mViewsList.add( view1 );
		mViewsList.add( view2 );
		mViewsList.add( view3 );
		mViewsList.add( view4 );
		mViewsList.add( view5 );
		mViewsList.add( view6 );
		mViewsList.add( view7 );
		mViewsList.add( view8 );
		mViewsList.add( view9 );
		mViewsList.add( view10 );

		mViewPager = (ViewPager)findViewById(R.id.sudoku_type_viewpager);
		mAdapter = new MainPagerAdapter(this, mViewsList);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(this);
		mViewPager.setOnTouchListener(this);
		onPageSelected( mCurrentIndex );

		AdManager.getInstance(this).init("e7e50267ae23cb07","0ab58313c2d0be60", false); 
		//SmartBannerManager.init(this);
		//SmartBannerManager.show(this);

		mLightView = (ImageView) findViewById(R.id.light_layout);
		LightAnim();
		mLightView.startAnimation(animationLeft);
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
				mPageNumberButton.setImageResource(GunInfo.number[(mCurrentIndex+1)%10]);
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
	}

	public void onClick( View view ){

		/*if(feedBackPanel.isOpen()){
			feedBackPanel.onClick();
			return;
		}*/

		if(mHelpPanel.isOpen()){
			mHelpPanel.onClick();
			return;
		}
		Log.v("zhengwenhui", "onClick PlayActivity");
		Intent intent = new Intent(this, PlayActivity.class);
		intent.putExtra(TYPE_NO, mCurrentIndex);
		startActivity(intent);
		overridePendingTransition(0, android.R.anim.fade_out);
	}

	public void onButtonClick( View view ){
		switch (view.getId()){
		case R.id.page_number_button:
			mViewPager.setCurrentItem((mCurrentIndex + 1) % mAdapter.getCount(), true);
			Log.v("zhengwenhui", "page_number_button");
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
