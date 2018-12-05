package com.framgia.cryptocurrency.screen.splash

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.screen.main.MainActivity

class SplashActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    Handler().postDelayed(
        { startActivity(MainActivity.newInstance(this@SplashActivity)) }, 2000)

  }
}
