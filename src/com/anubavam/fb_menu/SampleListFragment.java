package com.anubavam.fb_menu;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SampleListFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SampleAdapter adapter = new SampleAdapter(getActivity());
		for (int i = 1; i < 16; i++) {
			adapter.add(new SampleItem("Menu "+i, android.R.drawable.ic_menu_search));
		}
		setListAdapter(adapter);
	}

	private class SampleItem {
		public String tag;
		public int iconRes;
		public SampleItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			final TextView title = (TextView) convertView.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			
			convertView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String titleText = title.getText().toString();
					Fragment newContent = new ContentFragment(titleText);
					Log.d("@@##","newContent  = "+newContent);
					if (newContent != null) {
						Log.d("@@##","newContent  called");
						switchFragment(newContent);
					}
					Toast.makeText(getActivity(), "Item clicked - "+title.getText(), Toast.LENGTH_LONG).show();
				}
			});

			return convertView;
		}

	}
	
	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		Log.d("@@##","inside switchFragment");
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof MainActivity) {
			Log.d("@@##","inside switchContent called");
			MainActivity fca = (MainActivity) getActivity();
			fca.switchContent(fragment);
		}
	}
}
