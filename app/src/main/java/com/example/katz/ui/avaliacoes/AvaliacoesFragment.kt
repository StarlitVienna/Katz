package com.example.katz.ui.avaliacoes

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.katz.MainActivity
import com.example.katz.R
import com.example.katz.databinding.FragmentAvaliacoesBinding

class AvaliacoesFragment : Fragment() {

    private var _binding: FragmentAvaliacoesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var materiaRowsList: ArrayList<Materia>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val avaliacoesViewModel =
            ViewModelProvider(this).get(AvaliacoesViewModel::class.java)

        _binding = FragmentAvaliacoesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*
        val textView: TextView = binding.textAvaliacoes
        avaliacoesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
         */

        val imageId = intArrayOf(
            R.drawable.port,
            R.drawable.mathic,
            R.drawable.geo,
            R.drawable.hist,
            R.drawable.physics,
            R.drawable.chem,
            R.drawable.bios,
            R.drawable.artsic,
            R.drawable.ph,
            R.drawable.socio,
            R.drawable.philo,
            R.drawable.eng
        )

        val names = arrayOf(
            "Língua Portuguesa",
            "Matemática",
            "Geografia",
            "História",
            "Física",
            "Química",
            "Biologia",
            "Artes",
            "Educação Física",
            "Sociologia",
            "Filosofia",
            "Inglês"
        )
        val pendenteDescription = arrayOf(
            "Pendentes: 2",
            "Pendentes: 3",
            "Pendentes: 1",
            "Pendentes: 0",
            "Pendentes: 3",
            "Pendentes: 5",
            "Pendentes: 0",
            "Pendentes: 7",
            "Pendentes: 8",
            "Pendentes: 1",
            "Pendentes: 7",
            "Pendentes: 2",
        )
        val corrigidasDescription = arrayOf(
            "Corrigidas: 6",
            "Corrigidas: 2",
            "Corrigidas: 7",
            "Corrigidas: 4",
            "Corrigidas: 3",
            "Corrigidas: 5",
            "Corrigidas: 3",
            "Corrigidas: 6",
            "Corrigidas: 1",
            "Corrigidas: 8",
            "Corrigidas: 3",
            "Corrigidas: 9",
        )

        materiaRowsList = ArrayList()
        for(i in names.indices) {
            val materiaRow = Materia(
                names[i],
                corrigidasDescription[i],
                pendenteDescription[i],
                imageId[i]
                )
            materiaRowsList.add(materiaRow)
        }

        binding.avaliacoeslist.isClickable = true
        binding.avaliacoeslist.adapter = MyAdapter((activity as MainActivity), materiaRowsList)

        //val listView = binding.root.findViewById<ListView>(R.id.avaliacoeslist)
        binding.avaliacoeslist.setOnItemClickListener {adapterView, view, i, l ->
            val materiaName = names[i]
            val corrigidasAmount = corrigidasDescription[i]
            val pendentesAmount = pendenteDescription[i]
            val imageId = imageId[i]
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