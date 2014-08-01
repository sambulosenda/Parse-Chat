package com.example.parsestarterproject;

import com.parse.Parse;

import android.app.Application;
import android.content.res.Configuration;

public class MyApplication extends Application {
	
	
	private static MyApplication singleton;

	public MyApplication getInstance() {
		return singleton;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		singleton = this;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}
