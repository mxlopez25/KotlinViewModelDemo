package dev.codedark.kotlinviewmodeldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dev.codedark.kotlinviewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.tvFirstNumber.text = viewModel.number1.toString()
        binding.tvSecondNumber.text = viewModel.number2.toString()

        binding.btnAddFirstNumber.setOnClickListener {
            viewModel.addFirstNumber()
            binding.tvFirstNumber.text = viewModel.number1.toString()
        }

        binding.btnAddSecondNumber.setOnClickListener {
            viewModel.addSecondNumber()
            binding.tvSecondNumber.text = viewModel.number2.toString()
        }

        binding.btnSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("FIRST_NUMBER", viewModel.number1)
            intent.putExtra("SECOND_NUMBER", viewModel.number2)
            startActivity(intent)
        }

        viewModel.total.observe(this, Observer {
            binding.txtTotal.text = it.toString()
        })

    }
}