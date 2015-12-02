package hcb14.nhom6.behocvan;

import hcb14.nhom6.behocvan.MainFragmentActivity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;

public class PageThree extends Fragment {

	private MediaPlayer player;
	private View current_view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		final View current_view = inflater.inflate(R.layout.page_three, null);
		this.current_view = current_view;
		return current_view;
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
            	player.stop();
                return true;
        }
        return false;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    // TODO Add your menu entries here
	    super.onCreateOptionsMenu(menu, inflater);
	    MenuItem fav = menu.add("add");
        //fav.setIcon(R.drawable.btn_star_big_off);
	}
}
