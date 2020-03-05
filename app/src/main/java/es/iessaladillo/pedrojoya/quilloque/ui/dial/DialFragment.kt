package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import es.iessaladillo.pedrojoya.quilloque.R
import kotlinx.android.synthetic.main.dial_fragment.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.main_activity.*

class DialFragment: Fragment(R.layout.dial_fragment) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        setupBottomNavigationView()
        setupBtns()
    }

    private fun setupBtns() {
        val number = StringBuilder()
        lblOne.setOnClickListener { lblNumber.text = number.append("1")}
        lblTwo.setOnClickListener { lblNumber.text = number.append("2") }
        lblThree.setOnClickListener { lblNumber.text = number.append("3") }
        lblFour.setOnClickListener { lblNumber.text = number.append("4") }
        lblFive.setOnClickListener { lblNumber.text = number.append("5") }
        lblSix.setOnClickListener { lblNumber.text = number.append("6") }
        lblSeven.setOnClickListener { lblNumber.text = number.append("7") }
        lblEight.setOnClickListener { lblNumber.text = number.append("8") }
        lblNine.setOnClickListener { lblNumber.text = number.append("9") }
        lblAstherisc.setOnClickListener { lblNumber.text = number.append("*") }
        lblZero.setOnClickListener { lblNumber.text = number.appendappend("#") }
    }

    private fun setupBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            navigateToOption(it)
            true
        }
    }

    private fun navigateToOption(item: MenuItem) {
        when (item.itemId) {
            R.id.mnuDial -> findNavController().navigate(R.id.dialFragment)
            R.id.mnuRecent -> findNavController().navigate(R.id.recentDestination)
            R.id.mnuContacts -> findNavController().navigate(R.id.contactDestination)
        }
    }


}