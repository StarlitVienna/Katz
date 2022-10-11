package com.example.katz.ui.selfeval

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.katz.MainActivity
import com.example.katz.R
import com.example.katz.databinding.FragmentSelfevalBinding
import com.example.katz.ui.avaliacoes.Materia
import com.example.katz.ui.avaliacoes.MyAdapter
import com.example.katz.ui.selfeval.SelfevalViewModel

class SelfevalFragment : Fragment() {

    private var _binding: FragmentSelfevalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var materiaRowsList: ArrayList<Materia>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val selfevalViewModel =
            ViewModelProvider(this).get(SelfevalViewModel::class.java)

        _binding = FragmentSelfevalBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*
        val textView: TextView = binding.textSelfeval
        selfevalViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
         */

        val imageId = intArrayOf(
            R.drawable.sleep,
            R.drawable.talent,
            R.drawable.emot
        )
        val names = arrayOf(
            "Qualidade de sono",
            "Talento",
            "Emoções"
        )

        val descriptions = arrayOf(
            "É durante o sono que o organismo exerce as principais funções restauradoras do corpo, como...",
            "Talento é a inclinação e habilidade natural ou desenvolvida de uma pessoa para realizar de...",
            "Emoção é uma sensação física e emocional que é provocada por algum estímulo, que pode ser ..."
        )


        materiaRowsList = ArrayList()
        for(i in names.indices) {
            val materiaRow = Materia(
                names[i],
                descriptions[i],
                "",
                imageId[i]
            )
            materiaRowsList.add(materiaRow)
        }

        binding.selflist.isClickable = true
        binding.selflist.adapter = MyAdapter((activity as MainActivity), materiaRowsList)

        //val listView = binding.root.findViewById<ListView>(R.id.avaliacoeslist)
        binding.selflist.setOnItemClickListener {adapterView, view, i, l ->
            Toast.makeText(binding.root.context, names[i] + " está em manutenção", Toast.LENGTH_LONG)
                .show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}