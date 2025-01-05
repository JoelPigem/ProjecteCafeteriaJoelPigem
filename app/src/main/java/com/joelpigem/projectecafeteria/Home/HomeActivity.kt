package com.joelpigem.projectecafeteria.Home

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.joelpigem.projectecafeteria.R
import com.joelpigem.projectecafeteria.databinding.ActivityHomeBinding
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.joelpigem.projectecafeteria.databinding.ActivityMainBinding
import androidx.fragment.app.activityViewModels
import com.joelpigem.projectecafeteria.UsersModel

class HomeActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var appBarConfig: AppBarConfiguration
    private val sharedViewModel: ShareViewModel by viewModels()

    val keyNom = "nom_key"
    val keyMail = "mail_key"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = intent

        val nomUsuari = intent.getStringExtra(keyNom)
        val mailUsuari = intent.getStringExtra(keyMail)

        val headerNom = binding.navView.getHeaderView(0).findViewById<TextView>(R.id.header_nom)
        val headerMail = binding.navView.getHeaderView(0).findViewById<TextView>(R.id.header_mail)

        headerNom.text = nomUsuari.toString()
        headerMail.text = mailUsuari.toString()

        //BOTTOM NAVIGATION --

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController



        binding.bottomNAvigationView.setupWithNavController(navController)


        binding.navView.setupWithNavController(navController)





        //NAVIGATION DRAWER AMB ACTIONBAR
        drawerLayout = binding.drawerLayout
        toolbar= binding.toolbar



        //The given Activity will be linked to the specified DrawerLayout and
        // its Actionbar's Up button will be set to a custom drawable.
        //This drawable shows a Hamburger icon when drawer is closed and an arrow when drawer is open.
        // It animates between these two states as the drawer opens.
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, R.string.nav_open, R.string.nav_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        appBarConfig = AppBarConfiguration.Builder(R.id.menjarsFragment)
            //appBarConfig = AppBarConfiguration.Builder(R.id.fragmentInici, R.id.fragmentFinal, R.id.boatFragment)
            .setDrawerLayout(drawerLayout)
            .build()

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        setupActionBarWithNavController(this, navController, appBarConfig)

    }

    override fun onSupportNavigateUp(): Boolean {
        // replace navigation up button with nav drawer button when on start destination
        return NavigationUI.navigateUp(navController, appBarConfig)

    }

}