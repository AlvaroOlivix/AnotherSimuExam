package com.example.anothersimulacro.core.providers

import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

object FireStoreProvider {
    fun provideFireStore(): FirebaseFirestore {
        return Firebase.firestore
    }
}