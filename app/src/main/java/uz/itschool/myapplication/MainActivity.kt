package uz.itschool.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

var bool = true

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var image1 = findViewById<ImageView>(R.id.linear1image1).setOnClickListener(this)
        var image2 = findViewById<ImageView>(R.id.linear1image2).setOnClickListener(this)
        var image3 = findViewById<ImageView>(R.id.linear1image3).setOnClickListener(this)
        var image4 = findViewById<ImageView>(R.id.linear2image1).setOnClickListener(this)
        var image5 = findViewById<ImageView>(R.id.linear2image2).setOnClickListener(this)
        var image6 = findViewById<ImageView>(R.id.linear2image3).setOnClickListener(this)
        var image7 = findViewById<ImageView>(R.id.linear3image1).setOnClickListener(this)
        var image8 = findViewById<ImageView>(R.id.linear3image2).setOnClickListener(this)
        var image9 = findViewById<ImageView>(R.id.linear3image3).setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val image = findViewById<ImageView>(view!!.id)
        if (image.drawable != null) return
        bool = if (bool) {
            image.setImageResource(R.drawable.krestik)
            false
        } else {
            image.setImageResource(R.drawable.nolik)
            true
        }

    }
}

