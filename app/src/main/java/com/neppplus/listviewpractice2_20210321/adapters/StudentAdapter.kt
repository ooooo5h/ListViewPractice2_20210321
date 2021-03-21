package com.neppplus.listviewpractice2_20210321.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.neppplus.listviewpractice2_20210321.R
import com.neppplus.listviewpractice2_20210321.datas.Student
import org.w3c.dom.Text

class StudentAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext, resId, mList) {

//    xml > 코틀린 변수로 꺼내오도록 도와주는 클래스. (LayoutInflater)
    val inflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        기존의 결과를 버리고 => 새로운 결과를 직접 만들어서 사용하려고 지웠음! 리턴 슈퍼
//        position : 지금 그려주려는 위치가 어디인지? 알려준다
//        convertView : 재활용할 요소가 있는지? => 만약에 있다면 활용하고, 없다면 새로 그려주자자

        var tempRow = convertView

//        재활용 할 요소가 없나? 없으면 그려줘야한다
        if (tempRow == null) {
//            tempRow 내부가 비어있는 상황 ! => 채워주자
            tempRow = inflater.inflate(R.layout.student_list_item, null)
        }

//        tempRow는 절대 null이 아닐 것이다! => 무조건 결과로 나가도 된다.
        val row = tempRow!!

//        실제 데이터를 꺼내서 > UI 요소들에 반영

//        실제 데이터 변수 => mList 변수 (목록)안에 들어있다 => position에 맞는 데이터 추출
        val studentData = mList[position]

//        뿌려질 UI 요소를 가져오자 => row 변수 안에 있는 텍스트뷰 등을 꺼내오자
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

//        실제 데이터 UI 반영
        nameTxt.text = studentData.name
        ageTxt.text = "(${studentData.birthYear}세)"

//        완성된 row가 화면에 뿌려질 결과로선정
        return row


    }
}