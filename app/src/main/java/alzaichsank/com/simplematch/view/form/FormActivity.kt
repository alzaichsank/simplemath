@file:Suppress("DEPRECATION")

package alzaichsank.com.simplematch.view.form

import alzaichsank.com.simplematch.R
import alzaichsank.com.simplematch.base.BaseActivity
import alzaichsank.com.simplematch.view.main.MainActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.form_intro.*

class FormActivity : BaseActivity() {
    private var doubleBackToExitPressedOnce = false

    companion object {
        const val INTENT_KEY = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        setContentView(R.layout.form_intro)
        button_skipIntro.setOnClickListener {
            startActivityForResult(
                Intent(
                    this@FormActivity,
                    MainActivity::class.java), INTENT_KEY)
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, getString(R.string.exit_dialog), Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
