package br.com.gdc

import android.app.Application

class MyApplication: Application() {

    companion object {
        lateinit var instance: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
    }

}