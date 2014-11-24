package us.sanguo.ane.vivo.funs;

import us.sanguo.ane.vivo.context.IABCont;

import android.content.Intent;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;

public class Login extends IABFunctionBase {
	
	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		Log.d(getTag(), "---------login-------");
		try
		{
			Intent __loginIntent = new Intent(getActivity(), IABLoginActivity.class);
			__loginIntent.putExtra("switch",$args[0].getAsBool());
			getActivity().startActivity(__loginIntent);
		}
		catch (Exception $e)
		{
			dispatch($e.getMessage());
		}
		return null;
	}

	@Override
	public String getTag() {
		return IABCont.FUNS.LOGIN.toString();
	}
}
