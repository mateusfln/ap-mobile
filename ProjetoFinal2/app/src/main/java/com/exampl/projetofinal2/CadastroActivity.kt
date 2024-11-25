package com.exampl.projetofinal2

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exampl.projetofinal2.databinding.ActivityCadastroBinding
import com.exampl.projetofinal2.databinding.ActivityFotoBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var posicao = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Cadastramento = ArrayList<Cadastramento>()
        Cadastramento.add(Cadastramento(nome = "Bruno", idade = "22", email = "Bruno@gmail.com"))
        Cadastramento.add(Cadastramento(nome = "Joana", idade = "34", email = "Joana@gmail.com"))
        Cadastramento.add(Cadastramento(nome = "Julia", idade = "19", email = "Julia@gmail.com"))

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1,Cadastramento)
        binding.listView.adapter = adapter

        binding.buttonCadastrar .setOnClickListener{
            var nome = binding.textNome.text.toString().trim()
            var idade = binding.textIdade.text.toString().trim()
            var email = binding.textEmail.text.toString().trim()


            if(!nome.isEmpty() && !idade.isEmpty()){
                Cadastramento.add(Cadastramento(nome,idade,email))
                adapter.notifyDataSetChanged()
                binding.textNome.setText("")
                binding.textIdade.setText("")
                binding.textEmail.setText("")
            }
        }
        binding.listView.setOnItemClickListener { adapterView, view, i,l ->
            var d = Cadastramento.get(i)
            binding.textNome.setText(d.nome)
            binding.textIdade.setText(d.idade)
            binding.textEmail.setText(d.email)
            posicao = i
        }

        binding.buttonExcluir.setOnClickListener{
            if(posicao != 1) {
                Cadastramento.removeAt(posicao)
                adapter.notifyDataSetChanged()
                posicao = -1
                binding.textNome.setText("")
                binding.textIdade.setText("")
                binding.textEmail.setText("")
            }

            binding.listView.setOnItemClickListener { adapterView, view, i,l ->
                var d = Cadastramento.get(i)
                binding.textNome.setText(d.nome)
                binding.textIdade.setText(d.idade)
                binding.textEmail.setText(d.email)
                posicao = i
            }
        }

        binding.buttonContinuar.setOnClickListener {
            // Certifique-se de usar a classe correta da próxima Activity
            val intent = Intent(this, FimActivity::class.java)
            startActivity(intent)
        }
    }
}

