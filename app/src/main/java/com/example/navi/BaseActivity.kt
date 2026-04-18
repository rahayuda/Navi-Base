package com.example.navi

import android.content.Intent
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    override fun setContentView(layoutResID: Int) {
        drawerLayout = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
        val container = drawerLayout.findViewById<FrameLayout>(R.id.activity_container)
        layoutInflater.inflate(layoutResID, container, true)
        super.setContentView(drawerLayout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        toggle.drawerArrowDrawable.color = resources.getColor(R.color.white, theme)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawers()

        drawerLayout.postDelayed({
            // 1. Tentukan tujuannya saja (Return Intent atau null)
            val intent = when (item.itemId) {
                R.id.nav_dashboard -> if (this !is MainActivity) Intent(this, MainActivity::class.java) else null
                R.id.nav_calculate -> if (this !is CalculateActivity) Intent(this, CalculateActivity::class.java) else null
                R.id.nav_feedback -> if (this !is FeedbackActivity) Intent(this, FeedbackActivity::class.java) else null
                else -> null
            }

            // 2. Eksekusi perpindahan halaman di satu tempat saja
            if (intent != null) {
                startActivity(intent)

                if (android.os.Build.VERSION.SDK_INT >= 34) {
                    overrideActivityTransition(OVERRIDE_TRANSITION_OPEN, 0, 0)
                } else {
                    @Suppress("DEPRECATION")
                    overridePendingTransition(0, 0)
                }
                finish()
            }
        }, 250)

        return true
    }
}