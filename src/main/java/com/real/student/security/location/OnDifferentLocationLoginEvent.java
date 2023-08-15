package com.real.student.security.location;

/**
 * @author ERNEST EMMANUEL UTIBE
 * */

import com.real.student.data.model.NewLocationToken;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

@SuppressWarnings("serial")
public class OnDifferentLocationLoginEvent extends ApplicationEvent {
    private final Locale locale;
    private final String username;
    private final String ip;
    private final NewLocationToken token;
    private final String appUrl;

    //

    public OnDifferentLocationLoginEvent(Locale locale, String username, String ip, NewLocationToken token, String appUrl) {
        super(token);
        this.locale = locale;
        this.username = username;
        this.ip = ip;
        this.token = token;
        this.appUrl = appUrl;
    }

    //
    public Locale getLocale() {
        return locale;
    }

    public String getUsername() {
        return username;
    }

    public String getIp() {
        return ip;
    }

    public NewLocationToken getToken() {
        return token;
    }

    public String getAppUrl() {
        return appUrl;
    }
}
