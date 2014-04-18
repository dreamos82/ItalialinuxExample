package com.italialinux.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class ChoiceFragment extends ListFragment {
	
	private boolean isTablet = true;
		
	public void onListItemClick(ListView l, View v, int position, long id) {			
		String itemName = getListView().getItemAtPosition(position).toString();
		int container_id;
		if(isTablet){
			container_id = R.id.container_fragment;
		} else {
			container_id = R.id.fragment_container;
		}
		switch(position){
		case 0:
			getFragmentManager().beginTransaction().replace(container_id, new MyFirstFragment()).addToBackStack(null).commit();
			break;
		case 1:
			getFragmentManager().beginTransaction().replace(container_id, new MySecondFragment()).addToBackStack(null).commit();
			break;
		case 2:
			getFragmentManager().beginTransaction().replace(container_id, new MyThirdFragment()).addToBackStack(null).commit();
			break;
		default:
			Toast.makeText(getActivity(), getListView().getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
			break;
		}		
		super.onListItemClick(l, v, position, id);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.isTablet = true;
		if(getArguments()!=null){
			this.isTablet = getArguments().getBoolean("isTablet", true);
		}
		Log.i("TAG", "Is tablet? " + isTablet);
		return inflater.inflate(R.layout.fragment_list, container, false);
	}
}
