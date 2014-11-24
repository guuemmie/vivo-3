package us.sanguo.ane.vivo.funs;

import us.sanguo.ane.vivo.context.IABCont;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;

public class Init extends IABFunctionBase {

	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		Log.d(getTag(), "---------init-------");
		try
		{
		}
		catch (Exception $e)
		{
			dispatch($e.getMessage());
		}
		return null;
	}
	

	@Override
	public String getTag() {
		return IABCont.FUNS.INIT.toString();
	}
}
