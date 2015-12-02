package hcb14.nhom6.behocvan;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

	private ArrayList<Fragment> view_list;	
	
	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		this.view_list = new ArrayList<Fragment>();
	}

	@Override
	public int getCount() {
		return view_list.size();
	}
	
	public void addView(Fragment view){
		view_list.add(view);
	}

	@Override
	public Fragment getItem(int index) {
		return view_list.get(index);
	}	
}
