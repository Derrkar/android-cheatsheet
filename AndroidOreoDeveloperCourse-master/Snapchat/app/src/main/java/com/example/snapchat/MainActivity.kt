package com.example.snapchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    var emailTextView: EditText? = null
    var passwordEditText: EditText? = null
    /*private val mAuth = FirebaseAuth.getInstance()*/
    private lateinit var auth: FirebaseAuth
    private val database = Firebase.database.reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordEditText = findViewById(R.id.passwordEditText)
        emailTextView = findViewById(R.id.emailEditText)

        auth = Firebase.auth
        if (auth.currentUser != null) {
            logIn()
        }
        /*if (mAuth.currentUser != null) {
            logIn()
        }*/
    }

    fun goClicked(view: View) {
        // Check if we can log in user
        auth.signInWithEmailAndPassword(emailTextView?.text.toString(), passwordEditText?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    logIn()
                } else {
                    // Sign up the user
                    auth.createUserWithEmailAndPassword(emailTextView?.text.toString(), passwordEditText?.text.toString()).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Firebase.database.reference.child("users").child(task.result?.user?.uid.toString()).child("email").setValue(emailTextView?.text.toString())
                            /*database.child("users").setValue("ebanoea vagina")*/
                            logIn()
                            // add to database
                        } else {
                            Toast.makeText(this, "Login Failed, try Again!", Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        // Sigh up the user
    }

    fun logIn() {
        val intent = Intent(this, SnapsActivity::class.java)
        startActivity(intent)
        //Move to next activity
    }
}
