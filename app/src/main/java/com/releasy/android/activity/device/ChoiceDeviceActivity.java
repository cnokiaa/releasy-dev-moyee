package com.releasy.android.activity.device;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.releasy.android.R;
import com.releasy.android.activity.main.BaseActivity;
import com.releasy.android.constants.Constants;
import com.releasy.android.utils.SharePreferenceUtils;
import com.releasy.android.view.TopNavLayout;


public class ChoiceDeviceActivity extends BaseActivity {

	private final int TO_SEARCH_DEVICE = 100;
	private TopNavLayout mTopNavLayout;                     //导航菜单栏
	private SharePreferenceUtils spInfo;                    //SharePreference
	private LinearLayout m1Layout;                          //M1 Icon
	private LinearLayout m2Layout;                          //M2 Icon
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_choice_device);
	        
	    init();            //初始化
	}
	
	/**
	 * 初始化
	 */
    private void init(){
		spInfo = new SharePreferenceUtils(this); 
		
		initViews();    //初始化视图
		setTopNav();    //初始化导航栏
		initEvents();   //初始化点击事件
	}
	
    /**
	 * 初始化导航栏
	 */
	private void setTopNav(){
		mTopNavLayout.setTitltTxt(R.string.choice_device);
		mTopNavLayout.setLeftImgSrc(R.drawable.ic_nav_bar_back);
	}
    
    /**
	 * 初始化控件
	 */
	protected void initViews() {
		mTopNavLayout = (TopNavLayout) findViewById(R.id.topNavLayout);
		
		m1Layout = (LinearLayout) findViewById(R.id.m1_layout);
		m2Layout = (LinearLayout) findViewById(R.id.m2_layout);
	}

	/**
	 * 初始化监听函数
	 */
	protected void initEvents() {
		mTopNavLayout.setLeftImgOnClick(new OnClickListener(){
			public void onClick(View arg0) {
				ChoiceDeviceActivity.this.finish();
			}});
		
		m1Layout.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(ChoiceDeviceActivity.this,SearchDeviceForM1Activity.class);
				startActivityForResult(intent,TO_SEARCH_DEVICE);
			}});
		
		m2Layout.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent(ChoiceDeviceActivity.this,SearchDeviceForM2Activity.class);
				startActivityForResult(intent,TO_SEARCH_DEVICE);
			}});
	}
	
	/**
	 * 回调函数
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(TO_SEARCH_DEVICE == requestCode && resultCode == Activity.RESULT_OK){
			setResult(Activity.RESULT_OK);  
			ChoiceDeviceActivity.this.finish();
		}
	}

}
