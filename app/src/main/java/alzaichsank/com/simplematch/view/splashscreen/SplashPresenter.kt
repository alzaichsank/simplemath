package alzaichsank.com.esra_lc.view.splashscreen

/**
 * Created by Alza Ichsan Kurniawa on 23/12/2017.
 */
import alzaichsank.com.simplematch.system.config.ApiConfig
import alzaichsank.com.simplematch.view.form.FormActivity
import alzaichsank.com.simplematch.view.main.MainActivity
import alzaichsank.com.simplematch.view.splashscreen.SplashscreenInterface
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import android.os.Handler
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.util.Log

class SplashPresenter : SplashscreenInterface {

    // TODO Auto-generated catch block
    val isOnline: Boolean?
        get() {
            try {
                val p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.deggan.com/internet")
                val returnVal = p1.waitFor()
                return (returnVal == 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return false
        }


    override fun checkPermission(activity: Activity, permit: Array<String>) {
        if (isNetworkAvailable(activity) || isOnline!!) {
            if (Build.VERSION.SDK_INT >= 23) {
                Log.d(ApiConfig.TAG, "IN IF Build.VERSION.SDK_INT >= 23")

                if (!hasPermissions(activity, *permit)) {
                    Log.d(ApiConfig.TAG, "IN IF hasPermissions")
                    ActivityCompat.requestPermissions(activity, permit, ApiConfig.REQUEST_PERMISSION)
                } else {
                    Log.d(ApiConfig.TAG, "IN ELSE hasPermissions")
                    splashLanding(activity)
                }
            } else {
                Log.d(ApiConfig.TAG, "IN ELSE  Build.VERSION.SDK_INT >= 23")
                splashLanding(activity)
            }
        } else {
            val alert = android.support.v7.app.AlertDialog.Builder(activity)
            alert.setTitle("Warning!")
            alert.setMessage("Please turn on Internet connection and re-open Wifi Tester Monitor!")
            alert.setCancelable(false)
            alert.setPositiveButton(
                "Yes"
            ) { _, _ ->
                // TODO Auto-generated method stub
                val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                activity.startActivity(intent)
            }
            alert.setNegativeButton("No",
                object : DialogInterface.OnClickListener {
                    override fun onClick(dialog: DialogInterface, which: Int) {
                        // TODO Auto-generated method stub
                        if (isNetworkAvailable(activity) || isOnline!!) {
                            activity.finish()
                            activity.startActivity(activity.intent)
                        } else {
                            activity.finish()
                        }
                    }
                })
            alert.show()
        }
    }

    override fun resultPermission(activity: Activity, requestCode: Int, grantResults: IntArray) {
        when (requestCode) {
            ApiConfig.REQUEST_PERMISSION -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d(ApiConfig.TAG, "PERMISSIONS grant")
                    splashLanding(activity)
                } else {
                    Log.d(ApiConfig.TAG, "PERMISSIONS Denied")
                    val alert = android.support.v7.app.AlertDialog.Builder(activity)
                    alert.setTitle("Warning!")
                    alert.setMessage("Please give permission for Wifi Tester Monitor!")
                    alert.setCancelable(false)
                    alert.setPositiveButton("Yes",
                        object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface, which: Int) {
                                // TODO Auto-generated method stub
                                activity.finish()
                                activity.startActivity(activity.intent)
                            }
                        })
                    alert.show()
                }
            }
        }
    }

    private fun splashLanding(activity: Activity) {
        val SPLASH_TIME_OUT = 2500

        Handler().postDelayed(object : Thread() {
            override fun run() {
                val intent = Intent(activity, FormActivity::class.java)
                activity.startActivity(intent)
                activity.finish()
            }
        }, SPLASH_TIME_OUT.toLong())
    }

    private fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

    private fun isNetworkAvailable(activity: Activity): Boolean {
        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}
