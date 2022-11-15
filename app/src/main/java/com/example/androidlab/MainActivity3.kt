package com.example.androidlab

import android.graphics.Insets.add
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlab.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var dataList: MutableList<DataVO>
    lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        dataList = mutableListOf<DataVO>()
        for (i in 1..30) {
            if (i % 2 == 0) {
                dataList.add(
                    DataVO(
                        "김은정${i}", "40세", "Asdf@gmail.con", "010-2222-3333", R.drawable.person00
                    )
                )
            } else {
                dataList.add(
                    DataVO(
                        "박은정${i}", "100세", "ㅂㅈㄷㄱ@gmail.con", "010-2222-4444", R.drawable.person01
                    )
                )
            }
        }
//        그리드 2줄
//        val layoutManager = GridLayoutManager(this, 2)
//        그리드 가로로 3줄 왼쪽부터배치
//        val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false)
//        그리드 가로로 3줄 오른쪽부터 배치
//        val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, true)
//        val layoutManager = LinearLayoutManager(this)   세로
//        val layoutManager = LinearLayoutManager(this)   가로
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        높이가 불규칙환그리드로 배치하기
//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


        customAdapter = CustomAdapter(dataList, this)
        val layoutManager: LinearLayoutManager = selectLayoutManager(1)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = customAdapter
        binding.recyclerView.addItemDecoration(MyDecoration(this@MainActivity3))



        binding.btnFab.setOnClickListener {
            val dialog = CustomMemberDialog(this, binding)
            dialog.showDialog()
        }
    }

    private fun selectLayoutManager(i: Int): LinearLayoutManager {
        return LinearLayoutManager(this)
    }

    public fun refreshRecyclerView(dataVO: DataVO) {
        dataList.add(dataVO)
        customAdapter.notifyDataSetChanged()
        Toast.makeText(this, "추가되었습니다", Toast.LENGTH_SHORT).show()
    }

    public fun refreshRecyclerViewDrop(dataVO: DataVO) {
        val name = dataVO.name
        dataList.remove(dataVO)
        customAdapter.notifyDataSetChanged()
        Toast.makeText(this, "${name}님이 삭제되었습니다.", Toast.LENGTH_SHORT).show()
    }

    //액션바에 메뉴 버튼 inflate 해서 보여즘
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        //serchview 기능 활성화 이벤터 처리까지 등록
        val menuItem = menu?.findItem(R.id.menu_search_view)
        val searchView = menuItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(message: String?): Boolean {
                Toast.makeText(applicationContext, "${message}", Toast.LENGTH_SHORT).show()
                Log.d("test", "${message}")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    //액션바에 있는 메뉴창을 클릭했을때 이벤트 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        return super.onOptionsItemSelected(item)
    }
}