package com.example.gesture;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DemoView d = new DemoView(this, null);
		setContentView(d);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@SuppressLint({ "ClickableViewAccessibility", "DrawAllocation" })
	public class DemoView extends View
	{
		Paint p = new Paint();
		Path pt = new Path();

		public DemoView(Context c,AttributeSet attrs)
		{
			super(c,attrs);
			p.setAntiAlias(true);
			p.setStrokeWidth(3f);
			p.setColor(Color.RED);
			p.setStyle(Paint.Style.STROKE);
			p.setStrokeJoin(Paint.Join.BEVEL);
			//p.setStrokeWidth(4f);

		}
		
		protected void onDraw(Canvas can)
		{
			
			//super.onDraw(can);
			can.drawPath(pt, p);
			can.drawCircle(100, 100, 20, p);
			RectF oval1 = new RectF(50,50,250,250);
			can.drawRect(100, 5, 200, 30, p);
			can.drawOval(oval1, p);
			can.rotate(-45);
		}
		
		public boolean onTouchEvent(MotionEvent m)
		{
			float x,y;
			x = m.getX();
			y = m.getY();
			switch(m.getAction())
			{
			case MotionEvent.ACTION_DOWN:
				pt.moveTo(x, y);
				break;
			case MotionEvent.ACTION_MOVE:
				pt.lineTo(x, y);
				break;
			case MotionEvent.ACTION_CANCEL:
				pt.lineTo(x, y);
				break;
			default:
				return false;
			}
			invalidate();
			return true;
			//return super.onTouchEvent(m);		
		}
		
		
		
	}
}
