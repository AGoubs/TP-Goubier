package com.goubier.movie.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.goubier.movie.R
import com.goubier.movie.presentation.bookmark.BookmarkFragment
import com.goubier.movie.presentation.detail.DetailFragment
import com.goubier.movie.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private var container2: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        container2 = findViewById(R.id.fragment_container2)

        supportFragmentManager.commit {
            add(R.id.fragment_container, SearchFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_bookmark) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, BookmarkFragment())
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun displayMovieDetail(id: String) {

        if (container2 != null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container2, DetailFragment.newInstance(id))
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, DetailFragment.newInstance(id))
                addToBackStack(null)
            }
        }
    }
}