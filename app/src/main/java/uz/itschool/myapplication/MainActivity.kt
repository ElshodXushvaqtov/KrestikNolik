package uz.itschool.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

var bool = true
var matrix = Array(3) { IntArray(3) { -1 } }
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linear1image1.setOnClickListener(this)
        linear1image2.setOnClickListener(this)
        linear1image3.setOnClickListener(this)
        linear2image1.setOnClickListener(this)
        linear2image2.setOnClickListener(this)
        linear2image3.setOnClickListener(this)
        linear3image1.setOnClickListener(this)
        linear3image2.setOnClickListener(this)
        linear3image3.setOnClickListener(this)
        active_player.text = "Player X"
        fun restart() {
            linear1image1.isEnabled = true
            linear1image2.isEnabled = true
            linear1image3.isEnabled = true
            linear2image1.isEnabled = true
            linear2image2.isEnabled = true
            linear2image3.isEnabled = true
            linear3image1.isEnabled = true
            linear3image2.isEnabled = true
            linear3image3.isEnabled = true

            linear1image1.setImageDrawable(null)
            linear1image2.setImageDrawable(null)
            linear1image3.setImageDrawable(null)
            linear2image1.setImageDrawable(null)
            linear2image2.setImageDrawable(null)
            linear2image3.setImageDrawable(null)
            linear3image1.setImageDrawable(null)
            linear3image2.setImageDrawable(null)
            linear3image3.setImageDrawable(null)
            active_player.text = "Player X"
        }
        restart.setOnClickListener {
            restart()
        }

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view: View?) {

        val image = findViewById<ImageView>(view!!.id)
        var tag = image.tag.toString().toInt()
        var col: Int = tag / 3
        var row: Int = tag % 3

        fun finishGame() {
            linear1image1.isEnabled = false
            linear1image2.isEnabled = false
            linear1image3.isEnabled = false
            linear2image1.isEnabled = false
            linear2image2.isEnabled = false
            linear2image3.isEnabled = false
            linear3image1.isEnabled = false
            linear3image2.isEnabled = false
            linear3image3.isEnabled = false
            restart.visibility = View.VISIBLE
        }
        fun isWinner(p: Int) {
            var count = 0
            for (i in 0..2) {
                for (j in 0..2) {
                    if (matrix[i][j] == p) {
                        count++
                    }
                }
                if (count == 3) {
                    winner.text = "Winner is $p"
                    finishGame()
                    return
                }
                count = 0
            }
            count = 0
            for (i in 0..2) {
                for (j in 0..2) {
                    if (i == j) {
                        if (matrix[i][j] == p) {
                            count++
                        }
                    }
                }
                if (count == 3) {
                    winner.text = "Winner is $p"
                    finishGame()
                    return
                }
            }
            count = 0
            for (i in 0..2) {
                for (j in 0..2) {
                    if (i + j == 2) {
                        if (matrix[i][j] == p) {
                            count++
                        }
                    }
                }
                if (count == 3) {
                    winner.text = "Winner is $p"
                    finishGame()
                    return
                }
            }
            count = 0
            for (i in 0..2) {
                for (j in 0..2) {
                    if (matrix[j][i] == p) {
                        count++
                    }
                }
                if (count == 3) {
                    winner.text = "Winner is $p"
                    finishGame()
                    return
                }
                count = 0
            }
        }
        if (matrix[col][row] == -1) {
            if (bool) {
                image.setImageResource(R.drawable.krestik)
                bool = false
                matrix[col][row] = 1
                active_player.text = "Player-O"
                isWinner(1)
            } else {
                image.setImageResource(R.drawable.nolik)
                bool = true
                matrix[col][row] = 0
                active_player.text = "Player-X"
                isWinner(0)
            }
        }




    }
}

