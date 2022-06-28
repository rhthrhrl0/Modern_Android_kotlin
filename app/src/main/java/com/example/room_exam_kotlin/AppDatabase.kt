package com.example.room_exam_kotlin

import androidx.room.Database
import androidx.room.RoomDatabase

//원래 entities에는 클래스 자체가 담긴 배열을 줘야함. 코틀린의 배열은 arrayOf임.
@Database(entities = arrayOf(Todo::class),version = 1)
abstract class AppDatabase:RoomDatabase()  {
    abstract fun todoDao():TodoDao
}