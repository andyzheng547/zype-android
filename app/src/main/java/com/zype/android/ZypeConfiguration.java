package com.zype.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.zype.android.webapi.model.app.AppData;

/**
 * Created by Evgeny Cherkasov on 23.01.2018.
 */

public class ZypeConfiguration {
    private static final String PREFERENCE_NATIVE_SUBSCRIPTION = "ZypeNativeSubscription";
    private static final String PREFERENCE_NATIVE_TO_UNIVERSAL_SUBSCRIPTION = "ZypeNativeToUniversalSubscription";
    private static final String PREFERENCE_ROOT_PLAYLIST_ID = "ZypeRootPlaylistId";
    private static final String PREFERENCE_SUBSCRIBE_TO_WATCH_AD_FREE = "ZypeSubscribeToWatchAdFree";
    private static final String PREFERENCE_THEME = "ZypeTheme";
    private static final String PREFERENCE_UNIVERSAL_SUBSCRIPTION = "ZypeUniversalSubscription";
    private static final String PREFERENCE_UNIVERSAL_TVOD = "ZypeUniversalTVOD";

    public static final String THEME_LIGHT = "light";
    public static final String THEME_DARK = "dark";

    private static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void update(AppData appData, Context context) {
        clear(context);

        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        if (!TextUtils.isEmpty(appData.nativeSubscription)) {
            editor.putBoolean(PREFERENCE_NATIVE_SUBSCRIPTION, Boolean.valueOf(appData.nativeSubscription));
        }
        if (!TextUtils.isEmpty(appData.nativeToUniversalSubscription)) {
            editor.putBoolean(PREFERENCE_NATIVE_TO_UNIVERSAL_SUBSCRIPTION, Boolean.valueOf(appData.nativeToUniversalSubscription));
        }
        if (!TextUtils.isEmpty(appData.featuredPlaylistId)) {
            editor.putString(PREFERENCE_ROOT_PLAYLIST_ID, appData.featuredPlaylistId);
        }
        if (!TextUtils.isEmpty(appData.subscribeToWatchAdFree)) {
            editor.putBoolean(PREFERENCE_SUBSCRIBE_TO_WATCH_AD_FREE, Boolean.valueOf(appData.subscribeToWatchAdFree));
        }
        if (!TextUtils.isEmpty(appData.theme)) {
            editor.putString(PREFERENCE_THEME, appData.theme);
        }
        if (!TextUtils.isEmpty(appData.universalSubscription)) {
            editor.putBoolean(PREFERENCE_UNIVERSAL_SUBSCRIPTION, Boolean.valueOf(appData.universalSubscription));
        }
        if (!TextUtils.isEmpty(appData.universalTVOD)) {
            editor.putBoolean(PREFERENCE_UNIVERSAL_TVOD, Boolean.valueOf(appData.universalTVOD));
        }
        editor.apply();
    }

    public static void clear(Context context) {
        SharedPreferences prefs = getPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(PREFERENCE_NATIVE_SUBSCRIPTION);
        editor.remove(PREFERENCE_NATIVE_TO_UNIVERSAL_SUBSCRIPTION);
        editor.remove(PREFERENCE_ROOT_PLAYLIST_ID);
        editor.remove(PREFERENCE_SUBSCRIBE_TO_WATCH_AD_FREE);
        editor.remove(PREFERENCE_THEME);
        editor.remove(PREFERENCE_UNIVERSAL_SUBSCRIPTION);
        editor.remove(PREFERENCE_UNIVERSAL_TVOD);
        editor.apply();
    }

    private static boolean getBooleanPreference(String key, boolean defaultValue, Context context) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs.contains(key)) {
            return prefs.getBoolean(key, defaultValue);
        }
        else {
            return defaultValue;
        }
    }

    private static String getStringPreference(String key, String defaultValue, Context context) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs.contains(key)) {
            return prefs.getString(key, defaultValue);
        }
        else {
            return defaultValue;
        }
    }

    public static String getRootPlaylistId(Context context) {
        return getStringPreference(PREFERENCE_ROOT_PLAYLIST_ID, ZypeSettings.ROOT_PLAYLIST_ID, context);
    }

    public static boolean isNativeSubscriptionEnabled(Context context) {
        return getBooleanPreference(PREFERENCE_NATIVE_SUBSCRIPTION, ZypeSettings.NATIVE_SUBSCRIPTION_ENABLED, context);
    }

    public static boolean isNativeToUniversalSubscriptionEnabled(Context context) {
        return getBooleanPreference(PREFERENCE_NATIVE_TO_UNIVERSAL_SUBSCRIPTION, ZypeSettings.NATIVE_TO_UNIVERSAL_SUBSCRIPTION_ENABLED, context);
    }

    public static boolean isSubscribeToWatchAdFreeEnabled(Context context) {
        return getBooleanPreference(PREFERENCE_SUBSCRIBE_TO_WATCH_AD_FREE, ZypeSettings.SUBSCRIBE_TO_WATCH_AD_FREE_ENABLED, context);
    }

    public static String getTheme(Context context) {
        return getStringPreference(PREFERENCE_THEME, ZypeSettings.THEME, context);
    }

    public static boolean isUniversalSubscriptionEnabled(Context context) {
        return getBooleanPreference(PREFERENCE_UNIVERSAL_SUBSCRIPTION, ZypeSettings.UNIVERSAL_SUBSCRIPTION_ENABLED, context);
    }

    public static boolean isUniversalTVODEnabled(Context context) {
        return getBooleanPreference(PREFERENCE_UNIVERSAL_TVOD, ZypeSettings.UNIVERSAL_TVOD, context);
    }
}
