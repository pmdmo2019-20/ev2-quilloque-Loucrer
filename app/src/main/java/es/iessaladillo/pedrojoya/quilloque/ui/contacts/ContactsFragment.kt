package es.iessaladillo.pedrojoya.quilloque.ui.contacts

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.R
import es.iessaladillo.pedrojoya.quilloque.data.AppDatabase
import es.iessaladillo.pedrojoya.quilloque.data.models.Contact
import kotlinx.android.synthetic.main.contacts_fragment.*

class ContactsFragment: Fragment(R.layout.contacts_fragment) {

    private lateinit var listAdapter: ContactAdapter

    private val viewmodel: ContactViewModel by viewModels {
        ContactViewModelFactory(
            AppDatabase.getInstance
                (this.requireContext()).contactsDao ,requireActivity().application)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
        setupAdapter()
        setupRecyclerView()
        setupBtns()
        observes()
    }

    private fun setupBtns() {
        // El intento de hacerlo con dataBinding
/*        viewmodel.run {
            listCurrentCalls.observe(viewLifecycleOwner){listaContacto  ->
                if ( listaContacto.isNotEmpty()){
                    emptyView.visibility = View.INVISIBLE
                    showAgenda(listaContacto)
                } else {
                    Toast.makeText(requireContext(),"Lista Vacia", Toast.LENGTH_LONG).show()
                }
            }
        }*/
    }

    private fun observes() {
        viewmodel.run {
            listCalls.observe(viewLifecycleOwner){agenda ->
                if (agenda.isNotEmpty()){
                    emptyView.visibility = View.INVISIBLE
                    showAgenda(agenda)
                } else {
                    Toast.makeText(requireContext(),"Lista Vacia", Toast.LENGTH_LONG).show()
                }
            }
        }
        viewmodel.message.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(),it.getContentIfNotHandled(), Toast.LENGTH_LONG).show()
        }
    }

    private fun showAgenda(agenda: List<Contact>) {
            listAdapter.submitList(agenda)
    }

    private fun setupRecyclerView() {
        lstContacts.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }    }

    private fun setupAdapter() {
        listAdapter = ContactAdapter(activity!!.application)
    }

    private fun setupViews() {

    }

}