package com.example.room_exam_kotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(var title: String) { //data 키워드를 추가해주면 getter/setter와 toString을 자동으로 생성해줌.
    // 프라이머리 키는 생성자에 필요 없으므로 빼줌.
    // 코틀린 같은 경우는 기본값을 넣어 줘야 함.
    @PrimaryKey(autoGenerate = true) var id: Int=0

}