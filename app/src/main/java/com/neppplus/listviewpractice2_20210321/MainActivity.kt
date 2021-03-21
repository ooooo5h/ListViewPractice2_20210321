package com.neppplus.listviewpractice2_20210321

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.neppplus.listviewpractice2_20210321.adapters.StudentAdapter
import com.neppplus.listviewpractice2_20210321.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    학생 목록을 담아둘 ArrayList 변수 추가
    val mStudentList = ArrayList<Student>()

//    xml + 데이터를 조합해서 뿌려주는 Adapter 변수 추가
//    변수는 미리 만들고 싶은데, 대입은 나중에 해야하는 상황
    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        학생 목록을 실제로 추가
        mStudentList.add(Student("조경진", 1988, "서울시 은평구"))
        mStudentList.add(Student("홍준호", 1995, "서울시 중구"))
        mStudentList.add(Student("김민철", 1990, "서울시 서대문구"))
        mStudentList.add(Student("김종진", 1991, "서울시 용산구"))
        mStudentList.add(Student("장혜진", 1993, "서울시 강동구"))

//        미뤄뒀던 mAdapter의 대입을 진행하자
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

//        완성된 어댑터 변수를 리스트뷰와 연결
        studentListView.adapter = mAdapter
        
//        학생리스트뷰 클릭 이벤트 구현
        studentListView.setOnItemClickListener { adapterView, view, i, l ->


//            position : 몇번 줄이 눌렸는지 알려주는 역할

//            클릭된 학생의 이름을 토스트로 출력해보자
            val clickedStudent = mStudentList[i]

            Toast.makeText(this, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }
//        리스트뷰 아이템 길게 눌렀을때 별도 처리

        studentListView.setOnItemLongClickListener { adapterView, view, i, l ->

            val clickedStudent = mStudentList[i]

            Toast.makeText(this, "${clickedStudent.name} 길게 눌림", Toast.LENGTH_SHORT).show()


            return@setOnItemLongClickListener true
        }


    }
}