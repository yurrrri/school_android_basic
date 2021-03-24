package ddwucom.mobile.exam01

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var editText: EditText
    var button: Button!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)


        button.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, SubActivity::class.java)
            intent.putExtra("text", editText.getText().toString())
            startActivity(intent)
        })
    }
}