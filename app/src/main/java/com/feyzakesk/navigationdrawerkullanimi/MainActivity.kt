package com.feyzakesk.navigationdrawerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.feyzakesk.navigationdrawerkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Navigation Component ile Navigation Drawer Bağlantısı
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.navigationView,navHostFragment.navController)

        binding.toolbar.title = "Başlık"

        //Toolbar üzerindeki menü iconu ile Drawer'ı açma
        val toggle =
            ActionBarDrawerToggle(this,binding.drawer,binding.toolbar,0,0)
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

        val baslik = binding.navigationView.inflateHeaderView(R.layout.navigation_baslik)
        val textViewBaslik =baslik.findViewById(R.id.textViewBaslik)as TextView
        textViewBaslik.text ="Merhaba"

    }

    @Deprecated("Deprecated in Java")
    //Not : Fragmentlar açılmışsa geri tuşu önce bir önceki fragmentta dönmek için çalışır.
    //Örn : 2. Fragment açıksa önce 1. fragmenta geri döner sonra kapatır.
    override fun onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)){
            binding.drawer.closeDrawer(GravityCompat.START)
        }else{
            onBackPressedDispatcher.onBackPressed()
        }
    }

}