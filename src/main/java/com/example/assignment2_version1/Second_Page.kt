package com.example.assignment2_version1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import kotlin.random.Random

class Second_Page : AppCompatActivity() {

    // Initialize variables with random values between 15 and 55
    private var petHappiness = Random.nextInt(15, 55)
    private var petFullness = Random.nextInt(15, 55)
    private var petCleanliness = Random.nextInt(15, 55)
    private var progCirclePlay = Random.nextInt(15, 55)
    private var progCircleFeed = Random.nextInt(15, 55)
    private var progCircleClean = Random.nextInt(15, 55)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_page)

        // Get the buttons and text views
        val btnFeed = findViewById<Button>(R.id.btn_feed)
        val btnClean = findViewById<Button>(R.id.btn_clean)
        val btnHappy = findViewById<Button>(R.id.btn_play)
        val txtHunger = findViewById<EditText>(R.id.editTextFull)
        val txtClean = findViewById<EditText>(R.id.editTextClean)
        val txtHappy = findViewById<EditText>(R.id.editTextHappy)
        val petImage = findViewById<ImageView>(R.id.imageView)
        val circleFeed = findViewById<ProgressBar>(R.id.progress_feed)
        val circlePlay = findViewById<ProgressBar>(R.id.progress_play)
        val circleClean = findViewById<ProgressBar>(R.id.progress_clean)

        // Set the initial text values
        txtHunger.setText(petFullness.toString())
        txtClean.setText(petCleanliness.toString())
        txtHappy.setText(petHappiness.toString())
        circlePlay.progress = progCirclePlay
        circleFeed.progress = progCirclePlay
        circleClean.progress = progCirclePlay



        // Handle button clicks
        btnFeed.setOnClickListener {
            petFullness += 25
            petHappiness += 3
            petCleanliness -= 4
            txtHunger.setText(petFullness.toString())
            txtClean.setText(petCleanliness.toString())
            txtHappy.setText(petHappiness.toString())
            circleClean.progress = petCleanliness
            circlePlay.progress = petHappiness
            circleFeed.progress = petFullness
            animateImageChange(petImage, R.drawable.eating)

        }

        btnClean.setOnClickListener {
            petCleanliness += 35
            petHappiness -= 3
            petFullness -= 1
            txtClean.setText(petCleanliness.toString())
            txtHunger.setText(petFullness.toString())
            txtHappy.setText(petHappiness.toString())
            circlePlay.progress = progCirclePlay
            circleFeed.progress = progCirclePlay
            circleClean.progress = progCirclePlay
            animateImageChange(petImage, R.drawable.clean)
        }

        btnHappy.setOnClickListener {
            petHappiness += 20
            petFullness -= 2
            petCleanliness -= 12
            txtHappy.setText(petHappiness.toString())
            txtClean.setText(petCleanliness.toString())
            txtHunger.setText(petFullness.toString())
            circlePlay.progress = petHappiness
            circleFeed.progress = petFullness
            circleClean.progress = petCleanliness
            animateImageChange(petImage, R.drawable.play)
        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}