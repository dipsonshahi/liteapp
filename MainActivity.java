package com.dipson.liteapp;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
	ViewPager mViewPager;
	TabPagerAdapter TabAdapter;
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
        	
        	public void onPageSelected(int position) {
                actionBar = getActionBar();
                actionBar.setSelectedNavigationItem(position);
                }
        	
          });
        mViewPager.setAdapter(TabAdapter);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
        	
      public void onTabReselected(android.app.ActionBar.Tab tab,FragmentTransaction ft) {
        // TODO Auto-generated method stub
      }
      
      public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
             mViewPager.setCurrentItem(tab.getPosition());
         }
      
     public void onTabUnselected(android.app.ActionBar.Tab tab,FragmentTransaction ft) {
       
     }
    };
    
     actionBar.addTab(actionBar.newTab().setText("FlashLight").setTabListener(tabListener));
     actionBar.addTab(actionBar.newTab().setText("Chronometer").setTabListener(tabListener));
     actionBar.addTab(actionBar.newTab().setText("Clock").setTabListener(tabListener));
   
   }
	

}
