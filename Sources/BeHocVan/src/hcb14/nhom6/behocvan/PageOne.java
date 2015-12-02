package hcb14.nhom6.behocvan;

import hcb14.nhom6.behocvan.MainFragmentActivity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class PageOne extends Fragment {

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		final View current_view = inflater.inflate(R.layout.page_one, null);
		GridView gridView = (GridView) current_view.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(current_view.getContext()));        
        gridView.setOnItemClickListener(new OnItemClickListener() 
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) 
            {                
                MainFragmentActivity.PlaySound(current_view.getContext(), soundIDs[position]);
            }
        });
        setHasOptionsMenu(true);
		return current_view;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    // TODO Add your menu entries here
	    super.onCreateOptionsMenu(menu, inflater);
	    MenuItem fav = menu.add("add");
        //fav.setIcon(R.drawable.btn_star_big_off);
	}
	
	public class ImageAdapter extends BaseAdapter 
    {
        private Context context;
 
        public ImageAdapter(Context c) 
        {
            context = c;
        }
 
        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }
 
        //---returns the ID of an item--- 
        public Object getItem(int position) {
            return position;
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) 
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                imageView = (ImageView) convertView;
            }        
            imageView.setImageResource(imageIDs[position]);
            return imageView;
        }
    }
	
	private Integer[] imageIDs = {    		
            R.drawable.a1_lower_letter,
            R.drawable.a2_lower_letter,
            R.drawable.a3_lower_letter,
            R.drawable.b_lower_letter,
            R.drawable.c_lower_letter,
            R.drawable.d1_lower_letter,
            R.drawable.d2_lower_letter,
            R.drawable.e1_lower_letter,
            R.drawable.e2_lower_letter,
            R.drawable.g_lower_letter,
            R.drawable.h_lower_letter,
            R.drawable.i_lower_letter,
            R.drawable.k_lower_letter,
            R.drawable.l_lower_letter,
            R.drawable.m_lower_letter,
            R.drawable.n_lower_letter,
            R.drawable.o1_lower_letter,
            R.drawable.o2_lower_letter,
            R.drawable.o3_lower_letter,
            R.drawable.p_lower_letter,
            R.drawable.q_lower_letter,
            R.drawable.r_lower_letter,
            R.drawable.s_lower_letter,
            R.drawable.t_lower_letter,
            R.drawable.u1_lower_letter,
            R.drawable.u2_lower_letter,
            R.drawable.v_lower_letter,
            R.drawable.x_lower_letter,
            R.drawable.y_lower_letter
    };
    
    private Integer[] soundIDs = {    	    		
    		R.raw.sa1_code,
    		R.raw.sa2_code,
    		R.raw.sa3_code,
    		R.raw.sa4_code,
    		R.raw.sa5_code,
    		R.raw.sa6_code,
    		R.raw.sa7_code,
    		R.raw.sa8_code,
    		R.raw.sa9_code,
    		R.raw.sa10_code,
    		R.raw.sa11_code,
    		R.raw.sa12_code,
    		R.raw.sa13_code,
    		R.raw.sa14_code,
    		R.raw.sa15_code,
    		R.raw.sa16_code,
    		R.raw.sa17_code,
    		R.raw.sa18_code,
    		R.raw.sa19_code,
    		R.raw.sa20_code,
    		R.raw.sa21_code,
    		R.raw.sa22_code,
    		R.raw.sa23_code,
    		R.raw.sa24_code,
    		R.raw.sa25_code,
    		R.raw.sa26_code,
    		R.raw.sa27_code,
    		R.raw.sa28_code,
    		R.raw.sa29_code,
    };
    
}
