package com.gmy.ttiannote.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.widget.MidiconImageView;

public class NoteListAdapter extends BaseAdapter {
	private List<String> mList;
	private Context mContext;

	public NoteListAdapter(List<String> list,Context context) {
		// TODO Auto-generated constructor stub
		this.mList=list;
		this.mContext=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder;
		if(convertView==null){
			convertView=LayoutInflater.from(mContext).inflate(R.layout.time_line_item,null);
			viewHolder=new ViewHolder();
			viewHolder.textViewDate=(TextView) convertView.findViewById(R.id.notetime_tv);
			viewHolder.imageView=(MidiconImageView) convertView.findViewById(R.id.state_iv);
			viewHolder.textViewContent=(TextView) convertView.findViewById(R.id.content_tv);
			
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder) convertView.getTag();
		}
		System.out.println("item hight---" + viewHolder.textViewContent.getHeight());
//		viewHolder.lineImageView.setLayoutParams(new LayoutParams(2, viewHolder.textViewContent.getHeight()));
			//赋值过程
		return convertView;
	}
	
	class ViewHolder{
		TextView textViewDate;
		com.gmy.ttiannote.widget.MidiconImageView imageView;
		TextView textViewContent;
		
	}

}
