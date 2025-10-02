package edu.temple.activities

import android.content.Intent
import android.content.pm.LauncherApps
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value


    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)


        val get = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                var data: Intent? = it.data
                val value: Float? = data?.getFloatExtra("size", 10.0F)
                lyricsDisplayTextView.setTextSize(value?.toFloat() ?: 10.0F)
            }

        }

        textSizeSelectorButton.setOnClickListener { view ->
            val intent = Intent(this@DisplayActivity, TextSizeActivity::class.java)

            get.launch(intent)

        }

    }
}


