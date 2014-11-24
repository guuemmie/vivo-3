package us.sanguo.ane.vivo;

import us.sanguo.ane.vivo.context.IABCont;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;

public class Vivo implements FREExtension{
public static final String TAG = "us.sanguo.ane.vivo.Vivo";

	@Override
	public FREContext createContext(String $type)
	{
		//if(ANEContext.IAB.toString().equals($type)) return new IABCont();
		return new IABCont();
	}

	@Override
	public void initialize()
	{
		Log.i(TAG, "Vivo initialize");
	}

	@Override
	public void dispose()
	{
		Log.i(TAG, "Vivo dispose");
	}
}