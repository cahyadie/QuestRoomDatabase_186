package com.example.praktikum9

import android.app.Application
import com.example.praktikum9.Depedenciesinjection.ContainerApp

class KrsApp : Application() {
    //fugsinya untuk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}