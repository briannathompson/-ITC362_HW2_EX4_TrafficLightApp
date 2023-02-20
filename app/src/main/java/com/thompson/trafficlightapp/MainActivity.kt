package com.thompson.trafficlightapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
// Add ActivityMainBinding import statement
import com.thompson.trafficlightapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Declare a variable called binding of the type ActivityMainBinding
    private lateinit var binding: ActivityMainBinding

    // Declare a counter variable from the Counter class
    private lateinit var count: Counter

    // Declare current count variable
    private lateinit var currentCount: Number       // Int didn't work so I guessed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding variable
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the count variable using Counter()
        count = Counter()

        // Traffic light Listener that changes
        binding.trafficButton.setOnClickListener {
            // Increment the count because the stop button shows up by default
            count.addCount()
            // Get the current count that will be used in the following if statement
            currentCount = count.getCount()


            if (currentCount == 1) {        // GREEN LIGHT

                // Set the visibilities of the images to only show the greenlight
                binding.redlight.visibility = View.INVISIBLE
                binding.greenlight.visibility = View.VISIBLE
                binding.yellowlight.visibility = View.INVISIBLE

                // Change text and background color for Go
                binding.trafficButton.setText(R.string.go_text)
                binding.trafficButton.setBackgroundColor(Color.GREEN)

            } else if (currentCount == 2){      // YELLOW LIGHT

                // Set the visibilities of the images to only show the yellowlight
                binding.redlight.visibility = View.INVISIBLE
                binding.greenlight.visibility = View.INVISIBLE
                binding.yellowlight.visibility = View.VISIBLE

                // Change all the text and colors set in the activity_main.xml
                binding.trafficButton.setText(R.string.wait_text)
                binding.trafficButton.setBackgroundColor(Color.YELLOW)

            } else {            // RED LIGHT
                // Set the visibilities of the images to only show the redlight
                binding.redlight.visibility = View.VISIBLE
                binding.greenlight.visibility = View.INVISIBLE
                binding.yellowlight.visibility = View.INVISIBLE

                // Change all the text and colors set in the activity_main.xml
                binding.trafficButton.setText(R.string.stop_text)
                binding.trafficButton.setBackgroundColor(Color.RED)
                count = Counter()           // Reestablish counter with count at 0

            }

        }

    }

}