package com.neppplus.listviewpractice2_20210321.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.neppplus.listviewpractice2_20210321.datas.Student

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {
}