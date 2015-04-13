package com.gmy.ttiannote.fragment;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.adapter.NoteListAdapter;
import com.gmy.ttiannote.dao.NoteContentDAO;
import com.gmy.ttiannote.utils.NoteSqliteManger;
import com.gmy.ttiannote.widget.TimeListView;

public class MidFragment extends Fragment {
	public static List<NoteContentDAO> mList;
	private com.gmy.ttiannote.widget.TimeListView mTimeListView; 
	public static NoteListAdapter mAdapter;
	private Activity mActivity;
	
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
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initData();
		mTimeListView.setAdapter(mAdapter);
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}
}
