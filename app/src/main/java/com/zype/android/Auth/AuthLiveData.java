package com.zype.android.Auth;

import android.arch.lifecycle.LiveData;

import com.squareup.otto.Subscribe;
import com.zype.android.core.settings.SettingsProvider;
import com.zype.android.utils.Logger;
import com.zype.android.webapi.WebApiManager;
import com.zype.android.webapi.builder.AuthParamsBuilder;
import com.zype.android.webapi.events.ErrorEvent;
import com.zype.android.webapi.events.auth.RefreshAccessTokenEvent;

/**
 * Created by Evgeny Cherkasov on 14.09.2018
 */
public class AuthLiveData extends LiveData<Boolean> {
    private static AuthLiveData instance;

    public static synchronized AuthLiveData getInstance(){
        if (instance == null){
            instance = new AuthLiveData();
            instance.updateLoginState();
        }
        return instance;
    }

    @Override
    protected void onActive() {
        Logger.d("onActive()");
        WebApiManager.getInstance().subscribe(this);
    }

    @Override
    protected void onInactive() {
        Logger.d("onInactive()");
        WebApiManager.getInstance().unsubscribe(this);
    }

    public void updateLoginState() {
        Logger.d("updateLoginState()");
        if (AuthHelper.isLoggedIn()) {
            if (AuthHelper.isAccessTokenExpired()) {
                refreshToken();
            }
            else {
                instance.setValue(true);
            }

        }
        else {
            instance.setValue(false);
        }
    }

    private void refreshToken() {
        Logger.d("refreshToken()");

        WebApiManager webApiManager = WebApiManager.getInstance();
        AuthParamsBuilder builder = new AuthParamsBuilder();
        builder.addClientId();
        builder.addRefreshToken(SettingsProvider.getInstance().getRefreshToken());
        builder.addGrandType(AuthParamsBuilder.REFRESH_TOKEN);
        webApiManager.executeRequest(WebApiManager.Request.AUTH_REFRESH_ACCESS_TOKEN, builder.build());
    }

    @Subscribe
    public void handleRefreshAccessTokenEvent(RefreshAccessTokenEvent refreshAccessTokenEvent) {
        Logger.d("handleRefreshAccessTokenEvent()");

        instance.setValue(true);
    }

    @Subscribe
    public void handleErrorEvent(ErrorEvent event) {
        if (event.getEventData() == WebApiManager.Request.AUTH_REFRESH_ACCESS_TOKEN) {
            Logger.d("handleErrorEvent()");

            SettingsProvider.getInstance().logout();
            instance.setValue(false);
        }
    }

}
