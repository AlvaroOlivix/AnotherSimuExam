package com.example.anothersimulacro.feature.task.data.remote

import com.google.firebase.firestore.PropertyName

data class StateEntityFs(
    @get:PropertyName("id") @set:PropertyName("id") var id: String = "",
    @get:PropertyName("nombre") @set:PropertyName("nombre") var nombre: String = ""
)