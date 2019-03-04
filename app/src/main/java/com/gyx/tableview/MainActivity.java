package com.gyx.tableview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



	private RecyclerView recycler;
	private ArrayList<String> stringArrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		recycler = (RecyclerView) findViewById(R.id.recycler);
		stringArrayList = new ArrayList<>();



		for (int i = 0; i < 17; i++) {
			stringArrayList.add("第" + i + "个");
		}

		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		recycler.setLayoutManager(linearLayoutManager);
		recycler.setAdapter(new MyAdapter(stringArrayList,this));


	}

	class MyAdapter extends RecyclerView.Adapter<MainActivity.ListItemViewHolder> {



		private List<String> items;
		private Context mContext;

		MyAdapter(List<String> modelData, Context context) {
			this.mContext = context;
			if (modelData == null) {
				throw new IllegalArgumentException(
						"modelData must not be null");
			}
			this.items = modelData;
		}
		@NonNull
		@Override
		public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
			View itemView = LayoutInflater.
					from(viewGroup.getContext()).
					inflate(R.layout.item_demo_01,
							viewGroup,
							false);
			return new ListItemViewHolder(itemView,mContext);
		}

		@Override
		public void onBindViewHolder(@NonNull ListItemViewHolder listItemViewHolder, final int i) {

			listItemViewHolder.label.setText(items.get(i));
			listItemViewHolder.label.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Toast.makeText(mContext, "点击了", Toast.LENGTH_SHORT).show();
					String item = stringArrayList.get(i);
					stringArrayList.remove(i);
					stringArrayList.add(i - 1, item);


					notifyItemMoved(i,0);


				}
			});

		}

		@Override
		public int getItemCount() {
			return items.size();
		}
	}




	public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
		TextView label;

		public ListItemViewHolder(View itemView, final Context mContext) {
			super(itemView);
			label = (TextView)itemView.findViewById(R.id.text);



		}
	}

}
