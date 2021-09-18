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
 * Use the [FragmentUser.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentUser : Fragment() {
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
        var counterWorks = 0
        val v = inflater.inflate(R.layout.fragment_user, container, false)
        val recivedUser = arguments?.getInt("userSesion")
        println(recivedUser)
        val btnRight = v.findViewById<ImageView>(R.id.btn_arrow_right)
        val btnLeft = v.findViewById<ImageView>(R.id.btn_arrow_left)
        val btnLike = v.findViewById<ImageView>(R.id.btn_like)
        var imgLiteraryWork = v.findViewById<ImageView>(R.id.img_view_item)
        var imgUserProfile = v.findViewById<ImageView>(R.id.imageView_User)
        var dataNickname = v.findViewById<TextView>(R.id.txt_nickname)
        var dataUserType = v.findViewById<TextView>(R.id.txt_user_type)
        var dataLiked = v.findViewById<TextView>(R.id.txt_liked_writes)
        println(recivedUser)

        var LiteralWork1 = LiteraryWorks(1,"Zistopia","Erra una noche muy fria en donde de repente el me tomo de la mano", 0,R.drawable.article1)
        var LiteralWork2 = LiteraryWorks(2,"Snape y yo", "El mastro Snape siempre me miraba con esa mirada penetranta que intimidaba a cualquie mogle", 0,R.drawable.article2)
        var LiteralWork3 = LiteraryWorks(3, "Jordi el proxwneta", "Jordi se encontraba placidamente grabando su nuevo video", 0, R.drawable.article3)
        var LiteralWork4 = LiteraryWorks(4, "Elsa y Jack frost", "Nuestro universos eran tan distintos pero nuestro amor era mas fuerte que eso", 0, R.drawable.article4)
        var array_works:ArrayList<LiteraryWorks> = arrayListOf<LiteraryWorks>()
        array_works.add(LiteralWork1)
        array_works.add(LiteralWork2)
        array_works.add(LiteralWork3)
        array_works.add(LiteralWork4)

        var Usuario1 = Usuario(1,"a", "123","normaluser",0, R.drawable.imguser1)
        var Usuario2 = Usuario(2,"susi", "321", "writer",0,R.drawable.imguser2)
        var Usuario3 = Usuario(3,"bb","555", "normaluser",0, R.drawable.imguser3)
        var array_users:ArrayList<Usuario> = arrayListOf<Usuario>()
        array_users.add(Usuario1)
        array_users.add(Usuario2)
        array_users.add(Usuario3)

        for (i in array_users.indices){
            if (recivedUser == i){
                dataNickname.setText(array_users[i].Username)
                dataUserType.setText(array_users[i].UserType)
                dataLiked.setText(array_users[i].Liked.toString())
                imgUserProfile.setImageResource(array_users[i].ProfileImg)
            }
        }

        val bundle = Bundle()

        imgLiteraryWork.setOnClickListener{
            val fragment = FragmentUserLecture()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
            fragmentTransaction.addToBackStack(null)
            bundle.putInt("literaryWorkRead", counterWorks)
            fragment.arguments = bundle

            fragmentTransaction.commit()
        }

        btnRight.setOnClickListener{
            counterWorks++
            println(counterWorks)
            if (counterWorks == 0 ){
                imgLiteraryWork.setImageResource(R.drawable.article1)
            }else if (counterWorks ==1){
                imgLiteraryWork.setImageResource(R.drawable.article2)
            }else if (counterWorks == 2){
                imgLiteraryWork.setImageResource(R.drawable.article3)
            }else if (counterWorks == 3){
                imgLiteraryWork.setImageResource(R.drawable.article4)
                counterWorks = -1
            }
        }

        btnLeft.setOnClickListener{
            counterWorks--
            println(counterWorks)
            if (counterWorks <= 0){
                imgLiteraryWork.setImageResource(R.drawable.article1)
                counterWorks = 4
            }else if (counterWorks ==1){
                imgLiteraryWork.setImageResource(R.drawable.article2)
            }else if (counterWorks == 2){
                imgLiteraryWork.setImageResource(R.drawable.article3)
            }else if (counterWorks == 3){
                imgLiteraryWork.setImageResource(R.drawable.article4)
            }

        }

        var like_cheked = false
        btnLike.setOnClickListener{
            if (!like_cheked){
                like_cheked = true
                btnLike.setImageResource(R.drawable.heart)
            }else{
                like_cheked = false
                btnLike.setImageResource(R.drawable.emptyheart)
            }


        }

        return v
    }

    private fun saveLikes() {

    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentUser.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentUser().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}