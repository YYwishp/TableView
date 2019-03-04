package com.gyx.tableview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by gaoyuxiang on 2019/3/4.
 * ==============================
 * 功能描述：
 */
public class TableView extends LinearLayout {
	public TableView(Context context) {
		this(context, null);

	}

	public TableView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);





	}

	public TableView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setAttr(context, attrs,defStyleAttr);
	}

	private void setAttr(Context context, AttributeSet attrs, int defStyleAttr) {

		LayoutInflater.from(context).inflate(R.layout.table_view, this, true);




	}
}
