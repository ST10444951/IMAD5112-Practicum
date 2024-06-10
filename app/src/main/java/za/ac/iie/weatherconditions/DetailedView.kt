package za.ac.iie.weatherconditions

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailedView : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val day = intent.getStringArrayListExtra("day") ?: arrayListOf()
        val mintemperature = intent.getIntegerArrayListExtra("mintemperature") ?: arrayListOf()
        val maxtemperature = intent.getIntegerArrayListExtra("maxtemperature") ?: arrayListOf()
        val weatherconditions = intent.getStringArrayListExtra("weatherconditions") ?: arrayListOf()

        val detailsTextView = findViewById<TextView>(R.id.detailsTextView)
        val averageTemperatureTextView = findViewById<TextView>(R.id.averageTemperatureTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        var totalScreenTime = 0
        var displayText = ""
        for (i in day.indices) {
            val dailyScreenTime = mintemperature[i] + maxtemperature[i]
            totalScreenTime += dailyScreenTime
            displayText += "Date: ${day[i]}, Morning: ${mintemperature[i]} min, Afternoon: ${maxtemperature[i]} min, Notes: ${weatherconditions[i]}\n\n"
        }
        val averageTemperature = if (day.isNotEmpty()) totalScreenTime / day.size else 0

        detailsTextView.text = displayText
        averageTemperatureTextView.text = "AverageTemperature: $averageTemperature minutes/day"

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}

