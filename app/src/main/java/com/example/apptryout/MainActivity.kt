package com.example.apptryout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.apptryout.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var navigationController: NavController
    lateinit var binding: ActivityMainBinding

    private val prefs: UserSession by lazy {
        UserSession(App.instance)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationController =  this.findNavController(R.id.navHostFragment)

        if (prefs.loggedIn){
            navigationController.navigate(R.id.homeFragment)
        }else{
            navigationController.navigate(R.id.loginFragment)
        }

    }


}