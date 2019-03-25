package alzaichsank.com.simplematch.view.main

import alzaichsank.com.simplematch.R
import alzaichsank.com.simplematch.base.BaseActivity
import alzaichsank.com.simplematch.view.math.MathActivity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private var menu_math = "1"

    companion object {
        const val INTENT_FEATURE = "intent.feature"
        const val INTENT_KEY = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        setContentView(R.layout.activity_main)
        button_sum.setOnClickListener {
            menu_math = "1"
            startActivityForResult(
                Intent(
                    this@MainActivity,
                    MathActivity::class.java
                ).apply {
                    putExtra(INTENT_FEATURE, menu_math)
                }, INTENT_KEY
            )
        }
        button_multiply.setOnClickListener {
            menu_math = "2"
            startActivityForResult(
                Intent(
                    this@MainActivity,
                    MathActivity::class.java
                ).apply {
                    putExtra(INTENT_FEATURE, menu_math)
                }, INTENT_KEY
            )
        }
        button_fibo.setOnClickListener {
            menu_math = "3"
            startActivityForResult(
                Intent(
                    this@MainActivity,
                    MathActivity::class.java
                ).apply {
                    putExtra(INTENT_FEATURE, menu_math)
                }, INTENT_KEY
            )
        }
        button_prime.setOnClickListener {
            menu_math = "4"
            startActivityForResult(
                Intent(
                    this@MainActivity,
                    MathActivity::class.java
                ).apply {
                    putExtra(INTENT_FEATURE, menu_math)
                }, INTENT_KEY
            )
        }
    }
}
