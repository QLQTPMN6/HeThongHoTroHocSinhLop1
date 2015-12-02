package hcb14.nhom6.behocvan;

import hcb14.nhom6.behocvan.MainFragmentActivity;
import hcb14.nhom6.behocvan.PageOne.ImageAdapter;
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

public class PageTwo extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		final View current_view = inflater.inflate(R.layout.page_two, null);
		GridView gridView = (GridView) current_view.findViewById(R.id.gridview2);
        gridView.setAdapter(new ImageAdapter(current_view.getContext()));
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
            R.drawable.lacopic,
            R.drawable.nhasanpic,
            R.drawable.lasenpic,
            R.drawable.hoalanpic
    };  
	
	private Integer[] soundIDs = {    		
            R.raw.lacosound,
            R.raw.nhasansound,
            R.raw.lasensound,
            R.raw.hoalansound
    };
}
