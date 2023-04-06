package edu.temple.viewpagerinclasssctivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private val newButton : Button by lazy{
        findViewById(R.id.button)
    }

    private val viewPager2 : ViewPager2 by lazy{
        findViewById(R.id.viewPager)
    }

    var numberOfPages = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newButton.setOnClickListener{
            numberOfPages++
            viewPager2.adapter?.notifyItemInserted(numberOfPages -1)
            viewPager2.setCurrentItem(numberOfPages, false)

        }

        viewPager2.adapter = object: FragmentStateAdapter(this) {
            override fun getItemCount() = numberOfPages

            override fun createFragment(position: Int) = TextFragment.newInstance((position + 1).toString())
        }
    }
}