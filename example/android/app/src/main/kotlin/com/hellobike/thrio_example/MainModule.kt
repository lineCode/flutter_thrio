package com.hellobike.thrio_example

import android.app.Activity
import android.content.Context
import com.hellobike.flutter.thrio.module.ModuleIntentBuilder
import com.hellobike.flutter.thrio.module.ThrioModule
import com.hellobike.flutter.thrio.navigator.FlutterIntentBuilder
import com.hellobike.flutter.thrio.navigator.IntentBuilder

object MainModule : ThrioModule(), ModuleIntentBuilder {

    override fun onModuleInit(context: Context) {
        setFlutterIntentBuilder(object : FlutterIntentBuilder() {
            override fun getActivityClz(): Class<out Activity> = CustomFlutterActivity::class.java
        })
        navigatorLogEnabled = true
    }

    override fun onPageRegister(context: Context) {
        registerIntentBuilder("/biz1/native1", object : IntentBuilder {
            override fun getActivityClz(): Class<out Activity> {
                return Native1Activity::class.java
            }
        })
        registerIntentBuilder("/biz2/native2", object : IntentBuilder {
            override fun getActivityClz(): Class<out Activity> {
                return Native2Activity::class.java
            }
        })
    }
}