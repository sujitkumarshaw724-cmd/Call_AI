package com.ajit.callai;
import android.Manifest; import android.app.Activity; import android.app.role.RoleManager; import android.content.Context; import android.os.Bundle; import android.widget.*; import android.view.Gravity;
public class MainActivity extends Activity {
 EditText instruction; CheckBox auto; TextView status; static final int P=12;
 TextView tv(String s){TextView t=new TextView(this);t.setText(s);t.setTextSize(16);t.setPadding(0,14,0,14);return t;}
 @Override public void onCreate(Bundle b){super.onCreate(b); build();}
 void build(){LinearLayout r=new LinearLayout(this);r.setOrientation(LinearLayout.VERTICAL);r.setPadding(28,28,28,28);
  TextView h=tv("📞 Call AI Assistant");h.setTextSize(28);h.setGravity(Gravity.CENTER);r.addView(h);
  r.addView(tv("Incoming call par assistant ko tumhari taraf se kya bolna hai, instruction likho."));
  instruction=new EditText(this);instruction.setMinLines(4);instruction.setGravity(Gravity.TOP);instruction.setHint("Example: Bolo main 20 minute mein call karunga aur message le lo.");instruction.setText(AppState.instruction(this));r.addView(instruction);
  auto=new CheckBox(this);auto.setText("Assistant mode: incoming call automatically answer kare");auto.setChecked(AppState.autoAnswer(this));r.addView(auto);
  Button save=new Button(this);save.setText("Save + Enable Assistant");save.setOnClickListener(v->{AppState.setInstruction(this,instruction.getText().toString().trim());AppState.setAutoAnswer(this,auto.isChecked());AppState.setEnabled(this,true);Toast.makeText(this,"Assistant enabled",Toast.LENGTH_SHORT).show();});r.addView(save);
  Button off=new Button(this);off.setText("Disable Assistant");off.setOnClickListener(v->{AppState.setEnabled(this,false);Toast.makeText(this,"Disabled",Toast.LENGTH_SHORT).show();});r.addView(off);
  Button screen=new Button(this);screen.setText("1. Enable Call Screening role");screen.setOnClickListener(v->role(RoleManager.ROLE_CALL_SCREENING));r.addView(screen);
  Button dialer=new Button(this);dialer.setText("2. Make app Default Phone (for call control)");dialer.setOnClickListener(v->role(RoleManager.ROLE_DIALER));r.addView(dialer);
  Button perm=new Button(this);perm.setText("3. Grant microphone + notifications");perm.setOnClickListener(v->requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO,Manifest.permission.POST_NOTIFICATIONS},P));r.addView(perm);
  status=tv("");r.addView(status);setContentView(r);update();}
 void role(String x){RoleManager rm=(RoleManager)getSystemService(Context.ROLE_SERVICE);if(rm!=null&&rm.isRoleAvailable(x))startActivityForResult(rm.createRequestRoleIntent(x),99);else Toast.makeText(this,"Role unavailable",Toast.LENGTH_LONG).show();}
 @Override protected void onResume(){super.onResume();if(status!=null)update();}
 void update(){RoleManager rm=(RoleManager)getSystemService(Context.ROLE_SERVICE);boolean s=rm!=null&&rm.isRoleHeld(RoleManager.ROLE_CALL_SCREENING);boolean d=rm!=null&&rm.isRoleHeld(RoleManager.ROLE_DIALER);status.setText("\nScreening role: "+s+"\nDefault Phone role: "+d+"\nAssistant: "+AppState.enabled(this));}
}
