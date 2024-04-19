package ru.ecutula.fragmenttest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonA = findViewById<MaterialButton>(R.id.addA)
        val buttonAReplace = findViewById<MaterialButton>(R.id.replaceA)
        val buttonB = findViewById<MaterialButton>(R.id.addB)
        val buttonC = findViewById<MaterialButton>(R.id.addC)
        val buttonCNoBack = findViewById<MaterialButton>(R.id.addCNoBack)
        val buttonReplaceC = findViewById<MaterialButton>(R.id.replaceC)
        val buttonback = findViewById<MaterialButton>(R.id.back)

buttonback.setOnClickListener {
    //onBackPressed()
        supportFragmentManager.popBackStack()
}

        buttonA.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, AFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }
        buttonAReplace.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, AFragment::class.java, null)
                //.addToBackStack(null)
                .commit()
        }
        buttonB.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, BFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }

        buttonC.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, CFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }
        buttonCNoBack.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, CFragment::class.java, null)
                .commit()
        }
        buttonReplaceC.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, CFragment::class.java, null)
                .addToBackStack(null)
                .commit()
        }
    }
}