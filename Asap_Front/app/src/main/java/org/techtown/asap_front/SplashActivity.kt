package org.techtown.asap_front

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.techtown.asap_front.LoginActivity
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val backgroundExecutor : ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
        val mainExecutor : Executor = ContextCompat.getMainExecutor(this)

        backgroundExecutor.schedule({
            mainExecutor.execute{
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 2, TimeUnit.SECONDS)

    }
}