package com.lyk.dragGridView;

import com.example.draggridview.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DragGridViewDel extends RelativeLayout implements DelViewI {

	DragGridView mDragGridView;
	TextView mTvDel;

	public DragGridViewDel(Context context) {
		this(context, null);
		// TODO Auto-generated constructor stub
	}

	public DragGridViewDel(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		// TODO Auto-generated constructor stub
	}

	public DragGridViewDel(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initView(context);
		// 拿到自定义的属性
		// TypedArray ta = context.obtainStyledAttributes(attrs,
		// R.styleable.myView_attrs);
		// 获取自定义属性的值
		// String text = ta.getString(R.styleable.myView_attrs_text);
		// Drawable drawable = ta.getDrawable(R.styleable.myView_attrs_src);
		// 把值设置到相应组件上
		// icon_Iv.setImageDrawable(drawable);
		// tv.setText(text);
		mDragGridView.setDragGridViewDel(this);
	}

	private void initView(Context context) {
		// 把自定义的布局加载进来
		View.inflate(context, R.layout.drag_gridview_del_layout, this);
		// 找到布局中的组件
		mDragGridView = (DragGridView) this.findViewById(R.id.dragGridView);
		mTvDel = (TextView) this.findViewById(R.id.tv_Del);

	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mDragGridView.setOnItemClickListener(listener);
	}

	public void setAdapter(ListAdapter adapter) {
		mDragGridView.setAdapter(adapter);
	}

	public void setNeedShake(boolean mNeedShake) {
		mDragGridView.setNeedShake(mNeedShake);
	}

	/**
	 * DownX
	 */
	private int mDownX;

	/**
	 * DownY
	 */
	private int mDownY;
	/**
	 * moveX
	 */
	private int moveX;

	/**
	 * moveY
	 */
	private int moveY;

	@Override
	public View getDelView() {
		// TODO Auto-generated method stub
		return mTvDel;
	}

	@Override
	public boolean isTouchInDelView(int x, int y) {
		// TODO Auto-generated method stub
//		Rect rect = new Rect();
//		mTvDel.getGlobalVisibleRect(rect);
//		location[0] = rect.left;
//		location[1] = rect.top;
		
		if (mTvDel == null) {
			return false;
		}
		int leftOffset = mTvDel.getLeft();
		int topOffset = mTvDel.getTop();
		if (x < leftOffset || x > leftOffset + mTvDel.getWidth()) {
			return false;
		}

		if (y < topOffset || y > topOffset + mTvDel.getHeight()) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isShowDelView() {
		// TODO Auto-generated method stub
		return mTvDel != null && mTvDel.isShown();
	}

	@Override
	public void showDelView() {
		// TODO Auto-generated method stub
		mTvDel.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideDelView() {
		// TODO Auto-generated method stub
		mTvDel.setVisibility(View.GONE);
	}

	// @Override
	// public boolean dispatchTouchEvent(MotionEvent ev) {
	// switch (ev.getAction()) {
	// case MotionEvent.ACTION_DOWN:
	// // mDragGridView.dispatchTouchEvent_ACTION_DOWN(ev);
	// Log.d("DragGridViewDel", "dispatchTouchEvent:ACTION_DOWN");
	// break;
	// case MotionEvent.ACTION_MOVE:
	// // mDragGridView.dispatchTouchEvent_ACTION_MOVE(ev);
	// Log.d("DragGridViewDel", "dispatchTouchEvent:ACTION_MOVE");
	// break;
	// case MotionEvent.ACTION_UP:
	// // mDragGridView.dispatchTouchEvent_ACTION_UP(ev);
	// break;
	// }
	// return super.dispatchTouchEvent(ev);
	// }
	//
	// public boolean onInterceptTouchEvent(MotionEvent ev) {
	// switch (ev.getAction()) {
	// // case MotionEvent.ACTION_DOWN:
	// // Log.d("DragGridViewDel", "onInterceptTouchEvent:ACTION_DOWN");
	// // mDownX = (int) ev.getX();
	// // mDownY = (int) ev.getY();
	// // if(mDownY>900){
	// // // return true;
	// // }
	// // break;
	// case MotionEvent.ACTION_MOVE:
	// int moveX = (int) ev.getX();
	// int moveY = (int) ev.getY();
	// if (moveY > 900) {
	// return true;
	// }
	// Log.d("DragGridViewDel", "onInterceptTouchEvent:ACTION_MOVE--moveX:" +
	// moveX + "moveY:" + moveY);
	// break;
	// // case MotionEvent.ACTION_UP:
	// // Log.d("DragGridViewDel", "onInterceptTouchEvent:ACTION_UP");
	// //
	// // break;
	// }
	// return super.onInterceptTouchEvent(ev);
	// }
	//
	// @Override
	// public boolean onTouchEvent(MotionEvent ev) {
	// switch (ev.getAction()) {
	// case MotionEvent.ACTION_MOVE:
	// int moveX = (int) ev.getX();
	// int moveY = (int) ev.getY();
	// mDragGridView.updateDragImage(moveX, moveY);
	// Log.d("DragGridViewDel", "onTouchEvent:ACTION_MOVE");
	// break;
	// case MotionEvent.ACTION_UP:
	// mDragGridView.onTouchEvent_ACTION_UP(ev);
	// break;
	// }
	// return super.onTouchEvent(ev);
	// }

}
