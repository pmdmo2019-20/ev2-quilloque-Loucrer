package es.iessaladillo.pedrojoya.quilloque.ui.dial

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import es.iessaladillo.pedrojoya.quilloque.R
import kotlinx.android.synthetic.main.dial_fragment.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.quilloque.data.AppDatabase
import es.iessaladillo.pedrojoya.quilloque.data.pojos.CallWithContact
import kotlinx.android.synthetic.main.main_activity.*

class DialFragment: Fragment(R.layout.dial_fragment) {


    private lateinit var listAdapter: DialAdapter

    private val viewmodel: DialViewModel by viewModels {
        DialViewModelFactory(
            AppDatabase.getInstance
                (this.requireContext()).callsDao ,requireActivity().application)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
        setupAdapter()
        setupRecyclerView()
        observes()
    }

    private fun observes() {
        viewmodel.run {
            listCalls.observe(viewLifecycleOwner) { llamadas ->
                if(llamadas.isNotEmpty()){
                    lblCreateContact.visibility = View.INVISIBLE
                    showAgenda(llamadas)
                } else {
                    Toast.makeText(requireContext(),"Lista Vacia", Toast.LENGTH_LONG).show()
                }
            }

            message.observe(viewLifecycleOwner){
                Toast.makeText(requireContext(),it.getContentIfNotHandled(), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun showAgenda(llamadas: List<CallWithContact>) {
        listAdapter.submitList(llamadas)
    }

    private fun setupRecyclerView() {
        lstSuggestions.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }
    }

    private fun setupAdapter() {
        listAdapter = DialAdapter(activity!!.application)
    }

    private fun setupViews() {
        setupBtns()
    }

    private fun setupBtns() {
        val number = StringBuilder()
        lblOne.setOnClickListener { lblNumber.text = number.append("1"); viewmodel.sugestionCall(lblNumber.text.toString())}
        lblTwo.setOnClickListener { lblNumber.text = number.append("2"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblThree.setOnClickListener { lblNumber.text = number.append("3"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblFour.setOnClickListener { lblNumber.text = number.append("4"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblFive.setOnClickListener { lblNumber.text = number.append("5"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblSix.setOnClickListener { lblNumber.text = number.append("6"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblSeven.setOnClickListener { lblNumber.text = number.append("7"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblEight.setOnClickListener { lblNumber.text = number.append("8"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblNine.setOnClickListener { lblNumber.text = number.append("9"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblAstherisc.setOnClickListener { lblNumber.text = number.append("*"); viewmodel.sugestionCall(lblNumber.text.toString()) }
        lblZero.setOnClickListener { lblNumber.text = number.append("#"); viewmodel.sugestionCall(lblNumber.text.toString()) }
    }




}