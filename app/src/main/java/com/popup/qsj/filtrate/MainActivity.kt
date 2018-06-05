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
    private var mList= arrayListOf<M_Bean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init() {
        mContext = this
        initData()

        bt.setOnClickListener(View.OnClickListener {
//            Toast.makeText(this,"显示筛选框",Toast.LENGTH_SHORT).show();
            FilterPop(mContext,mList,bt)
        })
    }

    fun initData(){
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
        mList.add(bean)
        //第二部分
        val bean1 = M_Bean()
        bean1.title = "手机"
        val dataList1 = arrayListOf<M_Data>()
        val data11 = M_Data()
        data11.id = 11;
        data11.name = "Android"
        val data12 = M_Data()
        data12.id = 12;
        data12.name = "IOS"
        val data13 = M_Data()
        data13.id = 3;
        data13.name = "WP"
        val data14 = M_Data()
        data14.id = 4;
        data14.name = "HTML5"
        val data15 = M_Data()
        data15.id = 5;
        data15.name = "VUE"
        dataList1.add(data11)
        dataList1.add(data12)
        dataList1.add(data13)
        dataList1.add(data14)
        dataList1.add(data15)
        bean1.list = dataList1
        mList.add(bean1)

    }

}
