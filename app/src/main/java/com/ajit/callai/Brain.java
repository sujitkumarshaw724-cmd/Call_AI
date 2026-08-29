package com.ajit.callai;
public final class Brain {
 public static String reply(String s){String x=s==null?"":s.toLowerCase();if(x.contains("kaun")||x.contains("कौन"))return "Main unki taraf se call handle kar raha hoon. Aap apna message bata dijiye.";if(x.contains("kab")||x.contains("कब"))return "Main aapka message note kar raha hoon. Woh aapse baad mein sampark karenge.";if(x.contains("zaroori")||x.contains("जरूरी")||x.contains("important"))return "Theek hai, aap zaroori baat bata dijiye.";if(x.contains("message")||x.contains("मैसेज"))return "Ji, aap apna message bata dijiye.";return "Ji, main sun raha hoon. Aap apni baat bataiye.";}
}
