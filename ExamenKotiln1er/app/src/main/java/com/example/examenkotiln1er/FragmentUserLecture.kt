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
 * Use the [FragmentUserLecture.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentUserLecture : Fragment() {
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
        val v = inflater.inflate(R.layout.fragment_user_lecture, container, false)

        val recivedLecture = arguments?.getInt("literaryWorkRead")
        println( "esta es la lectura solicitada" + recivedLecture)

        var counterWorks = 0
        var lectureImage = v.findViewById<ImageView>(R.id.img_lecture_view)
        var lectureTitle = v.findViewById<TextView>(R.id.txt_lecture_title)
        var lectureContent = v.findViewById<TextView>(R.id.txt_lecture_content)
        var lectureLikes = v.findViewById<TextView>(R.id.txt_lecture_likes)

        val arrowLeft = v.findViewById<ImageView>(R.id.btn_arrow_left)
        val arrowRight = v.findViewById<ImageView>(R.id.btn_arrow_right)

        var LiteralWork1 = LiteraryWorks(1,"Zistopia","Erra una noche muy fria en donde de repente el me tomo de la mano", 0,R.drawable.article1)
        var LiteralWork2 = LiteraryWorks(2,"Snape y yo", "El mastro Snape siempre me miraba con esa mirada penetranta que intimidaba a cualquie mogle", 0,R.drawable.article2)
        var LiteralWork3 = LiteraryWorks(3, "Jordi el proxwneta", "Jordi se encontraba placidamente grabando su nuevo video", 0, R.drawable.article3)
        var LiteralWork4 = LiteraryWorks(4, "Elsa y Jack frost", "Nuestro universos eran tan distintos pero nuestro amor era mas fuerte que eso", 0, R.drawable.article4)
        var array_works:ArrayList<LiteraryWorks> = arrayListOf<LiteraryWorks>()
        array_works.add(LiteralWork1)
        array_works.add(LiteralWork2)
        array_works.add(LiteralWork3)
        array_works.add(LiteralWork4)


        for (i in array_works.indices){
            if (recivedLecture == i){
                lectureImage.setImageResource(array_works[i].ImgSource)
                lectureTitle.setText(array_works[i].Name)
                lectureContent.setText(array_works[i].Content)
                lectureLikes.setText("00000")
            }
        }

        arrowLeft.setOnClickListener{
            counterWorks--
            println(counterWorks)
            if (counterWorks <= 0){
                lectureImage.setImageResource(R.drawable.article1)
                lectureTitle.setText(array_works[0].Name)
                lectureContent.setText(array_works[0].Content)
                counterWorks = 4
            }else if (counterWorks ==1){
                lectureImage.setImageResource(R.drawable.article2)
                lectureTitle.setText(array_works[1].Name)
                lectureContent.setText(array_works[1].Content)
            }else if (counterWorks == 2){
                lectureImage.setImageResource(R.drawable.article3)
                lectureTitle.setText(array_works[2].Name)
                lectureContent.setText(array_works[2].Content)
            }else if (counterWorks == 3){
                lectureImage.setImageResource(R.drawable.article4)
                lectureTitle.setText(array_works[3].Name)
                lectureContent.setText(array_works[3].Content)
            }
        }

        arrowRight.setOnClickListener{
            counterWorks++
            println(counterWorks)
            if (counterWorks == 0 ){
                lectureImage.setImageResource(R.drawable.article1)
                lectureTitle.setText(array_works[0].Name)
                lectureContent.setText(array_works[0].Content)

            }else if (counterWorks ==1){
                lectureImage.setImageResource(R.drawable.article2)
                lectureTitle.setText(array_works[1].Name)
                lectureContent.setText(array_works[1].Content)
            }else if (counterWorks == 2){
                lectureImage.setImageResource(R.drawable.article3)
                lectureTitle.setText(array_works[2].Name)
                lectureContent.setText(array_works[2].Content)
            }else if (counterWorks == 3) {
                lectureImage.setImageResource(R.drawable.article4)
                lectureTitle.setText(array_works[3].Name)
                lectureContent.setText(array_works[3].Content)
                counterWorks = -1
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
         * @return A new instance of fragment FragmentUserLecture.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentUserLecture().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}