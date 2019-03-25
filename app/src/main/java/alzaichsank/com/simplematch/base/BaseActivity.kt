@file:Suppress("DEPRECATION")

package alzaichsank.com.simplematch.base

import alzaichsank.com.simplematch.R
import alzaichsank.com.simplematch.extension.isVisible
import alzaichsank.com.simplematch.extension.makeGone
import alzaichsank.com.simplematch.extension.makeVisible
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import id.voela.actrans.AcTrans
import kotlinx.android.synthetic.main.layout_loading.*

open class BaseActivity : AppCompatActivity() {

    protected var disableBackPressed: Boolean = false
    protected var wantExitNow: Boolean = false
    protected var loading: ProgressDialog? = null

    override fun onBackPressed() {
        if (disableBackPressed) {
            return
        } else {
            if (wantExitNow) {
                finish()
                overrideBackAnimation()
            } else {
                super.onBackPressed()
                overrideBackAnimation()
            }
        }
    }

    protected fun showDialog(messageToShow: String) {
        loading = ProgressDialog(this, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT)
        loading = ProgressDialog.show(
            this, getString(R.string.progress_loading),
            messageToShow, false, false
        )
        loading?.show()
    }

    protected fun hideDialog() {
        if (loading != null) {
            if (loading!!.isShowing) {
                loading!!.dismiss()
                loading = null
            }
        }
    }

    protected fun showLoad() {
        if (linear_layout_loading != null) {
            linear_layout_loading.makeVisible()
            progress_loading.makeVisible()
            progress_text.makeGone()
        }
    }

    protected fun showLoad(messageToShow: String) {
        if (linear_layout_loading != null) {
            linear_layout_loading.makeVisible()
            progress_loading.makeVisible()
            progress_text.makeVisible()
            progress_text.text = messageToShow
        }
    }

    protected fun changeLoadText(messageToShow: String) {
        if (linear_layout_loading != null) {
            if (linear_layout_loading.isVisible()
                && progress_text.isVisible()
                && progress_loading.isVisible()
            ) {
                progress_text.text = messageToShow
            } else if (linear_layout_loading.isVisible()
                && progress_loading.isVisible()
            ) {
                progress_text.makeVisible()
                progress_text.text = messageToShow
            }
        }
    }

    protected fun hideLoad() {
        if (linear_layout_loading != null) {
            linear_layout_loading.makeGone()
        }
    }

    protected fun overrideBackAnimation() {
        AcTrans.Builder(this).performSlideToRight()
    }

    private fun overrideStartAnimation() {
        AcTrans.Builder(this).performSlideToLeft()
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overrideStartAnimation()
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overrideStartAnimation()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        hideDialog()
    }
}