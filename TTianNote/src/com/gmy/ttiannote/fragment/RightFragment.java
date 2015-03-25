package com.gmy.ttiannote.fragment;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Video;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.widget.NoteBookText;

public class RightFragment extends Fragment implements android.view.View.OnClickListener{
	private NoteBookText mNoteBookText;
	private Button mImageAddButton;
	private GridLayout mGridLayout;
	private final String[] imageChoice=new String[]{"拍照","图册"};
	
	public RightFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.right_fragment, container,false);
		initLayout(view);
		
		return view;
	}
	
	private void initLayout(View view) {
		// TODO Auto-generated method stub
		mNoteBookText=(NoteBookText) view.findViewById(R.id.note_et);
		mImageAddButton=(Button) view.findViewById(R.id.add_image_bt);
		//mGridLayout=(GridLayout) view.findViewById(R.id.add_image_gl);
		
		//mImageAddButton.setOnClickListener(this);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==Activity.RESULT_OK){
			switch (requestCode) {
			case 1:
				if(data!=null){
					Bitmap thumbnailBitmap=data.getParcelableExtra("data");
					Drawable mDrawable=new BitmapDrawable(thumbnailBitmap);
					if(mGridLayout.getChildCount()<4){
						ImageView mImageView=new ImageView(getActivity());
						mImageView.setTag("NoteImage"+mGridLayout.getChildCount());
						LayoutParams layoutParams=new LayoutParams(new LayoutParams());
						mImageView.setLayoutParams(layoutParams);
						
					}
				}
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.add_image_bt:
			new AlertDialog.Builder(getActivity())
						   .setTitle("选择图片")
						   .setItems(imageChoice, new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								switch (which) {
								case 0:
									Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
									startActivityForResult(intent, 1);
								case 1:
									Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
									break;
								default:
									break;
								}
							}
						}).create().show();
			//mNoteBookText.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_launcher, 0, 0);
		default:
			break;
		}
	}
}
