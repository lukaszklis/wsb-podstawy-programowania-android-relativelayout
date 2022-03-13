package pl.klis.relativelayoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val ENTERED_NAME_MESSAGE = "pl.klis.relativelayoutapp.ENTERED_NAME_MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            handleSubmit()
        }
    }

    private fun handleSubmit() {
        val firstNameInput = findViewById<EditText>(R.id.firstNameInput)
        val lastNameInput = findViewById<EditText>(R.id.lastNameInput)
        val firstName = firstNameInput.text.toString()
        val lastName = lastNameInput.text.toString()

        if (firstName.isEmpty() || lastName.isEmpty()) {
            showWarning()
        } else {
            greetUser(firstName, lastName)
        }
    }

    private fun greetUser(firstName: String, lastName: String) {
        val intent = Intent(this, DisplayFullNameActivity::class.java).apply {
            putExtra(ENTERED_NAME_MESSAGE, "$firstName $lastName")
        }

        startActivity(intent)
    }

    private fun showWarning() {
        Toast
            .makeText(this@MainActivity, getString(R.string.name_input_warning), Toast.LENGTH_LONG)
            .show()
    }
}