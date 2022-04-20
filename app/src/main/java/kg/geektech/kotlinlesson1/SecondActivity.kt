package kg.geektech.kotlinlesson1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kg.geektech.kotlinlesson1.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object{
        val KEY = "key1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent.hasExtra(KEY)) {
            setContent()
        }
        btnSend()


    }
    private fun setContent() {
        binding.etText2.setText(intent.getStringExtra(KEY).toString())
    }

    private fun btnSend() {
        binding.btnSend2.setOnClickListener(View.OnClickListener {
            if (TextUtils.isEmpty(binding.etText2.text.toString())) {
                Toast.makeText(this, (R.string.error), Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                val etText = binding.etText2.text.toString()
                intent.putExtra(KEY, etText)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        })
    }




}