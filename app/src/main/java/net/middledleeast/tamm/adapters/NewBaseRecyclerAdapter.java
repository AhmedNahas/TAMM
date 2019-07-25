package net.middledleeast.tamm.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Created by HaykGalstyan on 1/29/18.
 */


@SuppressLint("UseSparseArrays")
@SuppressWarnings("WeakerAccess")
public abstract class NewBaseRecyclerAdapter<T> extends RecyclerView.Adapter<NewBaseRecyclerAdapter.ViewHolder> {


	private List<T> mDataSet = new ArrayList<>();
	private Context mContext;


	/**
	 * @param <T> passes item to a listener on click
	 */
	public interface OnItemClickListener<T> {
		void onListItemClick(View view, int position, T item);
	}


	protected abstract View createView(Context context, ViewGroup viewGroup, int viewType);


	protected abstract void bindView(T item, ViewHolder viewHolder, int position);


	public NewBaseRecyclerAdapter(Context context) {
		mContext = context;
	}


	protected Context getContext() {
		return mContext;
	}


	public static class ViewHolder extends RecyclerView.ViewHolder {
		private Map<Integer, View> mViewMap;

		ViewHolder(View view) {
			super(view);
			mViewMap = new HashMap<>();
			mViewMap.put(0, view);
		}

		public void initViewList(int[] idList) {
			for (int id : idList) initViewById(id);
		}

		void initViewById(int id) {
			View view = (getView() != null ? getView().findViewById(id) : null);
			if (view != null) mViewMap.put(id, view);
		}

		public View getView() {
			return getView(0);
		}

		public View getView(int id) {
			if (mViewMap.containsKey(id)) return mViewMap.get(id);
			else initViewById(id);
			return mViewMap.get(id);
		}


	}


	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
		return new ViewHolder(createView(mContext, viewGroup, viewType));
	}


	@Override
	public void onBindViewHolder(ViewHolder viewHolder, int position) {
		bindView(getItem(position), viewHolder , position );
	}


	@Override
	public int getItemCount() {
		return mDataSet.size();
	}


	public void setDataSet(List<T> list) {
		mDataSet = list;
		notifyDataSetChanged();
	}


	public List<T> getDataSet() {
		return mDataSet;
	}


	public void addItem(T item) {
		mDataSet.add(item);
		notifyItemInserted(mDataSet.size() - 1);
	}


	public void addItems(List<T> items) {
        int start = 0;
		if(mDataSet.size() != 0)
		start = mDataSet.size() -1 ;
		mDataSet.addAll(items);
		notifyItemRangeInserted(start , mDataSet.size());
	}

	public void updateItem(int index) {
		notifyItemChanged(index);
	}


	public void updateItem(T item) {
		updateItem(mDataSet.indexOf(item));
	}


	public T getItem(int index) {
		return ((mDataSet != null && index < mDataSet.size()) ? mDataSet.get(index) : null);
	}


	public void removeItem(int index) {
		mDataSet.remove(index);
		notifyItemRemoved(index);
	}


	public void removeItem(T item) {
		int indexOfItem = mDataSet.indexOf(item);
		if (indexOfItem != -1) removeItem(indexOfItem);
	}


	public List<T> getList() {
		return mDataSet;
	}
}
