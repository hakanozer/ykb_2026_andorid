package com.works.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.works.databinding.FragmentTodoBinding
import com.works.models.DocTodo
import com.works.models.Todo
import yuku.ambilwarna.AmbilWarnaDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.works.adapter.TodoAdapter

class TodoFragment : Fragment() {

    lateinit var adapter: TodoAdapter
    val db = Firebase.firestore
    val dotoList = ArrayList<DocTodo>()

    private var selectedColor: Int = Color.BLUE

    private var _binding: FragmentTodoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        adapter = TodoAdapter(dotoList)
        binding.rvTodoList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTodoList.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // progress bar start
        binding.rvProgressBar.visibility = View.VISIBLE

        db.collection("todos").get()
        .addOnSuccessListener { result ->
            for (document in result) {
                val title = document.data["title"].toString()
                val detail = document.data["detail"].toString()
                val color = document.data["color"].toString().toInt()

                //Log.d("TAG", "$title, $detail, $color")
                val todo = Todo(title, detail, color)
                val docTodo = DocTodo(document.id, todo)
                dotoList.add(docTodo)
            }
            binding.rvProgressBar.visibility = View.GONE
            adapter.notifyDataSetChanged()
            Log.d("TodoFragment", "dotoList: $dotoList")
        }


        // Kaydet Butonu Tıklama Dinleyicisi
        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val detail = binding.etDetail.text.toString()
            val todo = Todo(title, detail, selectedColor)

            // Firebase Firestore'a kaydetme işlemi
            db.collection("todos").add(todo)
            .addOnSuccessListener { documentReference ->
                val docTodo = DocTodo(documentReference.id, todo)
                dotoList.add(docTodo)
                adapter.notifyDataSetChanged()
                Toast.makeText(requireContext(), "Todo kaydedildi", Toast.LENGTH_SHORT).show()
                clearInputs()
            }
            .addOnFailureListener { e ->
                //Log.w("TodoFragment", "Todo kaydedilemedi", e)
                Toast.makeText(requireContext(), "Todo kaydedilemedi", Toast.LENGTH_SHORT).show()
            }


        }

        // Renk Seçici Tıklama (Simülasyon)
        binding.colorSection.setOnClickListener {
            val colorPicker = AmbilWarnaDialog(
                requireContext(),
                selectedColor,
                object : AmbilWarnaDialog.OnAmbilWarnaListener {
                    override fun onCancel(dialog: AmbilWarnaDialog?) {
                        // iptal edildi
                    }
                    override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                        selectedColor = color
                        // Seçilen rengi göster
                        binding.viewSelectedColor.setBackgroundColor(color)
                    }
                })
            colorPicker.show()
        }
    }

    private fun clearInputs() {
        binding.etTitle.text?.clear()
        binding.etDetail.text?.clear()
        binding.titleInputLayout.error = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}