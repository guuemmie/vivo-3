package us.sanguo.ane.vivo.funs;

import us.sanguo.ane.vivo.context.IABCont;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREObject;
import com.bbkmobile.iqoo.payment.PaymentActivity;

public class Payment extends IABFunctionBase {

	@Override
	public FREObject call(FREContext $context, FREObject[] $args)
	{
		_context = $context;
		Log.d(getTag(), "---------payment-------");
		try
		{
			String amount = $args[0].getAsString(); 		//金额
			String productName = $args[1].getAsString(); 	//商品名
			String productDes = $args[2].getAsString(); 	//商品描述
			String vivoOrder = $args[3].getAsString(); 		//交易流水号，由订单推送接口返回
			String vivoSignature = $args[4].getAsString();  //签名信息，由订单推送接口返回
			String userId = $args[5].getAsString(); 		//vivo账户id，不允许为空

//			Double price = 1.00 * Integer.parseInt(amount);
			String packageName = getActivity().getPackageName();//获取应用的包名
			
			Bundle localBundle = new Bundle();
			localBundle.putString("transNo", vivoOrder);
			localBundle.putString("signature", vivoSignature);
			localBundle.putString("package", packageName); //在开发者平台创建应用时填写的包名，务必一致，否则SDK界面不会被唤起
			localBundle.putString("useMode", "00");//固定值
			localBundle.putString("productName", productName);//商品名称
			localBundle.putString("productDes", productDes);//商品描述
			localBundle.putDouble("price", Double.parseDouble(amount));//价格
			localBundle.putString("userId", userId);
			Intent target = new Intent(getActivity(), PaymentActivity.class);
			target.putExtra("payment_params", localBundle);
			getActivity().startActivity(target);
		}
		catch (Exception $e)
		{
			dispatch($e.getMessage());
		}
		return null;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		Bundle extras = data.getBundleExtra("pay_info");
//		String trans_no = extras.getString("transNo");
//		boolean pay_result = extras.getBoolean("pay_result");
//		String res_code = extras.getString("result_code");
//		String pay_msg = extras.getString("pay_msg");
	}
	
	@Override
	public String getTag() {
		return IABCont.FUNS.PAYMENT.toString();
	}

}