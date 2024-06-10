package za.ac.iie.weatherconditions

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private val day = ArrayList<String>()
    private val min = ArrayList<Int>()
    private val max = ArrayList<Int>()
    private val weathercondition = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val dayEditText = findViewById<EditText>(R.id.dayEditText)
        val minEditText = findViewById<EditText>(R.id.minEditText)
        val maxEditText = findViewById<EditText>(R.id.maxEditText)
        val weatherconditionsEditText = findViewById<EditText>(R.id.weatherconditionsEditText)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val viewDetailsButton = findViewById<Button>(R.id.viewDetailsButton)



        addButton.setOnClickListener {
            val day = dayEditText.text.toString()
            val min = minEditText.text.toString().toIntOrNull()
            val max = maxEditText.text.toString().toIntOrNull()
            val weatherconditions = weatherconditionsEditText.text.toString()



            if (day.isNotEmpty() && min != null && max != null && weatherconditions.isNotEmpty()) {
                forEach()
                add()
                add()
                forEach()
                Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
                clearFields(dayEditText, minEditText, maxEditText, weatherconditionsEditText)


            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
//The code that is commented out below will clear all data saved in the arraylists!
        clearButton.setOnClickListener {
            //dates.clear()
            // morningScreenTimes.clear()
            //afternoonScreenTimes.clear()
            // activityNotes.clear()
            // Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
            clearFields(dayEditText, minEditText, maxEditText, weatherconditionsEditText)



        }

        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedView::class.java)
            intent.putStringArrayListExtra("day", day)
            intent.putIntegerArrayListExtra("min", min)
            intent.putIntegerArrayListExtra("max", max)
            intent.putStringArrayListExtra("weatherconditions", weathercondition)
            startActivity(intent)
        }


    }

    private fun clearFields(vararg fields: EditText) {
        for (field in fields) {
            field.text.clear()
        }
    }
}

private fun add() {
    TODO("Not yet implemented")
}

private fun forEach() {
    TODO("Not yet implemented")
}







