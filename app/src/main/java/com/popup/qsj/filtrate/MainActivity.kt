package com.popup.qsj.filtrate

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import popup.FilterPop
import popup.bean.M_Bean
import popup.bean.M_Data

class MainActivity : AppCompatActivity() {
    private  lateinit var mContext:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        mContext = this
        val bean = M_Bean()
        bean.title = "编程"
        val dataList = arrayListOf<M_Data>()
        val data = M_Data()
        data.id = 1;
        data.name = "Java"
        val data2 = M_Data()
        data2.id = 2;
        data2.name = "JavaScript"
        val data3 = M_Data()
        data3.id = 3;
        data3.name = "PHP"
        val data4 = M_Data()
        data4.id = 4;
        data4.name = "ASP"
        val data5 = M_Data()
        data5.id = 5;
        data5.name = "Perl"
        val data6 = M_Data()
        data6.id = 6;
        data6.name = "Python"
        val data7 = M_Data()
        data7.id = 7;
        data7.name = "C++"
        val data8 = M_Data()
        data8.id = 8;
        data8.name = "Go"
        val data9 = M_Data()
        data9.id = 9;
        data9.name = "C"
        dataList.add(data)
        dataList.add(data2)
        dataList.add(data3)
        dataList.add(data4)
        dataList.add(data5)
        dataList.add(data6)
        dataList.add(data7)
        dataList.add(data8)
        dataList.add(data9)

        bean.list = dataList

        var mList= arrayListOf<M_Bean>()
        mList.add(bean)

        bt.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this,"显示筛选框",Toast.LENGTH_SHORT).show();
            FilterPop(mContext,mList,bt)
        })
    }

}
