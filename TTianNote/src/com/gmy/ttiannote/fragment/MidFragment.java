package com.gmy.ttiannote.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.adapter.NoteListAdapter;
import com.gmy.ttiannote.dao.NoteContentDAO;
import com.gmy.ttiannote.utils.NoteSqliteManger;
import com.gmy.ttiannote.utils.ParamUtils;
import com.gmy.ttiannote.widget.TimeListView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MidFragment extends Fragment {
	public static List<NoteContentDAO> mList;
	private TimeListView mTimeListView; 
	public static NoteListAdapter mAdapter;
	private Activity mActivity;
	private PopupWindow mPopupWindow;
	private View popView;
	private ImageView iv1,iv2,iv3,iv4;
	private TextView tv1;
	
	public MidFragment() {
		// TODO Auto-generated constructor stub
		
	}
	
	private void initData(){ //初始化时使用方法
		// TODO Auto-generated method stub
		mList=NoteSqliteManger.getInstance().selectSql(getActivity(), null, null, null, null, null, null);
		mAdapter=new NoteListAdapter(mList, mActivity);
	}
	
	public static void notifyData(){
		if(mAdapter!=null){
			mAdapter.notifyDataChanged();
		}
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		mActivity=activity;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.time_line, container,false);
		mTimeListView=(TimeListView) view.findViewById(R.id.timeline_lv);
		popView=LayoutInflater.from(getActivity()).inflate(R.layout.popwin_container, null);
		iv1=(ImageView) popView.findViewById(R.id.popwin_pic_one);
		iv2=(ImageView) popView.findViewById(R.id.popwin_pic_two);
		iv3=(ImageView) popView.findViewById(R.id.popwin_pic_three);
		iv4=(ImageView) popView.findViewById(R.id.popwin_pic_four);
		tv1=(TextView) popView.findViewById(R.id.popwin_tv);
		
		mPopupWindow=new PopupWindow(popView,
				                     ParamUtils.getScreenSize(getActivity())[0]*3/4, 
				                     ParamUtils.getScreenSize(getActivity())[1]/3);
		mPopupWindow.setOnDismissListener(new OnDismissListener() {
			
			@Override
			public void onDismiss() {
				// TODO Auto-generated method stub
				iv1.setVisibility(View.GONE);
				iv2.setVisibility(View.GONE);
				iv3.setVisibility(View.GONE);
				iv4.setVisibility(View.GONE);
			}
		});
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
		mTimeListView.setAdapter(mAdapter);
		mTimeListView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 注意此处的顺序如果不设置setBackgroundDrawable是不能点击外侧消失的
				mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
				mPopupWindow.setTouchable(true);
				mPopupWindow.setOutsideTouchable(true);
				//mPopupWindow.showAtLocation(view, Gravity.BOTTOM, 0,0);
				mPopupWindow.showAsDropDown(view);
				setData(position);
				tv1.setText(mList.get(position).getContent());
				return false;
			}
		});
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}
	private void setData(int position){
		List<String> list=new ArrayList<String>();
		list.add(mList.get(position).getImagePathOne());
		list.add(mList.get(position).getImagePathTwo());
		list.add(mList.get(position).getImagePathThree());
		list.add(mList.get(position).getImagePathFour());
		
		List<ImageView> listPic=new ArrayList<ImageView>();
		listPic.add(iv1);
		listPic.add(iv2);
		listPic.add(iv3);
		listPic.add(iv4);
		
		
		for(int x=0;x<list.size();x++){
			if(!list.get(x).equals("1")){
				listPic.get(x).setVisibility(View.VISIBLE);
				ImageLoader.getInstance().displayImage("file://"+list.get(x),listPic.get(x));
			}
		}
	}
	
}
