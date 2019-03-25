package alzaichsank.com.simplematch.view.math

import alzaichsank.com.simplematch.R
import alzaichsank.com.simplematch.base.BaseActivity
import alzaichsank.com.simplematch.base.dialog.ResultPreviewFragment
import alzaichsank.com.simplematch.extension.makeGone
import alzaichsank.com.simplematch.view.main.MainActivity.Companion.INTENT_FEATURE
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_math.*
import java.util.*


class MathActivity : BaseActivity() {
    private var fitur = "1"
    private var name_menu = ""
    private var description_menu = ""
    private var resultOperation = 0
    private var resultList: MutableList<Int> = mutableListOf<Int>()

    companion object {
        const val INTENT_DATA = "intent.data"
        const val INTENT_KEY = 3
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
        initAction()
    }

    private fun initLayout() {
        setContentView(R.layout.activity_math)
        fitur = intent.getStringExtra(INTENT_FEATURE)
        when (fitur) {
            "1" -> {
                text_view_operator.text = "+"
                name_menu = getString(R.string.k1)
                description_menu = getString(R.string.note_1)
            }
            "2" -> {
                text_view_operator.text = "x"
                name_menu = getString(R.string.k2)
                description_menu = getString(R.string.note_2)
            }
            "3" -> {
                text_view_operator.makeGone()
                layout_edit_2.makeGone()
                name_menu = getString(R.string.k3)
                description_menu = getString(R.string.note_3)
            }
            "4" -> {
                text_view_operator.makeGone()
                layout_edit_2.makeGone()
                name_menu = getString(R.string.k4)
                description_menu = getString(R.string.note_4)
            }
        }
        text_view_title.text = name_menu
        text_intro.text = description_menu
    }

    private fun initAction() {
        button_check_result.setOnClickListener {
            when (fitur) {
                "1", "2" -> {
                    sumMultiply()

                }
                "3" -> {
                    resultList.clear()
                    fibonachi()
                }
                "4" -> {
                    resultList.clear()
                    prime()
                }
            }
        }
    }

    fun sumMultiply() {
        var x = edit_text_input.text.toString()
        var y = edit_text_input_2.text.toString()
        when (fitur) {
            "1" -> {
                resultOperation = x.toInt() + y.toInt()
            }
            "2" -> {
                resultOperation = x.toInt() * y.toInt()
            }
        }
        val detailsFragment = ResultPreviewFragment.newInstance(resultOperation.toString())
        detailsFragment.show(this.supportFragmentManager, "DriverFragment")
    }

    fun fibonachi() {
        val x = edit_text_input.text.toString()
        var fib1 = 0
        var fib2 = 1
        for (i in 0 until x.toInt()) {
            resultList.add(fib1)
            val sum = fib1 + fib2
            fib1 = fib2
            fib2 = sum
        }
        val detailsFragment = ResultPreviewFragment.newInstance(resultList.toString())
        detailsFragment.show(this.supportFragmentManager, "DriverFragment")
    }

    fun prime() {
        val n = edit_text_input.text.toString()
        var status = 1
        var num = 3
        if (n.toInt() >= 1) {
            //2 is a known prime number
            resultList.add(2)
        }

        var i = 2
        while (i <= n.toInt()) {
            var j = 2
            while (j <= Math.sqrt(num.toDouble())) {
                if (num % j == 0) {
                    status = 0
                    break
                }
                j++
            }
            if (status != 0) {
                resultList.add(num)
                i++
            }
            status = 1
            num++
        }
        val detailsFragment = ResultPreviewFragment.newInstance(resultList.toString())
        detailsFragment.show(this.supportFragmentManager, "DriverFragment")
    }

}
