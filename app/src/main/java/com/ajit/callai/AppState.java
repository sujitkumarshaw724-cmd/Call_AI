package com.ajit.callai;
import android.content.Context; import android.content.SharedPreferences;
public final class AppState {
 private static SharedPreferences p(Context c){return c.getSharedPreferences("state",Context.MODE_PRIVATE);}
 public static void setInstruction(Context c,String s){p(c).edit().putString("instruction",s).apply();}
 public static String instruction(Context c){return p(c).getString("instruction","Caller ko batao ki main abhi available nahi hoon aur mera message le lo.");}
 public static void setEnabled(Context c,boolean v){p(c).edit().putBoolean("enabled",v).apply();}
 public static boolean enabled(Context c){return p(c).getBoolean("enabled",false);}
 public static void setAutoAnswer(Context c,boolean v){p(c).edit().putBoolean("autoAnswer",v).apply();}
 public static boolean autoAnswer(Context c){return p(c).getBoolean("autoAnswer",false);}
 public static void setNumber(Context c,String s){p(c).edit().putString("number",s).apply();}
 public static String number(Context c){return p(c).getString("number","");}
}
