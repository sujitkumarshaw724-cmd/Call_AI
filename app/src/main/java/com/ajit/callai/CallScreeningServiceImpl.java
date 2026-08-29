package com.ajit.callai;
import android.net.Uri; import android.telecom.Call; import android.telecom.CallScreeningService;
public class CallScreeningServiceImpl extends CallScreeningService {
 @Override public void onScreenCall(Call.Details d){Uri u=d.getHandle();AppState.setNumber(this,u==null?"Unknown":u.getSchemeSpecificPart());respondToCall(d,new CallResponse.Builder().setDisallowCall(false).setRejectCall(false).setSkipCallLog(false).setSkipNotification(false).build());}
}
