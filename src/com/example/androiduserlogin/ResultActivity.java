package com.example.androiduserlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		//���ñ���
		setTitle("ע��ɹ�");
		//��������
		Intent intent=this.getIntent();
		Bundle bundle=intent.getBundleExtra("info");
		String strUsername=bundle.getString("username");
		String strMail=bundle.getString("mail");
		String strFrom=bundle.getString("from");
		String strNotify=bundle.getBoolean("notify")? "��":"��";
		String strSex=bundle.getInt("sexFlag") ==0 ? "��":"Ů";
		
		TextView username=(TextView) findViewById(R.id.username);
		username.setText(strUsername);
		TextView mail=(TextView) findViewById(R.id.mail);
		mail.setText(strMail);
		TextView from=(TextView) findViewById(R.id.from);
		from.setText(strFrom);
		TextView notify=(TextView) findViewById(R.id.notify);
		notify.setText(strNotify);
		TextView sex=(TextView) findViewById(R.id.sex);
		sex.setText(strSex);
		Button doneBt=(Button) findViewById(R.id.done);
		doneBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ResultActivity.this.finish();
			}
		});
	}
	

}
