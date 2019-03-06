package com.gyx.tableview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by gaoyuxiang on 2019/3/4.
 * ==============================
 * 功能描述：
 */
public class TableView extends LinearLayout {
	private LinearLayout tableRoot;
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private View viewMiddle;
	private View viewProgress;
	private TextView tvRightText;
	private int tv1_size;
	private int tv1_color;
	private int tv2_size;
	private int tv2_color;
	private int table_background;
	private int tv3_size;
	private int tv3_color;
	private int middle_size;
	private int middle_color;
	private int progress_bg_drawable;
	private int progress_height;
	private int right_text_size;
	private int right_text_color;

	public TableView(Context context) {
		this(context, null);
		//setAttr(context, null, 0);
	}

	public TableView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		//setAttr(context, attrs, 0);
	}

	public TableView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		setAttr(context, attrs, defStyleAttr);
	}

	private void setAttr(Context context, AttributeSet attrs, int defStyleAttr) {
		LayoutInflater.from(context).inflate(R.layout.table_view, this, true);
		tableRoot = (LinearLayout) findViewById(R.id.table_root);
		tv1 = (TextView) findViewById(R.id.tv_1);
		tv2 = (TextView) findViewById(R.id.tv_2);
		tv3 = (TextView) findViewById(R.id.tv_3);
		viewMiddle = (View) findViewById(R.id.view_middle);
		viewProgress = (View) findViewById(R.id.view_progress);
		tvRightText = (TextView) findViewById(R.id.tv_right_text);
		//
		TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.TableView, defStyleAttr, 0);
		//背景色
		table_background = a.getColor(R.styleable.TableView_table_background_color, 0xff0000ff);
		tableRoot.setBackgroundColor(table_background);
		//文字1
		tv1_size = a.getDimensionPixelSize(R.styleable.TableView_table_tv1_size, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 5, getResources().getDisplayMetrics()));
		tv1_color = a.getColor(R.styleable.TableView_table_tv1_color, 0xffffffff);
		tv1.setTextSize(tv1_size);
		tv1.setTextColor(tv1_color);
		//文字2
		tv2_size = a.getDimensionPixelSize(R.styleable.TableView_table_tv2_size, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 5, getResources().getDisplayMetrics()));
		tv2_color = a.getColor(R.styleable.TableView_table_tv2_color, 0xffffffff);
		tv2.setTextSize(tv2_size);
		tv2.setTextColor(tv2_color);
		//文字3
		tv3_size = a.getDimensionPixelSize(R.styleable.TableView_table_tv3_size, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 5, getResources().getDisplayMetrics()));
		tv3_color = a.getColor(R.styleable.TableView_table_tv3_color, 0xffffffff);
		tv3.setTextSize(tv3_size);
		tv3.setTextColor(tv3_color);
		//中间线
		middle_size = a.getDimensionPixelSize(R.styleable.TableView_table_middle_width, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 5, getResources().getDisplayMetrics()));
		middle_color = a.getColor(R.styleable.TableView_table_middle_background_color, 0xffff00ff);
		ViewGroup.LayoutParams layoutParams = viewMiddle.getLayoutParams();
		layoutParams.width = middle_size;
		viewMiddle.setLayoutParams(layoutParams);
		viewMiddle.setBackgroundColor(middle_color);
		//右边的进度条
		progress_bg_drawable = a.getResourceId(R.styleable.TableView_table_progress_background_drawable, R.drawable.shape_bg_del_gray_rectangle);
		progress_height = a.getDimensionPixelSize(R.styleable.TableView_table_progress_height, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 40, getResources().getDisplayMetrics()));
		viewProgress.setBackgroundResource(progress_bg_drawable);
		ViewGroup.LayoutParams layoutParams1 = viewProgress.getLayoutParams();
		layoutParams1.height = progress_height;
		viewProgress.setLayoutParams(layoutParams1);
		//右边的文字
		right_text_size = a.getDimensionPixelSize(R.styleable.TableView_table_right_text_size, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 5, getResources().getDisplayMetrics()));
		right_text_color = a.getColor(R.styleable.TableView_table_right_text_color, 0xff00ff00);
		tvRightText.setTextSize(right_text_size);
		tvRightText.setTextColor(right_text_color);
		a.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	public void setTv1Text(String tv1Text, int tv1_color) {
		tv1.setVisibility(VISIBLE);
		tv1.setText(tv1Text);
		if (tv1_color != -1) {
			tv1.setTextColor(tv1_color);
		}
	}

	public void setTv2Text(String tv2Text, int tv2_color) {
		tv2.setVisibility(VISIBLE);
		tv2.setText(tv2Text);
		if (tv2_color != -1) {
			tv2.setTextColor(tv2_color);
		}
	}

	public void setTv3Text(String tv3Text, int tv3_color) {
		tv3.setVisibility(VISIBLE);
		tv3.setText(tv3Text);
		if (tv3_color != -1) {
			tv3.setTextColor(tv3_color);
		}
	}

	/**
	 * 设置进度条宽度，最大值，文字
	 *
	 * @param num    数量
	 * @param maxNum 最大数量
	 * @param text   文字
	 */
	public void setProgressWidthAndRightText(int num, int maxNum, String text, int right_text_color) {
		Resources resources = this.getResources();
		DisplayMetrics dm = resources.getDisplayMetrics();
//		float density = dm.density;
		int screenWidth = dm.widthPixels;
		int screenHeight = dm.heightPixels;
		BigDecimal multiply = new BigDecimal(num).multiply(new BigDecimal(screenWidth)).divide(new BigDecimal(maxNum).multiply(new BigDecimal(2)), BigDecimal.ROUND_HALF_UP);
		//四分之一的屏幕宽度
		BigDecimal divide = new BigDecimal(screenWidth).divide(new BigDecimal("4"), 0, BigDecimal.ROUND_HALF_EVEN);
		//进度条宽度
		ViewGroup.LayoutParams layoutParams1 = viewProgress.getLayoutParams();
		layoutParams1.width = Integer.parseInt(multiply.toPlainString());
		viewProgress.setLayoutParams(layoutParams1);
		//
		tvRightText.setText(text);
		if (right_text_color != -1) {
			tvRightText.setTextColor(right_text_color);
		}
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tvRightText.getLayoutParams();
		//判断进度条宽度是否大于屏幕的4分之一，大于就在进度条内侧靠右边显示文字，否则在外面靠进度条右侧显示文字
		if (Integer.parseInt(multiply.toPlainString()) > Integer.parseInt(divide.toPlainString())) {
			layoutParams.addRule(RelativeLayout.ALIGN_RIGHT, viewProgress.getId());
		} else {
			layoutParams.addRule(RelativeLayout.RIGHT_OF, viewProgress.getId());
		}
		layoutParams.setMargins(10, 0, 10, 0);
		tvRightText.setLayoutParams(layoutParams);
	}

	/**
	 * 设置控件本身宽高
	 *
	 * @param width
	 * @param height
	 */
	public void setTableRootWidthHeight(int width, int height) {
		LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tableRoot.getLayoutParams();
		layoutParams.width = width;
		layoutParams.height = height;
		tableRoot.setLayoutParams(layoutParams);
	}
}





































