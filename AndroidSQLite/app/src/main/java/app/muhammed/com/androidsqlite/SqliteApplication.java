package app.muhammed.com.androidsqlite;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Muhammed on 30/09/17.
 */

public class SqliteApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

    }
}
