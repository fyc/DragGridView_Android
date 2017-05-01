package com.lyk.dragGridView;

import android.view.View;

public interface DelViewI {
	public View getDelView();
	public boolean isTouchInDelView(int moveX, int moveY);
	public boolean isShowDelView();
	public void showDelView();
	public void hideDelView();
}
