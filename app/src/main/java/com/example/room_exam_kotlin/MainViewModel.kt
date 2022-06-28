package com.example.room_exam_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

//AndroidViewModel은 생성자에서 애플리케이션을 받아야함. 물론 이걸 우리가 호출하지는 않음.
class MainViewModel(application: Application) :AndroidViewModel(application) {
    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "database-name"
    ).build()

    fun getAll():LiveData<List<Todo>>{
        return db.todoDao().getAll()
    }

    //suspend키워드를 명시해줌으로써 이 함수를 무조건 코루틴스코프 안에서 비동기적으로 만들도록 유도함.
    suspend fun insert(todo:Todo){
        db.todoDao().insert(todo)
    }

}