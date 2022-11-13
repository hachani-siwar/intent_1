package com.example.intent2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener
 {
    lateinit var bt: Button
    lateinit var btAjouter:Button
    lateinit var monTexte:TextView


    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var myAdapter: RecyclerView.Adapter<*>

    var values= arrayListOf<ItemsViewModel>(ItemsViewModel(R.drawable.tunisie,"Tunisie"),ItemsViewModel(R.drawable.turquie,"Turquie"),ItemsViewModel(R.drawable.france,"France"),ItemsViewModel(R.drawable.brazil,"Brazil"))
    //private val itemTitles = arrayOf("Tunisie","France","Turquie","Brazil")
    //private val itemImage = intArrayOf(R.drawable.france,R.drawable.turquie,R.drawable.tunisie,R.drawable.brazil)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt = findViewById(R.id.btnSuivant)
        btAjouter=findViewById(R.id.btAjouter)
        monTexte=findViewById(R.id.txtMonTexte)

        bt.setOnClickListener{
            var s = monTexte.text.toString()
            var i = Intent(this,Activity2::class.java)
            i.putExtra("cle",s)
            startActivity(i)
        }
        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = manager
            adapter = myAdapter
        }
       //var n:Int = values.size + 1
       // values.add("item$n") //Ajout dans la source de données
       // myAdapter.notifyItemInserted(values.size)


    }
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked",
            Toast.LENGTH_SHORT).show()
        values[position].text="Clicked"
        myAdapter.notifyItemChanged(position)
    }





}