package com.works.models

data class Todo(
    val title: String,
    val detail: String,
    val color: Int
)

data class DocTodo(
    val id: String,
    val data: Todo
)
