package net.gongmingqm10.localisedandroid;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.umeng.analytics.MobclickAgent;

public class LocalisedApp extends Application implements Application.ActivityLifecycleCallbacks{

    private static LocalisedApp instance;

    private Tracker tracker;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initTracker();
    }

    private void initTracker() {
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
        analytics.setLocalDispatchPeriod(1800);

        tracker = analytics.newTracker("UA-48787063-4");
        tracker.enableExceptionReporting(true);
        tracker.enableAdvertisingIdCollection(true);
        tracker.enableAutoActivityTracking(true);
    }

    public static LocalisedApp getInstance() {
        return instance;
    }

    public boolean isGoogleServiceAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        return status == ConnectionResult.SUCCESS;
    }

    public boolean isChinaChannel() {
        return !isGoogleServiceAvailable();
    }

    public Tracker getTracker() {
        return tracker;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        MobclickAgent.onResume(activity);
    }

    @Override
    public void onActivityPaused(Activity activity) {
        MobclickAgent.onPause(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
