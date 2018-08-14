package cm.mfdog.virapk;

import android.app.Application;
import android.content.Context;

import com.didi.virtualapk.PluginManager;

public class App extends Application  {

    public static String aaa="123213";
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
    }
}
