package mx.com.devstudios.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var tvName: TextView? = null;
    private var inputName: EditText? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvName = findViewById(R.id.tv_name) as TextView;

        tvName?.text = "Hola Dev.f!"

        tvName?.setOnClickListener(this)

        inputName = findViewById(R.id.editText)as EditText

        findViewById(R.id.button).setOnClickListener(this)
    }
    override fun onClick(View: View?){

        when(View?.id){
            R.id.tv_name -> {
                Toast.makeText(this,"textView", Toast.LENGTH_SHORT).show();
            }

            R.id.button -> {
                val txtName = inputName?.text.toString();
                tvName?.text = txtName;
                inputName?.text = Editable.Factory.getInstance().newEditable("Escribe el Texto")

            }
        }
    }
}



