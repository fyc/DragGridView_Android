//package com.lyk.dragGridView;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.Log;
//import android.view.MotionEvent;
//import android.widget.RelativeLayout;
//
//public class DragRLWrapper extends RelativeLayout {
//
//	public DragRLWrapper(Context context) {
//		this(context, null);
//		// TODO Auto-generated constructor stub
//	}
//
//	public DragRLWrapper(Context context, AttributeSet attrs) {
//		this(context, attrs, 0);
//		// TODO Auto-generated constructor stub
//	}
//
//	public DragRLWrapper(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * DownX
//	 */
//	private int mDownX;
//
//	/**
//	 * DownY
//	 */
//	private int mDownY;
//	/**
//	 * moveX
//	 */
//	private int moveX;
//
//	/**
//	 * moveY
//	 */
//	private int moveY;
//
//	@Override
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//		switch (ev.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			// Log.d("DragGridViewDel", "dispatchTouchEvent:ACTION_DOWN");
//			mDownX = (int) ev.getX();
//			mDownY = (int) ev.getY();
//			// if(mDownY>900){
//			// return super.dispatchTouchEvent(ev);
//			// }
//			break;
//		case MotionEvent.ACTION_MOVE:
//			int moveX = (int) ev.getX();
//			int moveY = (int) ev.getY();
//			Log.d("DragRLWrapper", "dispatchTouchEvent:ACTION_MOVE--moveX:" + moveX + "moveY:" + moveY);
//			break;
//		case MotionEvent.ACTION_UP:
//			// Log.d("DragGridViewDel", "dispatchTouchEvent:ACTION_UP");
//
//			break;
//		}
//		return super.dispatchTouchEvent(ev);
//	}
//
//	// public boolean onInterceptTouchEvent(MotionEvent ev) {
//	// switch (ev.getAction()) {
//	// case MotionEvent.ACTION_DOWN:
//	// Log.d("DragGridViewDel", "onInterceptTouchEvent:ACTION_DOWN");
//	// mDownX = (int) ev.getX();
//	// mDownY = (int) ev.getY();
//	// if(mDownY>900){
//	//// return true;
//	// }
//	// break;
//	// case MotionEvent.ACTION_MOVE:
//	// int moveX = (int) ev.getX();
//	// int moveY = (int) ev.getY();
//	// if(moveY>900){
//	//// return true;
//	// }
//	// Log.d("DragGridViewDel",
//	// "onInterceptTouchEvent:ACTION_MOVE--moveX:"+moveX+"moveY:"+moveY);
//	// break;
//	// case MotionEvent.ACTION_UP:
//	// Log.d("DragGridViewDel", "onInterceptTouchEvent:ACTION_UP");
//	//
//	// break;
//	// }
//	// return super.onInterceptTouchEvent(ev);
//	// }
//
//	@Override
//	public boolean onTouchEvent(MotionEvent ev) {
//		switch (ev.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			// Log.d("DragRLWrapper", "onTouchEvent:ACTION_DOWN");
//			mDownX = (int) ev.getX();
//			mDownY = (int) ev.getY();
//
//			if (mDownY > 900) {
//				Log.d("DragRLWrapper", "onTouchEvent:ACTION_DOWN：删除");
//				// return true;
//			}
//
//			break;
//		case MotionEvent.ACTION_MOVE:
//			moveX = (int) ev.getX();
//			moveY = (int) ev.getY();
//
//			// if (moveY > 900) {
//			Log.d("DragRLWrapper", "onTouchEvent:ACTION_MOVE：删除");
//			// return true;
//			// }
//
//			// Log.d("DragRLWrapper", "onTouchEvent:ACTION_MOVE--moveX:" + moveX
//			// + "moveY:" + moveY);
//			break;
//		case MotionEvent.ACTION_UP:
//			// Log.d("DragRLWrapper", "onTouchEvent:ACTION_UP");
//
//			break;
//		}
//		return super.onTouchEvent(ev);
//	}
//}
