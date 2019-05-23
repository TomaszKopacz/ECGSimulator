package com.tomaszkopacz.ecgsimulator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val server = GattServer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        advertiseBtn.setOnClickListener {
            server.onCreate(this)
        }

        discoverBtn.setOnClickListener {
            server.sendEcgSignal()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        server.onDestroy()
    }
}