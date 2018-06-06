package popup

import android.app.Activity
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.PopupWindow
import com.popup.qsj.filtrate.R
import popup.adapter.PopAdapter
import popup.bean.M_Bean

class FilterPop : PopupWindow {

    private var context: Context
    private lateinit var popWindow: PopupWindow
    private var mDatas : List<M_Bean>
    private lateinit var mAdapter: PopAdapter
    private lateinit var mWindow : Window


    constructor(context: Context, mDatas: List<M_Bean>,v:View) : super(context) {
        this.context = context
        this.mDatas = mDatas
        initPop(context,v)
    }


    private fun initPop(context:Context,v:View) {
        val popupView = LayoutInflater.from(context).inflate(R.layout.pop_filter, null)
        val activity = popupView.getContext() as Activity
        this.mWindow = activity.window
        holdView(popupView, context, mDatas)

        //初始化一个PopupWindow，width和height都是WRAP_CONTENT
        popWindow = PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        popWindow.contentView = popupView
        setBackgroundAlpha(0.5f);
        popWindow.isOutsideTouchable = false
//        popupWindow.isFocusable = true
        //设置PopupWindow动画
//        popupWindow.animationStyle = R.style.a
        //设置是否允许PopupWindow的范围超过屏幕范围
        popWindow.isClippingEnabled = false
        popWindow.setOnDismissListener  { setBackgroundAlpha(1.0f) }
        popWindow.showAsDropDown(v,0,-50)
    }

    private fun holdView(view: View, context: Context,  mDatas: List<M_Bean>?) {
        //规格
        val recyclerView = view.findViewById<View>(R.id.ryc) as RecyclerView
        val layoutManager1 = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager1
        recyclerView.setHasFixedSize(true)
        recyclerView.isNestedScrollingEnabled = false
        mAdapter = PopAdapter(context,mDatas)
        recyclerView.adapter = mAdapter
        mAdapter.setSpanCount(5)


        view.findViewById<View>(R.id.rtv_filt_cancel).setOnClickListener { dissmiss() }
        view.findViewById<View>(R.id.rtv_filt_submit).setOnClickListener {

                mAdapter.setSelectItem()

            dissmiss()
        }

    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     * 屏幕透明度0.0-1.0 1表示完全不透明
     */
    private fun setBackgroundAlpha(bgAlpha: Float) {
        val lp = (context as Activity).window
                .attributes
        lp.alpha = bgAlpha
        (context as Activity).window.attributes = lp
    }

    fun dissmiss() {

        if (this.mWindow != null) {
            val params = this.mWindow.getAttributes()
            params.alpha = 1.0f
            this.mWindow.setAttributes(params)
        }

        if (popWindow.isShowing()) {
            popWindow.dismiss()
        }

    }
}