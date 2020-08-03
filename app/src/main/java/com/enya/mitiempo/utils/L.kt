package com.enya.mitiempo.utils

import com.enya.mitiempo.BuildConfig
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class L {
    private val NAME = "MI TIEMPO"

    init {
        val formatStrategy =
            PrettyFormatStrategy.newBuilder()
                .methodCount(1)
                .methodOffset(6)
                .tag(NAME)
                .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    companion object {
        private var instance: L? = null

        fun d(message: String) {
            initLog()
            Logger.d(message)
        }

        fun v(message: String) {
            initLog()
            Logger.v(message)
        }

        private fun initLog() {
            if (instance == null) {
                instance = L()
            }
        }
    }
}
