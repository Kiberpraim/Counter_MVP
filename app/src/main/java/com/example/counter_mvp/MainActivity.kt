package com.example.counter_mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.counter_mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    var presenter = Injector.getPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers();
    }

    private fun initClickers() {
        with(binding) {
            btnIncrement.setOnClickListener {
                presenter.increment()
            }
            btnDecrement.setOnClickListener {
                presenter.decrement()
            }
            btnTheme.setOnClickListener {
                presenter.theme()
            }
        }
    }

    override fun showCount(count: Int) {
        binding.tvCounter.text = count.toString()
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun darkTheme() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        binding.tvCounter.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    override fun lightTheme() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        binding.tvCounter.setTextColor(ContextCompat.getColor(this, R.color.black))
    }

    override fun setGreenColor() {
        binding.tvCounter.setTextColor(ContextCompat.getColor(this, R.color.green))
    }

}