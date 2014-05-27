package com.example.dutyrostertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
//import android.widget.Toast;
import android.widget.DatePicker.OnDateChangedListener;

public class MainActivity extends Activity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			final TextView textView = (TextView) findViewById(R.id.rosterText1);
			
			textView.setText("今天:"
					+ InforCalc.CalculateRoster(ForToday.today));
			
			DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker1);
			
			datePicker.init(ForToday.year, ForToday.month-1, ForToday.dayofMonth,
					new OnDateChangedListener(){
						public void onDateChanged(DatePicker view, int year,
								int month, int dayOfMonth) {
							month = month + 1;
							String formonth = String.valueOf(month);
							String forday = String.valueOf(dayOfMonth);
							
							String fordate = String.valueOf(year) +"/"+ formonth +"/"+ forday;
							textView.setText(String.valueOf(month) + "月"
									+ String.valueOf(dayOfMonth) + "日:"
									+ InforCalc.CalculateRoster(fordate));
							//Toast.makeText(getApplicationContext(), date, Toast.LENGTH_SHORT).show();
						}

					});
		}

}
