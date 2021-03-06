package il.ac.huji.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	@Override
	public void onResume()
	{
		super.onResume();
		CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
		chkRound.setChecked(false);
		EditText edtBillAmount = (EditText)findViewById(R.id.edtBillAmount);
		edtBillAmount.setText("");
		TextView txtTipResult = (TextView)findViewById(R.id.txtTipResult);
		txtTipResult.setText("");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onCalculateClicked(View v) {
		
		CheckBox chkRound = (CheckBox)findViewById(R.id.chkRound);
		boolean round=chkRound.isChecked();
		EditText billText = (EditText) findViewById(R.id.edtBillAmount);
		float bill = Float.parseFloat(billText.getText().toString());
		double tip = bill * 0.12 ;
		TextView tipTxt = (TextView) findViewById(R.id.txtTipResult);
		if (round) {
			int billRound = (int) Math.round(tip);
			tipTxt.setText("Tip: $"+billRound);
		} else {			
			tipTxt.setText("Tip: $"+String.format("%.2f", tip));
			
		}
	}

}
