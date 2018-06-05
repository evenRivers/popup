package popup.layoutManager

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.util.AttributeSet

class MyGridLayoutManager :GridLayoutManager{
    var isScrollEnabled :Boolean = true

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)
    constructor(context: Context?, spanCount: Int) : super(context, spanCount)
    constructor(context: Context?, spanCount: Int, orientation: Int, reverseLayout: Boolean) : super(context, spanCount, orientation, reverseLayout)

    override fun canScrollVertically(): Boolean {
        return isScrollEnabled&&super.canScrollVertically()
    }
}