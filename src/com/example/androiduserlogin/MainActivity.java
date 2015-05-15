package com.example.androiduserlogin;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends Activity {
	private static final String places[]={"�й�","�й����","�й�����","�й�̨��"};
	private boolean isNotified=false;
	private int sexFlag=0;
	private boolean isChecked=false;
	private int plcFlag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//���ñ���
		setTitle("ע��");
		//��ȡ�ؼ�
		final EditText username=(EditText)findViewById(R.id.username);
		final EditText pwd=(EditText)findViewById(R.id.pwd);
		final EditText pwdrp=(EditText)findViewById(R.id.pwdrp);
		RadioGroup sex=(RadioGroup)findViewById(R.id.sex);
		Spinner from=(Spinner)findViewById(R.id.from);
		final EditText mail=(EditText)findViewById(R.id.mail);
		ToggleButton notify=(ToggleButton)findViewById(R.id.notify);
		CheckBox check=(CheckBox)findViewById(R.id.check);
		Button register=(Button)findViewById(R.id.register);
		Button cancel=(Button)findViewById(R.id.cancel);
		//��Spinner����������
		ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, places);
		//���������˵�����ʽ
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		from.setAdapter(adapter);
		//ע�����
		notify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				isNotified=arg1;
			}
		});
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				isChecked=arg1;
			}
		});
		sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				sexFlag=arg1;
			}
		});
		//fromע�����
		from.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//��ȡѡ�����ֵ
				plcFlag=arg2;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String strUser=username.getText().toString();
				String strPwd=pwd.getText().toString();
				String strPwdrp=pwdrp.getText().toString();
				String strMail=mail.getText().toString();
				if(strUser.equals("")){
					new AlertDialog.Builder(MainActivity.this)
					.setTitle("����")
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setMessage("�������û���")
					.setPositiveButton("ȷ��", null)
					.show();
					return;
					}
				if(!strPwd.equals(strPwdrp)){
					new AlertDialog.Builder(MainActivity.this)
					.setTitle("����")
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setMessage("�����������벻��ͬ")
					.setPositiveButton("ȷ��", null)
					.show();
					return;
				}
				if(!isChecked){
					new AlertDialog.Builder(MainActivity.this)
					.setTitle("����")
					.setIcon(android.R.drawable.ic_dialog_alert)
					.setMessage("�빴ѡͬ������")
					.setPositiveButton("ȷ��", null)
					.show();
					return;
				}
				//�����ݴ��ݸ�����һ��Activity
				Bundle bundle=new Bundle();
				bundle.putString("username", strUser);
				bundle.putString("mail", strMail);
				bundle.putString("from", places[plcFlag]);
				bundle.putBoolean("notify", isNotified);
				bundle.putBoolean("check", isChecked);
				bundle.putInt("sex", sexFlag);
				Intent intent=new Intent(MainActivity.this, ResultActivity.class);
				intent.putExtra("info", bundle);
				//�������Activity
				MainActivity.this.startActivity(intent);
				//�������Activity
				MainActivity.this.finish();
				//ResultActivity.this.startActivity(getIntent());
			}
		});
//		cancel.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				MainActivity.this.finish();
//			}
//		});
	}

	
}
