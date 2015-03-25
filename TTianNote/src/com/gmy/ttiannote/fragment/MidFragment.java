package com.gmy.ttiannote.fragment;

import java.util.ArrayList;
import java.util.List;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.adapter.NoteListAdapter;
import com.gmy.ttiannote.widget.TimeListView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MidFragment extends Fragment {
	private List<String> mList;
	private com.gmy.ttiannote.widget.TimeListView mTimeListView; 
	private NoteListAdapter mAdapter;
	private Activity mActivity;
	
	public MidFragment() {
		// TODO Auto-generated constructor stub
		
	}
	
	private void initData(){
		// TODO Auto-generated method stub
		mList=new ArrayList<String>();
		for(int x=0;x<20;x++){
			mList.add(x+"");
		}
		
		mAdapter=new NoteListAdapter(mList, mActivity);
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
}
