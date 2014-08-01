package com.example.parsestarterproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {
	private Intent intent;
	private String user, fr, mess;
	private TextView userName, from, message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent retrieved = getIntent();
		user = retrieved.getStringExtra(LoginActivity.USER);
		fr = retrieved.getStringExtra(LoginActivity.FROM);
		intent = new Intent(this, MainActivity.class);
		intent.putExtra(LoginActivity.USER, user);	
		userName = (TextView) findViewById(R.id.UserName);
		from = (TextView) findViewById(R.id.From);
		message = (TextView) findViewById(R.id.Message);
		userName.setText(user);
		
		setContentView(R.layout.activity_display_message);
	}
	
	public void goToMain(View v)
	{
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

}
