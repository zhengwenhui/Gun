package com.yesterdaylike.gun;

import java.util.ArrayList;
import java.util.List;

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
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
implements OnPageChangeListener, OnTouchListener{

	private ViewPager mViewPager;
	private MainPagerAdapter mAdapter;
	private List<View> mViewsList;
	private int mCurrentIndex = 0;
	private Button mPageNumberButton;
	private Animation mAnimation;

	private Panel mHelpPanel;
	private TextView mHelpTextView;
	private String[] mHelpDoc;
	//private Panel feedBackPanel;

	//private EditText messageEditText;
	//private EditText subjectEditText;

	private Vibrator vibrator;  
	public static String TYPE_NO = "Type_No";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAnimation = AnimationUtils.loadAnimation(this, R.anim.horizontal_scale);

		mPageNumberButton = (Button) findViewById(R.id.page_number_button);
		mPageNumberButton.setText( String.valueOf( mCurrentIndex+1 ) );

		mHelpPanel = (Panel)findViewById(R.id.help_panel);
		mHelpTextView = (TextView) mHelpPanel.findViewById(R.id.panelContent);
		
		mHelpDoc = getResources().getStringArray(R.array.help_doc);
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
	}

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

		Intent intent = new Intent(this, PlayActivity.class);
		intent.putExtra(TYPE_NO, mCurrentIndex);
		startActivity(intent);
		overridePendingTransition(0, android.R.anim.fade_out);
	}

	public void onButtonClick( View view ){
		switch (view.getId()){
		case R.id.page_number_button:
			mViewPager.setCurrentItem( (mCurrentIndex + 1) % mAdapter.getCount() );
			break;

		case R.id.help_button:
			//帮助
			/*if(feedBackPanel.isOpen()){
				feedBackPanel.onClick();
			}*/
			mHelpPanel.onClick();
			break;

		case R.id.start_button:
			//开始
			onClick(null);
			//反馈
			/*if(helpPanel.isOpen()){
				helpPanel.onClick();
			}
			feedBackPanel.onClick();*/
			break;

		/*case R.id.feedback_send:
			//发送反馈
			String message = messageEditText.getText().toString();
			if( null != message && message.length()>0 ){
				if(BuildConfig.DEBUG){
					Log.i("FeedBack", message);
				}
				String subject = subjectEditText.getText().toString();
				Intent email = new Intent(android.content.Intent.ACTION_SEND);
				email.setType("plain/text");
				email.putExtra(android.content.Intent.EXTRA_EMAIL, 
						new String[]{"zhengwenhui@outlook.com"});   			 //设置邮件默认地址
				email.putExtra(android.content.Intent.EXTRA_SUBJECT, subject); 	 //设置邮件默认标题
				email.putExtra(android.content.Intent.EXTRA_TEXT, message); 	 //设置要默认发送的内容
				startActivity(Intent.createChooser(email, 
						getString(R.string.select_mail_software)));  			 //调用系统的邮件系统
			}

			messageEditText.setText("");
			subjectEditText.setText("");

			if(feedBackPanel.isOpen()){
				feedBackPanel.onClick();
			}
			break;*/
		default:
			/*if(feedBackPanel.isOpen()){
				feedBackPanel.onClick();
			}*/

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
