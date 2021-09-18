package com.example.examenkotiln1er

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentWriter.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentWriter : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_writer, container, false)


        val recivedUser = arguments?.getInt("userSesion")
        var worksCounter = 0
        println(recivedUser)

        val arrowRight = v.findViewById<ImageView>(R.id.btn_arrow_right)
        val arrowLeft = v.findViewById<ImageView>(R.id.btn_arrow_left)
        var imgWriteProfile = v.findViewById<ImageView>(R.id.img_view_writer)
        var imgWriterWork = v.findViewById<ImageView>(R.id.img_work)
        var userNickname = v.findViewById<TextView>(R.id.txt_nickname)
        var userType = v.findViewById<TextView>(R.id.txt_user_type)
        var numberOfWorks = v.findViewById<TextView>(R.id.txt_writer_articles)

        var LiteralWork1 = LiteraryWorks(1,"Zistopia","Erra una noche muy fria en donde de repente el me tomo de la mano", 0)
        var LiteralWork2 = LiteraryWorks(2,"Snape y yo", "El mastro Snape siempre me miraba con esa mirada penetranta que intimidaba a cualquie mogle", 0)
        var LiteralWork3 = LiteraryWorks(3, "Jordi el proxwneta", "Jordi se encontraba placidamente grabando su nuevo video", 0)
        var LiteralWork4 = LiteraryWorks(4, "Elsa y Jack frost", "Nuestro universos eran tan distintos pero nuestro amor era mas fuerte que eso", 0)
        var array_works:ArrayList<LiteraryWorks> = arrayListOf<LiteraryWorks>()
        array_works.add(LiteralWork1)
        array_works.add(LiteralWork2)
        array_works.add(LiteralWork3)
        array_works.add(LiteralWork4)

        var Usuario1 = Usuario(1,"a", "123","normaluser",0, R.drawable.imguser1)
        var Usuario2 = Usuario(2,"susi", "321", "writer",0,R.drawable.imguser2)
        var Usuario3 = Usuario(3,"bb","555", "normaluser",0, R.drawable.imguser3)

        val array_users:ArrayList<Usuario> = arrayListOf<Usuario>()
        array_users.add(Usuario1)
        array_users.add(Usuario2)
        array_users.add(Usuario3)

        for (i in array_users.indices){
            if (i == recivedUser){
                imgWriteProfile.setImageResource(array_users[i].ProfileImg)
                userNickname.setText(array_users[i].Username)
                userType.setText(array_users[i].UserType)
                numberOfWorks.setText(array_users[i].UserType)
            }
        }

        arrowRight.setOnClickListener{

        }

        arrowLeft.setOnClickListener{

        }

        return v
    }

    private fun loadSaved() {

    }

    private fun saveSetting() {
       // val sharedPreferences = getSharedPreferences()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentWriter.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentWriter().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}