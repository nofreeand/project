package com.gmy.ttiannote.fragment;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import com.gmy.ttiannote.utils.NoteAnimationUtils;
import com.gmy.ttiannote.widget.NoteBookText;

public class RightFragment extends Fragment implements android.view.View.OnClickListener{
	private NoteBookText mNoteBookText;
	private Button mImageAddButton;
	private GridLayout mGridLayout;
	private ImageView mImageOne,mImageTwo,mImageThree,mImageFour;//拍照生成的缩略图
	private ImageView mBottomClick,mBottomSave,mBottomShare,mBottomBack;
	private final String[] imageChoice=new String[]{"拍照","图册"};
	private List<ImageView> mImageViews;
	private MyLongClickListener myLongClickListener;
	private Boolean haveStartAnimation = false; //测试2
	
	public RightFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.right_fragment, container,false);
		initLayout(view);
		initData();
		return view;
	}

	private void initLayout(View view) {
		mNoteBookText=(NoteBookText) view.findViewById(R.id.note_et);
		mImageAddButton=(Button) view.findViewById(R.id.add_image_bt);
		mImageOne=(ImageView) view.findViewById(R.id.image_one);
		mImageTwo=(ImageView) view.findViewById(R.id.image_two);
		mImageThree=(ImageView) view.findViewById(R.id.image_three);
		mImageFour=(ImageView) view.findViewById(R.id.image_four);
		
		mBottomClick=(ImageView) view.findViewById(R.id.bottom_func_click);
		mBottomSave=(ImageView) view.findViewById(R.id.bottom_func_click_save);
		mBottomShare=(ImageView) view.findViewById(R.id.bottom_func_click_share);
		mBottomBack=(ImageView) view.findViewById(R.id.bottom_func_click_back);
		
		mImageAddButton.setOnClickListener(this);
		mBottomClick.setOnClickListener(this);
	}
	
	private void initData() {
		myLongClickListener=new MyLongClickListener();
		mImageViews=new ArrayList<ImageView>();
		mImageViews.add(mImageOne);
		mImageViews.add(mImageTwo);
		mImageViews.add(mImageThree);
		mImageViews.add(mImageFour);
		for(ImageView imageViews:mImageViews){
			imageViews.setOnLongClickListener(myLongClickListener);//绑定长按监听
		}
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
			case 1://
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
		case R.id.add_image_bt://添加图片按钮
//			new AlertDialog.Builder(getActivity())
//						   .setTitle("选择图片")
//						   .setItems(imageChoice, new OnClickListener() {
//							
//							@Override
//							public void onClick(DialogInterface dialog, int which) {
//								// TODO Auto-generated method stub
//								switch (which) {
//								case 0:
//									Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//									startActivityForResult(intent, 1);
//								case 1:
//									Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//									break;
//								default:
//									break;
//								}
//							}
//						}).create().show();
			//mNoteBookText.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_launcher, 0, 0);
			
			for(int x=0;x<mImageViews.size();x++){
				if(mImageViews.get(x).getVisibility()==View.GONE){
					mImageViews.get(x).setVisibility(View.VISIBLE);
					break;
				}
			}
			if(mImageFour.getVisibility()==View.VISIBLE){
				Toast.makeText(getActivity(), "拍这么多照片好么...要矜持", Toast.LENGTH_SHORT).show();
				mImageAddButton.setVisibility(View.GONE);
			}
			
			break;
		case R.id.bottom_func_click:
			if(!haveStartAnimation){
				NoteAnimationUtils.AnimaitonTranAlpha(mBottomSave, 1f,500);
				NoteAnimationUtils.AnimaitonTranAlpha(mBottomShare, 2f,800);
				NoteAnimationUtils.AnimaitonTranAlpha(mBottomBack, 3f,1000);
				haveStartAnimation = true;
				return;
			}else if(haveStartAnimation){
				NoteAnimationUtils.AnimaitonTranAlpha(mBottomSave, 0.0f,500);
				NoteAnimationUtils.AnimaitonTranAlpha(mBottomShare, 0.0f,800);
				NoteAnimationUtils.AnimaitonTranAlpha(mBottomBack, 0.0f,1000);
				haveStartAnimation=false;
				return;
			}
			Toast.makeText(getActivity(), "底部点击",Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
			
		}
	}
	private class MyLongClickListener implements OnLongClickListener{

		@Override
		public boolean onLongClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId()==R.id.image_one || v.getId()==R.id.image_two ||v.getId()==R.id.image_three || v.getId()==R.id.image_four){
				if(v.getVisibility()==View.VISIBLE){
					v.setVisibility(View.GONE);
					if(mImageAddButton.getVisibility()==View.GONE){
						mImageAddButton.setVisibility(View.VISIBLE);
					}
				}
			}
			return false;
		}
		
	}

}
