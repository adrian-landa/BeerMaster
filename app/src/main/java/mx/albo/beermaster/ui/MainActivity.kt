package mx.albo.beermaster.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import mx.albo.beermaster.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
    }

    private fun setData() {
        setSupportActionBar(toolbar)
        val navController = findNavController(R.id.host_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}