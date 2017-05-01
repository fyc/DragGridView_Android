package com.lyk.dragGridView;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.example.draggridview.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @blog http://blog.csdn.net/sk719887916
 * 
 * @author liuyongkui
 *
 */
public class DragAdapter extends BaseAdapter implements DragGridListener {

	Context mContext;
//	private HashMap<String, View> mItemViewMap = new HashMap<String, View>();

	private List<HashMap<String, Object>> list;
	private LayoutInflater mInflater;
	private int mHidePosition = -1;

	public DragAdapter(Context context, List<HashMap<String, Object>> list) {
		this.mContext = context;
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 由于复用convertView导致某些item消失了，所以这里不复用item，
	 */
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
			convertView = mInflater.inflate(R.layout.grid_item, null);
			Log.e("DragAdapter", "parent.getChildCount()=" + parent.getChildCount());
			Log.e("DragAdapter", "getView=" + position);

			ViewHolder itemHolder = new ViewHolder();

			itemHolder.mImageView = (ImageView) convertView.findViewById(R.id.item_image);
			itemHolder.mTextView = (TextView) convertView.findViewById(R.id.item_text);
			itemHolder.mDeleteButton = (ImageButton) convertView.findViewById(R.id.grid_item_delte);

			itemHolder.mImageView.setImageResource((Integer) list.get(position).get("item_image"));
			itemHolder.mTextView.setText((CharSequence) list.get(position).get("item_text"));

			if (position == mHidePosition) {
				convertView.setVisibility(View.INVISIBLE);
			}
			
			convertView.setTag(itemHolder);// fangyc 这一步必须

			return convertView;

	}

	@Override
	public void reorderItems(int oldPosition, int newPosition) {
		HashMap<String, Object> temp = list.get(oldPosition);
		if (oldPosition < newPosition) {
			for (int i = oldPosition; i < newPosition; i++) {
				Collections.swap(list, i, i + 1);
			}
		} else if (oldPosition > newPosition) {
			for (int i = oldPosition; i > newPosition; i--) {
				Collections.swap(list, i, i - 1);
			}
		}

		list.set(newPosition, temp);
	}


	@Override
	public void setHideItem(int hidePosition) {
		this.mHidePosition = hidePosition;
		notifyDataSetChanged();
	}

	@Override
	public void removeItem(int deletePosition) {

		Log.e("lykDrag", "deletePosition:" + deletePosition);
		list.remove(deletePosition);
		notifyDataSetChanged();
	}

	private class ViewHolder implements DragViewHolderI {
		ImageView mImageView;
		TextView mTextView;
		ImageButton mDeleteButton;

		@Override
		public ImageButton getDelBtn() {
			// TODO Auto-generated method stub
			return mDeleteButton;
		}

	}

}
