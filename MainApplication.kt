package com.cameraspoof

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import org.lsposed.hiddenapibypass.HiddenApiBypass
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // Bypass hidden API restrictions for Android 9+
        HiddenApiBypass.addHiddenApiExemptions("")
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }

    private class ReleaseTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            // In release, only log errors
            if (priority >= android.util.Log.ERROR) {
                android.util.Log.println(priority, tag ?: "CameraSpoof", message)
            }
        }
    }
}
