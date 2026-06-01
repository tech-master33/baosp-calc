package org.baosp.calc

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.Locale

class CalcActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var tts: TextToSpeech? = null
    private val expr = StringBuilder()
    private var hasResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        display = findViewById(R.id.tv_display)
        tts = TextToSpeech(this) { if (it == TextToSpeech.SUCCESS) tts?.language = Locale.getDefault() }
        val nums = mapOf(
            R.id.btn_0 to "0", R.id.btn_1 to "1", R.id.btn_2 to "2",
            R.id.btn_3 to "3", R.id.btn_4 to "4", R.id.btn_5 to "5",
            R.id.btn_6 to "6", R.id.btn_7 to "7", R.id.btn_8 to "8",
            R.id.btn_9 to "9", R.id.btn_dot to "."
        )
        nums.forEach { (id, v) -> findViewById<Button>(id).setOnClickListener { append(v) } }
        findViewById<Button>(R.id.btn_add).setOnClickListener { append("+") }
        findViewById<Button>(R.id.btn_subtract).setOnClickListener { append("-") }
        findViewById<Button>(R.id.btn_multiply).setOnClickListener { append("*") }
        findViewById<Button>(R.id.btn_divide).setOnClickListener { append("/") }
        findViewById<Button>(R.id.btn_equals).setOnClickListener { calculate() }
        findViewById<Button>(R.id.btn_clear).setOnClickListener { clear() }
        findViewById<Button>(R.id.btn_delete).setOnClickListener { delete() }
        findViewById<Button>(R.id.btn_percent).setOnClickListener { append("%") }
    }

    private fun append(v: String) {
        if (hasResult) { expr.clear(); hasResult = false }
        expr.append(v); display.text = expr.toString(); speak(v)
    }

    private fun calculate() {
        if (expr.isEmpty()) return
        try {
            val r = ExpressionBuilder(expr.toString().replace("%", "/100")).build().evaluate()
            val s = if (r == r.toLong().toDouble()) r.toLong().toString() else String.format("%.4f", r).trimEnd('0').trimEnd('.')
            display.text = s; expr.clear(); expr.append(s); hasResult = true
            speak("Result: $s")
        } catch (_: Exception) { display.text = "Error"; speak("Error"); expr.clear() }
    }

    private fun clear() { expr.clear(); hasResult = false; display.text = "0"; speak("Cleared") }

    private fun delete() {
        if (expr.isNotEmpty()) { expr.deleteCharAt(expr.length - 1); display.text = expr.toString().ifEmpty { "0" }; speak("Deleted") }
    }

    private fun speak(text: String) { tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null) }

    override fun onDestroy() { tts?.stop(); tts?.shutdown(); super.onDestroy() }
}
