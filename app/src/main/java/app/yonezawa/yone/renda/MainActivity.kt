package app.yonezawa.yone.renda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    //残りの秒数を10秒にセット
    var second = 10
    //タップを数える変数を準備する
    var tapCount = 0
    //タイマーを設定する
    val timer : CountDownTimer = object : CountDownTimer(10000,1000) {
        //タイマーが終了するときによばれる
        override fun onFinish() {
            //STARTボタンを見える状態にする
            tapButton.isVisible = true
            //TAPボタンを灰色にセットする
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle_glay)
            //残り秒数10秒をに戻す
            second = 10
            //タップを数える変数を0に戻す
            tapCount = 0
        }

        //一秒ごとによばれる
        override fun onTick(millisUntiFinished: Long) {

            //TAPボタンをピンク色にセット
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle)
            //残りの秒数にマイナス1する
            second = second - 1
            //残り数字をテキストビューに反映する
            secondText.text = second.toString()
        }
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //スタートボタンがタップされたときに
        startButton.setOnClickListener {
            //タップされた数をテキストビューに反映する
            countText.text = tapCount.toString()
            //STARTボタンをみえない状態にする
            startButton.isVisible = false

            //タイマーを開始する
            timer.start()
        }

        var countText: TextView = findViewById<TextView>(R.id.countText)
        var tapLabelText: TextView = findViewById<TextView>(R.id.tapLabelText)
        var startButton: Button = findViewById<Button>(R.id.startButton)
        var tapButton: Button = findViewById<Button>(R.id.tapButton)
        var secondText: TextView = findViewById<TextView>(R.id.secondText)

        //ボタンがタップされた時に
        tapButton.setOnClickListener {
            //残りの秒数が10秒より少ない時に
            if (second < 10) {
                //タップを数える変数にプラス1にする
                tapCount = tapCount + 1
                //タップされた数をテキストビューに反映する
                countText.text = tapCount.toString()

            }
        }
    }
}




