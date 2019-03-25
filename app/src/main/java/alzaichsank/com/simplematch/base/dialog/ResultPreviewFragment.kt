package alzaichsank.com.simplematch.base.dialog

import alzaichsank.com.simplematch.R
import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.preview_result.view.*
import org.jetbrains.anko.displayMetrics

class ResultPreviewFragment : BottomSheetDialogFragment() {

    private val bottomSheetCallback by lazy {
        object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    dismiss()
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        }
    }

    companion object {
        //        const val DEFAULT_HEIGHT = WindowManager.LayoutParams.MATCH_PARENT
        const val DEFAULT_PEEK_HEIGHT = 300
        const val INTENT_DATA = "intent.extra.data"

        fun newInstance(detailData: String): ResultPreviewFragment {
            val bundle = Bundle().apply {
                putSerializable(INTENT_DATA, detailData)
            }

            return ResultPreviewFragment().apply {
                arguments = bundle
            }
        }
    }

    @SuppressLint("RestrictedApi")
    override fun setupDialog(dialog: Dialog?, style: Int) {
        super.setupDialog(dialog, style)

        val contentView = View.inflate(context, R.layout.preview_result, null)
        dialog?.setContentView(contentView)
        val layoutParams = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        val behavior = layoutParams.behavior
        if (behavior != null && behavior is BottomSheetBehavior<*>) {
            val screenHeight = context?.displayMetrics?.heightPixels ?: 0
            val dialogHeight = if (screenHeight > 0) ((screenHeight + 30) - (screenHeight / 1)) else DEFAULT_PEEK_HEIGHT
            behavior.peekHeight = dialogHeight
            behavior.setBottomSheetCallback(bottomSheetCallback)
        }

        initView(contentView)
    }

    private fun initView(view: View) {
        if (context == null) {
            dismiss()
            return
        }
        val detailData = arguments?.getString(INTENT_DATA)
        setData(view, detailData.toString())
    }

    private fun setData(view: View, detailData: String) {
        view.result.setText(detailData)
    }
}