package popup.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.popup.qsj.filtrate.R
import popup.bean.M_Bean
import popup.layoutManager.MyGridLayoutManager

/**
 *外层-recycleView
 */
public class PopAdapter:RecyclerView.Adapter<PopAdapter.ViewHolder> {

    private var context:Context? = null
    private var list: List<M_Bean>? = null
    private lateinit var adapter : ItemAdapter

    private var spanCount :Int = 5

    constructor(context: Context, list: List<M_Bean>?) : super() {
        this.context = context
        this.list = list
    }

    fun setSpanCount(count:Int){
        spanCount = count
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false);
        val holder = ViewHolder(view);
        return holder;
    }

    override fun getItemCount(): Int {
        return list?.size as Int
    }

    override fun onBindViewHolder(holder:ViewHolder, position: Int) {
        holder.tv_title.text = list?.get(position)?.title;
        val gm = MyGridLayoutManager(context,spanCount)
        gm.isScrollEnabled = false
        holder.rv.layoutManager= gm
        holder.rv.isNestedScrollingEnabled = false
        adapter = ItemAdapter(context,list!![position].list,list!![position].title)
        holder.rv.adapter = adapter
    }

    fun setSelectItem(){
        for (m in 0 until itemCount){
            adapter.setSelectedItem(list!![m].list,list!![m].title)
        }
    }

     class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tv_title: TextView
        var rv: RecyclerView

        init {
            tv_title = view.findViewById(R.id.tv_title) as TextView
            rv = view.findViewById(R.id.rv) as RecyclerView
        }
    }
}