package es.iessaladillo.pedrojoya.quilloque

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import es.iessaladillo.pedrojoya.quilloque.ui.contacts.ContactsFragment
import es.iessaladillo.pedrojoya.quilloque.ui.dial.DialFragment
import es.iessaladillo.pedrojoya.quilloque.ui.recents.RecentFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupViews()
    }

    private fun setupViews() {
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
        toolbar.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            title = destination.label
        }
    }



}
