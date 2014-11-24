package us.sanguo.ane.vivo.funs;

import us.sanguo.ane.vivo.context.IABCont;

import com.vivo.account.base.activity.LoginActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IABLoginActivity extends Activity {

	public final String KEY_SWITCH_ACCOUNT = "switchAccount";
	private final int REQUEST_CODE_LOGIN = 0;
	
	public final static String KEY_LOGIN_RESULT = "LoginResult";
	public final static String KEY_NAME = "name";
	public final static String KEY_OPENID = "openid";
	public final static String KEY_AUTHTOKEN = "authtoken";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        
		Intent __indent = getIntent();
		Boolean _switch =__indent.getBooleanExtra("switch", false);
		
		if(_switch){
			// 切换帐号
			Intent swithIntent = new Intent(this, LoginActivity.class);
			swithIntent.putExtra(KEY_SWITCH_ACCOUNT, true);
	//		swithIntent.putExtra(KEY_SHOW_TEMPLOGIN, false);
			startActivityForResult(swithIntent, REQUEST_CODE_LOGIN);
		}else{
			// 登录
			Intent loginIntent = new Intent(this, LoginActivity.class);
	//		loginIntent.putExtra(KEY_SHOW_TEMPLOGIN, false);
			startActivityForResult(loginIntent, REQUEST_CODE_LOGIN);
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d("LOGIN", "MainActivity, onActivityResult,requestCode="+requestCode+", resultCode="+resultCode);
		if(requestCode == REQUEST_CODE_LOGIN){
			if(resultCode == Activity.RESULT_OK){
				String loginResult = data.getStringExtra(KEY_LOGIN_RESULT);

    			dispatch(loginResult, IABCont.FUNS.LOGIN.toString());
    			
    			dispatch(IABCont.FUNS.LOGIN.toString(), loginResult);
    			
				Log.d("LOGIN", "loginResult="+loginResult);
				this.finish();
			}
		}
	}
	
	private void dispatch(String $code, String $level){
		if(IABCont.getInstance() != null)
			IABCont.getInstance().dispatchStatusEventAsync($code, $level);
	}
	
	@Override
	public void onDestroy() {
	    super.onDestroy();  // Always call the superclass
	}
}
