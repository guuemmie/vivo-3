package us.sanguo.ane.vivo
{
import flash.external.ExtensionContext;
import flash.system.Capabilities;

import us.sanguo.ane.vivo.funs.VivoCont;

/**
 * 
 * @author zm
 * 创建日期：2014-11-19
 */
public class VivoExt
{
	/**
	 * 定义本地插件的ID
	 */	
	public static const EXT_ID:String = 'us.sanguo.ane.vivo';
	
	protected static var _cont:VivoCont= null;
	
	/**
	 * 获取当前插件
	 */
	public static function get iab():VivoCont
	{
		if(!_cont)
		{
			checkSuppored();
			_cont = new VivoCont(ExtensionContext.createExtensionContext(EXT_ID, ""));
		}
		return _cont;
	}
	
	protected static function get isSupported() : Boolean
	{
		return (Capabilities.os.indexOf("Linux") >= 0);
	}
	
	private static function checkSuppored():void
	{
		if(!isSupported) throw new TypeError('The native extension is not supported on this device!');
	}
}
}