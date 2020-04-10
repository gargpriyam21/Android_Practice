package com.example.neera.firebasedb.models

/**
 * Created by Neera on 22/10/17.
 */
class Todo {
    var task: String = ""
    var isDone: Boolean = false
    var uid: String? = null

    constructor() {
    }

    constructor(task: String, done: Boolean) {
        this.task = task
        this.isDone = done
    }
}