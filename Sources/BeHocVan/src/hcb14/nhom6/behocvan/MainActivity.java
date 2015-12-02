package hcb14.nhom6.behocvan;

import android.app.Activity;
import android.content.Intent;
import hcb14.nhom6.behocvan.R;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends Activity {
		
	private MediaPlayer player;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.main_menu);	
		player = MediaPlayer.create(getApplicationContext(), R.raw.chuechconbeat);
		player.setLooping(true);
		player.start();
	}  

	@Override
	public void onBackPressed(){
		if(player != null)
			player.stop();
		this.finish();
	}
	
	public void launchFragment(View view){
		player.stop();
		Intent intent = new Intent(this, MainFragmentActivity.class);
	    startActivity(intent);
	}
}
