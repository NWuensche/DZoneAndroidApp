package greeting.dzone.app.niklas.greeting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        fun greeting(firstName: String, lastName: String): String {
            if(firstName.isEmpty() || lastName.isEmpty()) {
                return ""
            }
            return "Hello $firstName $lastName!"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageButton.setOnClickListener {
            messageView.text = greeting(firstNameView.text.toString(), lastNameView.text.toString())
            if(messageView.text.isEmpty()) {
                val toast = Toast.makeText(applicationContext, "You forgot to write your full name!", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

    }

}
