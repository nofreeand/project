package com.gmy.ttiannote.fragment;


import java.util.LinkedHashMap;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.gmy.ttiannote.R;
import com.gmy.ttiannote.activity.ImageShowActivity;
import com.gmy.ttiannote.displayUtils.FuntionTools;
import com.gmy.ttiannote.utils.DocUtils;
import com.gmy.ttiannote.utils.NoteAnimationUtils;
import com.gmy.ttiannote.utils.NoteSqliteManger;
import com.gmy.ttiannote.utils.ParamUtils;
import com.gmy.ttiannote.widget.NoteBookText;

public class RightFragment extends Fragment implements android.view.View.OnClickListener{
	private NoteBookText mNoteBookText;
	private Button mImageAddButton;
	private GridLayout mGridLayout;
	private ImageView mImageOne,mImageTwo,mImageThree,mImageFour;//拍照生成的缩略图
	private ImageView mBottomClick,mBottomSave,mBottomShare,mBottomBack;
	private final String[] imageChoice=new String[]{"拍照","图册"};
	private LinkedHashMap<ImageView,String> mImageViews;//存储图片用的Map 使用LinkedHashMap防止数据错位
	private MyLongClickListener myLongClickListener;
	private Boolean haveStartAnimation = false;
	
	
	private String imagePath;
	
	private static final int QUERY_IMAGE=1;
	private static final int CHOOSE_IMAGE=2;
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
		
		
	}
	
	private void initData() {
		
		mImageViews=new LinkedHashMap<ImageView,String>();
		mImageViews.put(mImageOne,"1");
		mImageViews.put(mImageTwo,"1");
		mImageViews.put(mImageThree,"1");
		mImageViews.put(mImageFour,"1");
		
		mImageAddButton.setOnClickListener(this);
		mBottomClick.setOnClickListener(this);
		mImageOne.setOnClickListener(this);
		mImageTwo.setOnClickListener(this);
		mImageThree.setOnClickListener(this);
		mImageFour.setOnClickListener(this);
		mBottomSave.setOnClickListener(this);
		
		myLongClickListener=new MyLongClickListener();
		mImageOne.setOnLongClickListener(myLongClickListener);//绑定长按监听
		mImageTwo.setOnLongClickListener(myLongClickListener);
		mImageThree.setOnLongClickListener(myLongClickListener);
		mImageFour.setOnLongClickListener(myLongClickListener);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==Activity.RESULT_OK){
			switch (requestCode) {
			case QUERY_IMAGE:
				setPic(imagePath);
				break;
			case CHOOSE_IMAGE://获取图片的真实地址进行操作
				ContentResolver resolver=getActivity().getContentResolver();
				Uri uri=data.getData();
			    String [] proj={MediaStore.Images.Media.DATA};  
			    Cursor cursor = getActivity().managedQuery( uri,  
			                proj,                 // Which columns to return  
			                null,       // WHERE clause; which rows to return (all rows)  
			                null,       // WHERE clause selection arguments (none)  
			                null);                 // Order-by clause (ascending by name)  
			          
			    int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);  
			    cursor.moveToFirst();  
			    imagePath= cursor.getString(column_index); 
				setPic(imagePath);
				break;
			default:
				break;
			}
		}
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.image_one || v.getId()==R.id.image_two ||v.getId()==R.id.image_three || v.getId()==R.id.image_four ){
			Intent mIntent=new Intent(getActivity(),ImageShowActivity.class);
			mIntent.putExtra("pic", mImageViews.get(getActivity().findViewById(v.getId())));
			startActivity(mIntent);
		}
		switch (v.getId()) {
		case R.id.add_image_bt://添加图片按钮
			new AlertDialog.Builder(getActivity())
						   .setTitle("选择图片")
						   .setItems(imageChoice, new OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								switch (which) {
								case 0://拍照
									Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
									Uri mImageUri=DocUtils.getOutputMediaFileUri(getActivity());
									imagePath=mImageUri.getPath();
									intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
									startActivityForResult(intent, QUERY_IMAGE);
									break;
								case 1://相册
									Intent intent2=new Intent(Intent.ACTION_GET_CONTENT);
									intent2.setType("image/*");
									startActivityForResult(intent2, CHOOSE_IMAGE);
									break;
								default:
									break;
								}
							}
						}).create().show();	
			
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
			break;
		case R.id.bottom_func_click_save:
			/*"title varchar(50)," 数据库字段
			+ "content varchar(50),"
			+ "imagePathOne varchar(50),"
			+ "imagePathTwo varchar(50),"
			+ "imagePathThree varchar(50),"
			+ "imagePathFour varchar(50),"
			+ "time varchar(50)"
			*/
			if(v.getAlpha()==1){
				Toast.makeText(getActivity(), "保存",Toast.LENGTH_SHORT).show();
				ContentValues values=new ContentValues();
				values.put("title",ParamUtils.getTimeStamp());
				values.put("content",mNoteBookText.getText().toString());
				values.put("imagePathOne", mImageViews.get(mImageOne));
				values.put("imagePathTwo", mImageViews.get(mImageTwo));
				values.put("imagePathThree", mImageViews.get(mImageThree));
				values.put("imagePathFour", mImageViews.get(mImageFour));
				values.put("time", ParamUtils.getTimeStamp());
				NoteSqliteManger.getInstance().insertSql(getActivity(), values);
			}
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
			return true;
		}
	}
	
	private void setPic(String imagePath) {
		for(Map.Entry<ImageView,String> entry:mImageViews.entrySet()){
			if(entry.getKey().getVisibility()==View.GONE){
				entry.getKey().setVisibility(View.VISIBLE);
				//在这里getWidth().getHeight();值是零
				Log.i("show pic path", imagePath);
				mImageViews.put(entry.getKey(),imagePath);
				entry.getKey().setImageBitmap(ParamUtils.getSecondBitmap(FuntionTools.dip2px(getActivity(), 70), 
																		     FuntionTools.dip2px(getActivity(), 70), imagePath));
				break;
			}
		}
		if( mImageFour.getVisibility()==View.VISIBLE){
			Toast.makeText(getActivity(), "拍这么多照片好么……要矜持……不让拍了^_^", Toast.LENGTH_SHORT).show();
			mImageAddButton.setVisibility(View.GONE);
		}
	}

}
