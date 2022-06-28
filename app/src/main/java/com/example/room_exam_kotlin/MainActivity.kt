package com.example.room_exam_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.room_exam_kotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewModel:MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "database-name"
//        ).build()



        // 컨트롤+스페이스 누르면 뭘 더 인자로 줘야하는지 등 알 수 있음. 알트+엔터와는 다른 용도로 유용함.
        viewModel.getAll().observe(this, Observer {
            binding.resultText.text=it.toString()
        })

        binding.addButton.setOnClickListener {
            //db.todoDao().insert(Todo(binding.todoEdit.text.toString()))
            //binding.resultText.text=db.todoDao().getAll().toString()
            // 라이브 데이터 적용했으므로 이제 이 부분은 필요없음.

            lifecycleScope.launch(Dispatchers.IO) { //Dispatchers.IO를 하면 백그라운드스레드에서 실행하도록 됨.
                viewModel.insert(Todo(binding.todoEdit.text.toString()))
            }
        }

        setContentView(binding.root)
    }
}