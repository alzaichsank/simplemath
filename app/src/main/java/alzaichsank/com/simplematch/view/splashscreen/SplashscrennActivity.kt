package alzaichsank.com.simplematch.view.splashscreen

import alzaichsank.com.esra_lc.view.splashscreen.SplashPresenter
import alzaichsank.com.simplematch.R
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class SplashscrennActivity : AppCompatActivity() {

    private var resume = false
    private var presenter = SplashPresenter()

    private val PERMISSIONS = arrayOf(
        android.Manifest.permission.INTERNET,
        android.Manifest.permission.ACCESS_NETWORK_STATE,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        setContentView(R.layout.activity_splashscrenn)
        presenter.checkPermission(this, PERMISSIONS)
    }

    public override fun onResume() {
        super.onResume()
        Log.d("TAG", "Resume ya")
        if (resume) {
        }
        resume = true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.resultPermission(this, requestCode, grantResults)
    }

    override fun onBackPressed() {}
}
