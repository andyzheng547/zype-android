package com.zype.android;

import com.zype.android.core.settings.SettingsProvider;

/**
 * Created by Evgeny Cherkasov on 18.03.2017.
 */

// TODO: Provide valid app settings
//
public class ZypeSettings {
    // Zype app key
    public static final String APP_KEY = "<APP_KEY>";
    // OAuth credentials
    public static final String CLIENT_ID = "<CLIENT_ID>";
    public static final String CLIENT_SECRET = "<CLIENT_SECRET>";
    // Playlist
    public static final String ROOT_PLAYLIST_ID = "<ROOT_PLAYLIST_ID>";

    // Google Analytics Tracking Id
    // TODO: To use Google Analytics provide your GA tracking id
    public static final String GA_TRACKING_ID = "";

    // Social
    // TODO: Add your real social network ids and web url
    public static final String FACEBOOK_ID = "";
    public static final String INSTAGRAM_ID = "";
    public static final String TWITTER_ID = "";
    public static final String WEB_URL = "";

    // Template version
    public static final String TEMPLATE_VERSION = BuildConfig.VERSION;

    // Monetization
    public static final boolean NATIVE_SUBSCRIPTION_ENABLED = Boolean.valueOf("<NATIVE_SUBSCRIPTION_ENABLED>");
    public static final boolean NATIVE_TO_UNIVERSAL_SUBSCRIPTION_ENABLED = Boolean.valueOf("<NATIVE_TO_UNIVERSAL_SUBSCRIPTION_ENABLED>");
    public static final boolean SUBSCRIBE_TO_WATCH_AD_FREE_ENABLED = Boolean.valueOf("<SUBSCRIBE_TO_WATCH_AD_FREE_ENABLED>");
    public static final boolean UNIVERSAL_SUBSCRIPTION_ENABLED = Boolean.valueOf("<UNIVERSAL_SUBSCRIPTION_ENABLED>");
    public static final boolean UNIVERSAL_TVOD = Boolean.valueOf("<UNIVERSAL_TVOD>");

    // Features
    /*
     *'Background playback', 'Downloads', 'Downloads for guests' and "Share video' options
     * are not currently supported by the app builder. Update these flags if needed.
     */
    public static final boolean BACKGROUND_PLAYBACK_ENABLED = false;
//    public static final boolean BACKGROUND_PLAYBACK_ENABLED = Boolean.valueOf("<BACKGROUND_PLAYBACK_ENABLED>");
    public static final boolean DOWNLOADS_ENABLED = false;
//    public static final boolean DOWNLOADS_ENABLED = Boolean.valueOf("<DOWNLOADS_ENABLED>");
    public static final boolean DOWNLOADS_ENABLED_FOR_GUESTS = false;
//    public static final boolean DOWNLOADS_ENABLED_FOR_GUESTS = Boolean.valueOf("<DOWNLOADS_ENABLED_FOR_GUESTS>");
    public static final boolean SHARE_VIDEO_ENABLED = false;
//    public static final boolean SHARE_VIDEO_ENABLED = Boolean.valueOf("<SHARE_VIDEO_ENABLED>");
    public static final String THEME = "<THEME>";
//    public static final boolean THEME_LIGHT = true;

    public static boolean isDownloadsEnabled() {
        return SettingsProvider.getInstance().getBoolean(SettingsProvider.DOWNLOADS_ENABLED);
    }

    public static boolean isDownloadsEnabledForGuests() {
        return SettingsProvider.getInstance().getBoolean(SettingsProvider.DOWNLOADS_ENABLED_FOR_GUESTS);
    }

    public static boolean isThemeLight() {
        return SettingsProvider.getInstance().getBoolean(SettingsProvider.THEME_LIGHT);
    }
}

