
package kg.geektech.kotlinlesson1
//Дз: На первой активити добавить EditText + Button,
// при вводе если значения в editText пустое и вы нажали на button,
// то отобразить Toast, что EditText не может быть пустым,
// иначе Перейти на вторую активити и отобразить значение в EditText,
// также добавить Button, если EditText не пуст, то вернуться на 1 активити и
// отобразить текст из 2 активити.(использовать registerForActivity)
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlinlesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val startActivityForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK && it.data != null){
            val data = it.data?.getStringExtra("key1")
            binding.etText.setText(data)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        btnSend()

    }

    private fun btnSend() {
        binding.btnSend.setOnClickListener(View.OnClickListener {
            if (binding.etText.text.toString().isEmpty()) {
                Toast.makeText(this, "Empty field not allowed!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                val etText = binding.etText.text.toString()
                intent.putExtra("key1", etText)
                startActivityForResult.launch(intent)
            }
        })

    }
    }

