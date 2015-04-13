package com.gmy.ttiannote.utils;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class NoteAnimationUtils {

	public NoteAnimationUtils() {
		// TODO Auto-generated constructor stub
	}
	public static void AnimaitonTranAlpha(View view,Float multiple,int duration){
		ObjectAnimator mTrans=ObjectAnimator.ofFloat(view, "translationX", multiple*view.getWidth());
		mTrans.setDuration(duration);
		ObjectAnimator mAlpha=null;
		if(multiple>0){
			mAlpha=ObjectAnimator.ofFloat(view, "alpha", 0.0f,1.0f);
			mAlpha.setDuration(duration);
		}else{
			mAlpha=ObjectAnimator.ofFloat(view, "alpha", 1.0f,0.0f);
			mAlpha.setDuration(duration);
		}
		
		AnimatorSet mAnimatorSet=new AnimatorSet();
		mAnimatorSet.play(mTrans).with(mAlpha);
		mAnimatorSet.start();
	}
	
}
