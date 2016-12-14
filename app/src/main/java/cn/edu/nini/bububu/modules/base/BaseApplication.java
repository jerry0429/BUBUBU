package cn.edu.nini.bububu.modules.base;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    private static String sCacheDir;
    public static Context sAppContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sAppContext = getApplicationContext();
/*        CrashHandler.init(new CrashHandler(getApplicationContext()));
        if (!BuildConfig.DEBUG) {
            FIR.init(this);
        }
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
        LeakCanary.install(this);*/
        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            sCacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            sCacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static String getAppCacheDir() {
        return sCacheDir;
    }
}
