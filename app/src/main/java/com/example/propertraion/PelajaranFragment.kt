package com.example.propertraion

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.propertraion.databinding.FragmentPelajaranBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PelajaranFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PelajaranFragment : Fragment() {
//     TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    private lateinit var listViewAdapter: ExpandableListAdapter
    private lateinit var babList: List<String>
    private lateinit var subBabList: HashMap<String, List<String>>
    private var _binding: FragmentPelajaranBinding? = null
    private val binding get() = _binding!!
//    private var adapter: ExpandableListAdapter? = null
//    private var titleList: List<String>? = null

//    val bab: HashMap<String, List<String>>
//        get(){
//            val listBab = HashMap<String, List<String>>()
//
//            val bab1 = ArrayList<String>()
//            bab1.add("Introduction")
//            bab1.add("Profil Pengajar")
//            bab1.add("Variabel, Tipe Data, dan Operator")
//            bab1.add("Fungsi, Method, dan Exception Handling")
//            bab1.add("Rangkuman Topik")
//            bab1.add("Kuis Topik 1")
//
//            val bab2 = ArrayList<String>()
//            val bab3 = ArrayList<String>()
//            val bab4 = ArrayList<String>()
//
//            listBab["1. Java Basics"] = bab1
//            listBab["2. Object Oriented Programming"] = bab2
//            listBab["3. Java Advanced"] = bab3
//            listBab["4. Post test"] = bab4
//
//            return listBab
//
//        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_pelajaran, container, false)
        _binding = FragmentPelajaranBinding.inflate(inflater, container, false)
        val view = binding.root
        showList()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        listViewAdapter = CustomExpandableListAdapter(requireContext(),babList,subBabList)
        binding.eListView.setAdapter(listViewAdapter)
        binding.eListView.setGroupIndicator(null)

        binding.eListView.setOnChildClickListener { _, _, babPosition, childPosition, _ ->
            val selected = listViewAdapter.getChild(babPosition, childPosition)
            val intent: Intent

            when (selected){
                "Introduction" -> {
                    intent = Intent(requireContext(), VideoPlayerActivity::class.java)
                    startActivity(intent)
                }
            }

            Toast.makeText(
                requireContext(),
                "Clicked: " + (babList as ArrayList<String>)[babPosition] + " -> " + subBabList[(
                        babList as
                                ArrayList<String>
                        )
                        [babPosition]]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    }

    private fun showList(){
        babList = ArrayList()
        subBabList = HashMap()
        (babList as ArrayList<String>).add("1. Java Basics")
        (babList as ArrayList<String>).add("2. Object Oriented Programming")
        (babList as ArrayList<String>).add("3. Java Advanced")
        (babList as ArrayList<String>).add("4. Post test")

        val subBab1: MutableList<String> = ArrayList()
        subBab1.add("Introduction")
        subBab1.add("Profil Pengajar")
        subBab1.add("Variabel, Tipe Data, dan Operator")
        subBab1.add("Fungsi, Method, dan Exception Handling")
        subBab1.add("Rangkuman Topik")
        subBab1.add("Kuis Topik 1")

        val subBab2: MutableList<String> = ArrayList()
        subBab2.add("2.1")
        subBab2.add("2.2")
        val subBab3: MutableList<String> = ArrayList()
        subBab3.add("3.1")
        subBab3.add("3.2")
        val subBab4: MutableList<String> = ArrayList()
        subBab4.add("4.1")
        subBab4.add("4.2")

        subBabList[babList[0]] = subBab1
        subBabList[babList[1]] = subBab2
        subBabList[babList[2]] = subBab3
        subBabList[babList[3]] = subBab4
    }




//        companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment PelajaranFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            PelajaranFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}