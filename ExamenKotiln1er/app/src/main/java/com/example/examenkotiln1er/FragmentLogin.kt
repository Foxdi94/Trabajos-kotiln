package com.example.examenkotiln1er

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast
import com.google.gson.Gson
import org.w3c.dom.Text as Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLogin.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLogin : Fragment() {
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

        val v = inflater.inflate(R.layout.fragment_login, container, false)

        /*var gson = Gson()
        var UsuarioPrueba = Usuario(4,"pruebito","666","normaluser", 0,R.drawable.imguser2)
        var json = gson.toJson(UsuarioPrueba)
        println( "este debe ser el json" + json)

        var jsonconvert = "{\"Id\":4,\"Liked\":0,\"Password\":\"666\",\"ProfileImg\":2131165298,\"UserType\":\"normaluser\",\"Username\":\"pruebito\"}"
        var UsuarioPruebajson:Usuario = gson.fromJson(json, Usuario::class.java)
        println("este es de json a objeto" + UsuarioPruebajson)*/


        val img_user = v.findViewById<ImageView>(R.id.image_User) as ImageView
        val access_btn = v.findViewById<View>(R.id.button_sing_in) as Button

        var input_email = v.findViewById(R.id.txt_email_input) as EditText
        var input_pass = v.findViewById(R.id.txt_password_input) as EditText

        var Usuario1 = Usuario(1,"a", "123","normaluser",0, R.drawable.imguser1)
        var Usuario2 = Usuario(2,"susi", "321", "writer",0,R.drawable.imguser2)
        var Usuario3 = Usuario(3,"bb","555", "normaluser",0, R.drawable.imguser3)

        val array_users:ArrayList<Usuario> = arrayListOf<Usuario>()
        array_users.add(Usuario1)
        array_users.add(Usuario2)
        array_users.add(Usuario3)

        input_pass.isEnabled = false

        input_email.setOnClickListener(){
            input_pass.isEnabled = true
        }

        access_btn.setOnClickListener{

            for (i in array_users.indices){
                var user = i
                val bundle = Bundle()

                if (input_email?.text.toString() == array_users[i].Username){
                    if(input_pass?.text.toString() == array_users[i].Password){
                        println("la constrasena y correo son correctos")

                        if (array_users[i].UserType == "writer"){

                            val fragment = FragmentWriter()
                            val fragmentManager = requireActivity().supportFragmentManager
                            val fragmentTransaction = fragmentManager.beginTransaction()
                            fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
                            fragmentTransaction.addToBackStack(null)
                            bundle.putInt("userSesion", user)
                            fragment.arguments = bundle

                            fragmentTransaction.commit()

                        }else{

                            val fragment = FragmentUser()
                            val fragmentManager = requireActivity().supportFragmentManager
                            val fragmentTransaction = fragmentManager.beginTransaction()
                            fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
                            fragmentTransaction.addToBackStack(null)
                            bundle.putInt("userSesion", user)
                            fragment.arguments = bundle

                            fragmentTransaction.commit()
                        }
                    }
                }
            }
        }

        return v

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentLogin.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentLogin().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}