package com.example.katz.ui.atividades


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
import com.example.katz.databinding.FragmentAtividadesBinding
import com.example.katz.ui.atividades.AtividadesViewModel
import com.example.katz.ui.avaliacoes.Materia
import com.example.katz.ui.avaliacoes.MyAdapter

class AtividadesFragment: Fragment() {

    private var _binding: FragmentAtividadesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var materiaRowsList: ArrayList<Materia>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val aboutViewModel =
            ViewModelProvider(this).get(AtividadesViewModel::class.java)

        _binding = FragmentAtividadesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*
        val textView: TextView = binding.textAtividades
        aboutViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
         */
        val names = arrayOf(
            "Função exponencial",
            "Geometria plana",
            "Ciclo molecular",
            "Tração"
        )
        val firstDescription = arrayOf(
            "Função Exponencial é aquela que...",
            "A geometria plana é a área da m...",
            "O ciclo celular é o conjunto de...",
            "A tração é uma força de contato..."
        )
        val secondDescription = arrayOf(
            "Tempo restante --> 2 dias",
            "Tempo restante --> 1 dia",
            "Tempo restante --> 7 dias",
            "Tempo restante --> 4 dias",
        )

        val imageId = intArrayOf(
            R.drawable.mathic,
            R.drawable.mathic,
            R.drawable.bios,
            R.drawable.physics,
        )

        materiaRowsList = ArrayList()
        for(i in names.indices) {
            val materiaRow = Materia(
                names[i],
                firstDescription[i],
                secondDescription[i],
                imageId[i]
            )
            materiaRowsList.add(materiaRow)
        }

        binding.atividadeslist.isClickable = true
        binding.atividadeslist.adapter = MyAdapter((activity as MainActivity), materiaRowsList)

        //val listView = binding.root.findViewById<ListView>(R.id.avaliacoeslist)
        binding.atividadeslist.setOnItemClickListener {adapterView, view, i, l ->
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
