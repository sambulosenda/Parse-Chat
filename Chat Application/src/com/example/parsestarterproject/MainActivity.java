package com.example.parsestarterproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText sendUserName;
	private EditText message;
	private String messageUpd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent =  getIntent();
		String fromAddress = intent.getStringExtra(LoginActivity.USER);
	//	MyApplication appState = (MyApplication) this.getApplication();
		setContentView(R.layout.activity_main);
		sendUserName = (EditText) findViewById(R.id.Name);
		message = (EditText) findViewById(R.id.Message);
	}
	public void send(View v) {
		//find User
		//update table
		messageUpd = message.getText().toString();
		message.setText("");
		sendUserName.setText("");
	}

	public void logout(View v)
	{
		Intent logout = new Intent(this, LoginActivity.class);
		startActivity(logout);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
