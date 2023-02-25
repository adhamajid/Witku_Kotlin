package com.example.witku_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    private lateinit var labelTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        labelTextView = findViewById(R.id.label_text_view)
        Handler().postDelayed({
            labelTextView.visibility = View.VISIBLE
            runTextViewAnimation()
        }, 1000)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }, 3000)
    }

    private fun runTextViewAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_text_show)
        animation.reset()

        labelTextView.clearAnimation()
        labelTextView.startAnimation(animation)

    }

/*    private fun runTextViewAnimation() {




        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        //Normal Handler is deprecated , so we have to change the code little bit

        // Handler().postDelayed({
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)*/

}
