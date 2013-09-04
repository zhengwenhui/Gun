package com.yesterdaylike.gun;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class GunViewPager extends ViewPager{

	private boolean palying = false;

	public GunViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public GunViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public void setPlaying( boolean palying ){
		this.palying = palying;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		if( palying && action == MotionEvent.ACTION_MOVE ){
			return false;
		}
		return super.onInterceptTouchEvent(event);
	}
}
