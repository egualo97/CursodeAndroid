package mx.com.devstudios.persistenciadedatos

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.realm.Realm

class MainActivity : AppCompatActivity() {

    val PREFERENCE_NAME = "Mis Preferncias"
    val PREF_KEY_SALUDO = "KEY_SALUDO"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,getSaludo(),Toast.LENGTH_SHORT).show()
        saveSaludo("Saludo Guardado!!!")
        val user = User()
        user.age = 20
        user.id = 347
        user.lastName = "Gonzalez"
        user.name = "Jaime"

        saveUser(user)

        getUser()
        getUser(347)
    }
    fun getSaludo(): String {
        //Obtenemos una referencia de las preferencias
        val preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        //Obtenemos el valor guardado en el PREF_KEY_SALUDO si no exixte me regresa saludo por defecto
        val saludo =  preferences.getString(PREF_KEY_SALUDO, "Saludo por Defecto")
        return saludo
    }
    fun saveSaludo(saludo:String){
    //Obtenemos una referencia de las prefencias
    val preferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        //Utilizo un objeto Editor para escriboir en mi archivo
        val editor = preferences.edit()
        editor.putString(PREF_KEY_SALUDO,saludo)
        //Le indicamos que aplique las trasaciones anteriores
        editor.commit()
    }
   fun saveUser(user: User){
       //Obtengo mi instacia Realm
       val realm = Realm.getDefaultInstance()
       //Iniciamos una trasaction de realm
       realm.beginTransaction()
       realm.copyToRealmOrUpdate(user)
       //Cerramos nuestra transaccion de Realm
       realm.commitTransaction()
   }
    fun getUser(){
        //Obtengo mi instancia de Realm
        val realm = Realm.getDefaultInstance()
        //Le indico de que tabla lo tomara
        val users = realm.where(User::class.java)
                .findAll()//Le indico que me regrese todos los que encuentre

        for(user in users){
            Log.e("myLog",user.toString())
        }
    }
    fun getUser(id:Int){
        //Obtengo mi instancia de Realm
        val realm = Realm.getDefaultInstance()
        //Le indico de que tabla lo tomara
        val user = realm.where(User::class.java)
                .equalTo("id",id)
                .findFirst()

        Log.e("myLog",user?.name)
    }
}
