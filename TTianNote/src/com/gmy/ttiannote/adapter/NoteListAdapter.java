package com.gmy.ttiannote.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.dao.NoteContentDAO;
import com.gmy.ttiannote.widget.MidiconImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class NoteListAdapter extends BaseAdapter {
	private List<NoteContentDAO> mList;
	private Context mContext;

	public NoteListAdapter(List<NoteContentDAO> list,Context context) {
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
			viewHolder.imageViewOne=(ImageView) convertView.findViewById(R.id.time_line_iv_one);
			viewHolder.imageViewTwo=(ImageView) convertView.findViewById(R.id.time_line_iv_two);
			viewHolder.imageViewThree=(ImageView) convertView.findViewById(R.id.time_line_iv_three);
			viewHolder.imageViewFour=(ImageView) convertView.findViewById(R.id.time_line_iv_four);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder) convertView.getTag();
		}
			viewHolder.textViewDate.setText(mList.get(position).getTime());
			viewHolder.textViewContent.setText(mList.get(position).getContent());
			if(!mList.get(position).getImagePathOne().equals("1")){
				viewHolder.imageViewOne.setVisibility(View.VISIBLE);
				ImageLoader.getInstance().displayImage("file://"+mList.get(position).getImagePathOne(), viewHolder.imageViewOne);
//				viewHolder.imageViewOne.setImageBitmap(ParamUtils.getSecondBitmap(FuntionTools.dip2px(mContext, 70), 
//						 FuntionTools.dip2px(mContext, 70), mList.get(position).getImagePathOne()));
			}else {
				viewHolder.imageViewOne.setVisibility(View.GONE);
				viewHolder.imageViewTwo.setVisibility(View.GONE);
				viewHolder.imageViewThree.setVisibility(View.GONE);
				viewHolder.imageViewFour.setVisibility(View.GONE);
			}
			
			if (!mList.get(position).getImagePathTwo().equals("1")) {
				viewHolder.imageViewTwo.setVisibility(View.VISIBLE);
				ImageLoader.getInstance().displayImage("file://"+mList.get(position).getImagePathTwo(), viewHolder.imageViewTwo);
//				viewHolder.imageViewTwo.setImageBitmap(ParamUtils.getSecondBitmap(FuntionTools.dip2px(mContext, 70), 
//						FuntionTools.dip2px(mContext, 70), mList.get(position).getImagePathTwo()));
			}
			
			if (!mList.get(position).getImagePathThree().equals("1")) {
				viewHolder.imageViewThree.setVisibility(View.VISIBLE);
				ImageLoader.getInstance().displayImage("file://"+mList.get(position).getImagePathThree(), viewHolder.imageViewThree);
//				viewHolder.imageViewThree.setImageBitmap(ParamUtils.getSecondBitmap(FuntionTools.dip2px(mContext, 70), 
//						FuntionTools.dip2px(mContext, 70), mList.get(position).getImagePathThree()));
			}
		return convertView;
	}
	
	class ViewHolder{
		TextView textViewDate;
		com.gmy.ttiannote.widget.MidiconImageView imageView;
		ImageView imageViewOne;
		ImageView imageViewTwo;
		ImageView imageViewThree;
		ImageView imageViewFour;
		TextView textViewContent;
		
	}

}
