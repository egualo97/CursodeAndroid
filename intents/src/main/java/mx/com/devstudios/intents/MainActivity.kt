package mx.com.devstudios.intents

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var img_Picture: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        findViewById(R.id.btn_open_activity).setOnClickListener(this)
        findViewById(R.id.btn_call).setOnClickListener(this)
        findViewById(R.id.btn_link).setOnClickListener(this)
        findViewById(R.id.btn_mapa).setOnClickListener(this)
        findViewById(R.id.btn_camara).setOnClickListener(this)

        img_Picture = findViewById(R.id.img_picture) as ImageView
    }
        override fun onClick(view: View?){
        when(view?.id){
            R.id.btn_open_activity -> openActivity()
            R.id.btn_call -> doCall()
            R.id.btn_link ->openLink()
            R.id.btn_mapa ->openMap(view)
            R.id.btn_camara ->takePicture()
        }
    }
     private fun takePicture(){
    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    startActivityForResult(cameraIntent, 1032)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==1032){
            if(resultCode == Activity.RESULT_OK){
                val photo = data?.extras?.get("data")as Bitmap
                img_Picture?.setImageBitmap(photo)
            }else{
                Toast.makeText(this, "Cancelo Tomar Foto", Toast.LENGTH_SHORT).show()
            }
        }
    }
     private fun openMap(view: View?){
        val direction = "https://www.google.com.mx/maps/place/WIZELINE+-+Building+2/@20.643211,-103.4107227,15z/data=!4m5!3m4!1s0x0:0x852bb3e8694f0544!8m2!3d20.6462758!4d-103.4136119"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(direction))
        startActivity(intent)

    }

    private fun openLink(){
    val url = "http://www.google.com"
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse(url)
    startActivity(intent)
    }

    private  fun doCall(){
      var intent = Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"5537901848"))
      startActivity(intent)
    }



     fun openActivity(){
       //Configuramos el intent pasandole el class de la actividad a los que nos dirigimos
        val intent = Intent(this,ThirdActivity::class.java)

         //Igresamos parametros que se pasaran a la siguiente actividad
        intent.putExtra("key1","Pasando Datos")
        intent.putExtra("key2", 1938)
        //Ejecutamos
        startActivity(intent)
    }
}

