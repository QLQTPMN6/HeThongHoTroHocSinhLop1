package hcb14.nhom6.behocvan;

import hcb14.nhom6.behocvan.R;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainFragmentActivity extends FragmentActivity {
	
	private ViewPagerAdapter viewpageradapter;
	private ViewPager viewpager;
	private static MediaPlayer player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main_viewpager);	
		viewpageradapter = new ViewPagerAdapter(getSupportFragmentManager());
		viewpageradapter.addView(new PageOne());
		viewpageradapter.addView(new PageTwo());
		viewpageradapter.addView(new PageThree());
		viewpager = (ViewPager) findViewById(R.id.viewPager);
		viewpager.setAdapter(viewpageradapter);
		viewpager.setPageTransformer(true, new DepthPageTransformer());
	}
	
	public void previousFragment(View view){
		if(player != null)
			player.stop();
		int previous_index = viewpager.getCurrentItem() - 1;
		if(previous_index >= 0)
			viewpager.setCurrentItem(previous_index);
	}
	
	public void nextFragment(View view){
		if(player != null)
			player.stop();
		int next_index = viewpager.getCurrentItem() + 1;
		if(next_index < viewpager.getChildCount())
			viewpager.setCurrentItem(next_index);
	}
	
	public void readStory(View view){
		PlaySound(view.getContext(), R.raw.thovarua);
	}
	
	@Override
	public void onBackPressed(){
		player.stop();
		System.exit(0);
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.activity_screen_slide, menu);

        //menu.findItem(R.id.action_previous).setEnabled(viewpager.getCurrentItem() > 0);

        //MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
        //(viewpager.getCurrentItem() == viewpageradapter.getCount() - 1) ? R.string.action_finish : R.string.action_next);
        //item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        return true;
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //switch (item.getItemId()) {
            //case android.R.id.home:
               //NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
                //return true;

            //case R.id.action_previous:
            	//viewpager.setCurrentItem(viewpager.getCurrentItem() - 1);
                //return true;

            //case R.id.action_next:
            	//viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
                //return true;
        //}

        return super.onOptionsItemSelected(item);
    }
	
	public static void PlaySound(Context context, int resource_id){
		if(player == null || (player != null && !player.isPlaying())){
			player = MediaPlayer.create(context, resource_id);
			player.start();
		}
	}   
}