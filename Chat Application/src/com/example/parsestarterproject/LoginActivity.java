package com.example.parsestarterproject;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.net.ParseException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText username = null;
	private EditText password = null;
	private TextView attempts;
	private Button login;
	int counter = 3;
	public static int NumOfUsers = 1;
	public Intent intent;
	public Intent MessageIntent;
	public static final String USER = "com.example.parsestarterproject.USER";
	public static final String FROM = "com/example.parsestarterproject.FROM";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		intent = new Intent(this, MainActivity.class);
		MessageIntent = new Intent(this, DisplayMessageActivity.class);
		Parse.initialize(this, "hTiNDcItMdYRgvwjHbfWu5bps52eB1G1xexYiT2T",
				"XfMcdPUe3GFexDp8HDfFs5kPX0lxbFKBBB6GyAgK");
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();

		// If you would like all objects to be private by default, remove this
		// line.
		defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
		setContentView(R.layout.activity_login);
		username = (EditText) findViewById(R.id.editText1);
		password = (EditText) findViewById(R.id.editText2);
		attempts = (TextView) findViewById(R.id.textView5);
		attempts.setText(Integer.toString(counter));
		login = (Button) findViewById(R.id.button1);
	}

	public void login(View view) {
		if (username.getText().toString().equals("admin")
				&& password.getText().toString().equals("admin")
				|| checkWithDataBase()) { // add parse
			// back-end
			// functionality
			Toast.makeText(getApplicationContext(), "Redirecting...",
					Toast.LENGTH_SHORT).show();
			if (!noMessagePending()) {
				intent.putExtra(USER, username.getText().toString());
				startActivity(intent);
			} else {
				MessageIntent.putExtra(USER, username.getText().toString());
				MessageIntent.putExtra(FROM, "AJINKYA");
				//put in the message into messageintent TODO
				startActivity(MessageIntent);
			}

		} else {
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
					Toast.LENGTH_SHORT).show();
			attempts.setBackgroundColor(Color.RED);
			counter--;
			attempts.setText(Integer.toString(counter));
			if (counter == 0) {
				login.setEnabled(false);
			}
		}
	}

	private boolean noMessagePending() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean checkWithDataBase() { // TODO
		return false;
	}

	public void register(View view) {
		if (username.getText().toString().equals("")
				|| password.getText().toString().equals("")) {
			Toast.makeText(getApplicationContext(), "Wrong Credentials",
					Toast.LENGTH_SHORT).show();
		} else {
			ParseUser user = new ParseUser();
			user.setUsername(username.getText().toString());
			user.setPassword(password.getText().toString());
			user.signUpInBackground(new SignUpCallback() {
				public void done(ParseException e) {
					if (e == null) {
						// Hooray! Let them use the app now.
					} else {
						// Sign up didn't succeed. Look at the ParseException
						// to figure out what went wrong
					}
				}

				@Override
				public void done(com.parse.ParseException e) {
					// TODO Auto-generated method stub

				}
			});
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}