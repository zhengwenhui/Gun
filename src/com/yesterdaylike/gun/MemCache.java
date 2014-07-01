package com.yesterdaylike.gun;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageButton;

public class MemCache {
	private static LruCache<String, Bitmap> mMemoryCache;

	public static void init(Context context){
		final int memClass = ((ActivityManager) context.getSystemService(
				Context.ACTIVITY_SERVICE)).getMemoryClass(); 

		// Use 1/8th of the available memory for this memory cache. 
		final int cacheSize = 1024 * 1024 * memClass / 4;

		mMemoryCache = new LruCache<String, Bitmap>(cacheSize) { 
			@Override 
			protected int sizeOf(String key, Bitmap bitmap) { 
				// The cache size will be measured in bytes rather than number of items. 
				return bitmap.getByteCount(); 
			} 
		};
	}

	public static void addBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (getBitmapFromMemCache(key) == null) {
			mMemoryCache.put(key, bitmap); 
		} 
	}

	public static Bitmap getBitmapFromMemCache(String key) {
		return mMemoryCache.get(key);
	}

	public static void loadBitmap(int resId, View view, Context context) { 
		final String imageKey = String.valueOf(resId); 
		final Bitmap bitmap = getBitmapFromMemCache(imageKey);
		if (bitmap != null) {
			view.setBackground(new BitmapDrawable(context.getResources(),bitmap));
		} else { 
			//imageView.setImageResource(resId);
			BitmapWorkerTask task = new BitmapWorkerTask(view, context);
			task.execute(resId);
		} 
	}

	public static void loadBitmap(int resId, ImageButton imageView, Context context) { 
		final String imageKey = String.valueOf(resId); 
		final Bitmap bitmap = getBitmapFromMemCache(imageKey);
		if (bitmap != null) { 
			imageView.setImageBitmap(bitmap);
		} else { 
			//imageView.setImageResource(resId);
			BitmapWorkerTask task = new BitmapWorkerTask(imageView, context);
			task.execute(resId);
		} 
	}

	static class BitmapWorkerTask extends AsyncTask<Integer, Void, Bitmap> {
		ImageButton mImageView;
		View mView;
		Context mContext;

		BitmapWorkerTask(ImageButton imageView, Context context){
			mImageView = imageView;
			mContext = context;
		}

		BitmapWorkerTask(View view, Context context){
			mView = view;
			mContext = context;
		}
		// Decode image in background. 
		protected Bitmap doInBackground(Integer... params) {
			final Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), params[0]);
			//final Bitmap bitmap = decodeSampledBitmapFromResource(getResources(), params[0], 100, 100)); 
			addBitmapToMemoryCache(String.valueOf(params[0]), bitmap);
			return bitmap;
		}
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			if( null != mImageView){
				mImageView.setImageBitmap(result);
			}
			if( null != mView){
				mView.setBackground(new BitmapDrawable(mContext.getResources(),result));
			}
			super.onPostExecute(result);
		}
	}
}
