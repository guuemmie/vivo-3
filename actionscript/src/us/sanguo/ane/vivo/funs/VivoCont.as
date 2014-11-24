package us.sanguo.ane.vivo.funs
{
import flash.events.EventDispatcher;
import flash.events.StatusEvent;
import flash.external.ExtensionContext;

import us.sanguo.ane.vivo.enum.VivoFunction;

/**
 * 
 * @author zm
 * 创建日期：2014-11-19
 */
public class VivoCont extends EventDispatcher
{
	protected var _extension:ExtensionContext;
	
	public function VivoCont($context:ExtensionContext)
	{
		_extension = $context;
		if(!_extension) throw new TypeError('必须提供ExtensionContext实例！');
		_extension.addEventListener(StatusEvent.STATUS, handler_status);
	}
	
	protected function handler_status($evt:StatusEvent):void
	{
		this.dispatchEvent($evt);
	}
	
//	public function init(
//		appId:String,
//		appKey:String,
//		rate:String,
//		gamebiName:String):String{
//		
//		return _extension.call(VivoFunction.INIT,
//			appId,
//			appKey,
//			rate,
//			gamebiName) as String;
//	} 
	
	public function login(switchAccount:Boolean = false):String{
		return _extension.call(VivoFunction.LOGIN, switchAccount) as String;
	}
	
	/**
	 * 显示购买
	 * @param amount 产品价格
	 * @param orderID 订单号
	 * @param productDesc 产品描述
	 */		
	public function payment(amount:String, productName:String, productDes:String, 
							vivoOrder:String, vivoSignature:String, userId:String):String{
		return _extension.call(VivoFunction.PAYMENT,
			amount,
			productName,
			productDes,
			vivoOrder,
			vivoSignature,
			userId
		)as String;
	}
	
	public function dispose():void
	{
		if(_extension)
		{
			_extension.removeEventListener(StatusEvent.STATUS, handler_status);
			_extension.dispose();
			_extension = null;
		}
	}
}
}