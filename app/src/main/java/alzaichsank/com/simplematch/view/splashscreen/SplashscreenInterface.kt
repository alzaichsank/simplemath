package alzaichsank.com.simplematch.view.splashscreen

import android.app.Activity

/**
 * Created by alzaichsank on 4/13/18.
 */
interface SplashscreenInterface {
    fun checkPermission(activity: Activity, PERMISSION: Array<String>)

    fun resultPermission(activity: Activity, requestCode: Int, grantResults: IntArray)
}