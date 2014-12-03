package com.ihgoo.allinone.util;

import java.util.Set;

import android.R.integer;
import android.R.string;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;

/**
 * 
 * @author <a href="http://www.xunhou.me" target="_blank">Kelvin</a>
 *
 */
public class SharePreferenceUtil {

	private static SharedPreferences sp;
	private final static String SharePreferncesName = "SP_SETTING";

	/**
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return 是否保存成功
	 */
	public static boolean setValue(Context context, String key, Object value) {
		if (sp == null) {
			sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
		}
		Editor edit = sp.edit();
		if (value instanceof String) {
			return edit.putString(key, (String) value).commit();
		} else if (value instanceof Boolean) {
			return edit.putBoolean(key, (boolean) value).commit();
		} else if (value instanceof Float) {
			return edit.putFloat(key, (float) value).commit();
		} else if (value instanceof Integer) {
			return edit.putInt(key, (int) value).commit();
		} else if (value instanceof Long) {
			return edit.putLong(key, (long) value).commit();
		} else if (value instanceof Set) {
			return false;
		}
		return false;
	}

	public static boolean getBoolean(Context context, String key) {
		if (sp == null) {
			sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
		}
		return sp.getBoolean(key, false);
	}
	
	public static String getString(Context context ,String key){
		if (sp == null) {
			sp = context.getSharedPreferences(SharePreferncesName, Context.MODE_PRIVATE);
		}
		return sp.getString(key, "");
	}
	

}
