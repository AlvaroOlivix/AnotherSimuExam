package com.example.anothersimulacro.feature.task.data.remote

import com.google.firebase.firestore.PropertyName

data class TaskEntityFs(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("name") @set:PropertyName("name") var name: String = "",
    @get:PropertyName("state") @set:PropertyName("state") var stateId: String = ""
)
