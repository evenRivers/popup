package popup.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.popup.qsj.filtrate.R
import popup.bean.M_Data
import popup.constant.Constants

/**
 * 选择项-adapter
 */
class ItemAdapter:RecyclerView.Adapter<ItemAdapter.ViewHolder>{
    private var context: Context? = null
    private var list: List<M_Data>
    private var mSelectedPos = -1
    private var title = ""

    constructor(context: Context?, list: List<M_Data>, title: String) : super() {
        this.context = context
        this.list = list
        this.title = title
        for (i in 0 until list.size) {
            if (list.get(i).isChecked()) {
                list.get(i).isChecked= false
            }
            if (list.get(i).id == Constants.getIdByKey(title)) {
                list.get(i).isChecked = true
                mSelectedPos = i
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_check,parent,false);
        val holder = ViewHolder(view);
        return holder;
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cb.setText(list.get(position).name)
        holder.cb.setOnClickListener { v ->
           setItemChecked(holder.adapterPosition)
        }
        if (list.get(position).id==Constants.getIdByKey(title)){
            holder.cb.isChecked = list.get(position).isChecked
        } else {
            holder.cb.isChecked = list.get(position).isChecked
        }


    }


    fun setItemChecked(position: Int) {
        if (mSelectedPos != position) {
            if (mSelectedPos == -1) {
                list.get(position).isChecked = !list.get(position).isChecked
                notifyItemChanged(position)
                mSelectedPos = position
                return
            }
            //先取消上个item的勾选状态
            list.get(mSelectedPos).setChecked(false)
            notifyItemChanged(mSelectedPos)
            //设置新Item的勾选状态
            mSelectedPos = position
            list.get(mSelectedPos).setChecked(true)
            notifyItemChanged(mSelectedPos)
        } else {
            list.get(position).isChecked = !list[position].isChecked
            notifyItemChanged(position)
        }
    }

    fun setSelectedItem() {
        val data = M_Data()
        var j = 0
        for (i in list.indices) {
            if (list[i].isChecked) {
                data.id = list[i].id
                data.name = list[i].name
                data.isChecked = list[i].isChecked()
                Constants.setBeanMap(title,data)
                break
            }
            j++
        }
        if (j == list.size) {
            data.id = -1
            data.name = "全部"
            data.isChecked = false
            Constants.setBeanMap(title, data)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var cb: CheckBox
        init {
            cb = view.findViewById(R.id.cb) as CheckBox
        }
    }
}