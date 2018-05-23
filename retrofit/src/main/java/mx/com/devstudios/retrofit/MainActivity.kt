package mx.com.devstudios.retrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), Callback<ResponseBody> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUser("egualo97")
        getRepos("egualo97")
    }

    fun getUser(username : String) {

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build()
        val service = retrofit.create(GitHubService::class.java)

        service.getUser(username).enqueue(this)

    }


    }
    override fun onFailure(call: Call<ResponseBody>?, t: Throwable){
        Log.e("myLog","Fallo")
        t?.printStackTrace()
    }

    override fun onResponse(call: Call<ResponseBody>?, response: retrofit2.Response<ResponseBody>?) {
        Log.e("myTag", "Salio Bien")
        Log.e("myTag", "Code : ${response?.code()}")
        //Log.e("myTag", "Code : ${response?.body()?.string()}")


        val json = JSONObject(response?.body()?.string())
        Log.e("myLog", "Code: ${json.toString(3)}")
        Log.e("myLog",json.getString("login"))


        val user = Gson().fromJson(json.toString(),ResponseGithubUsers::class.java)
        Log.e("myLog",user.toString())
        Log.e("myLog", user.toString())


        fun getUserGson(name: String){
            //Configuramos Retrofit
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
    }
        class HandlerUserRepos : Callback<List<Repo>>{
            override fun onResponse(call: Call<List<Repo>>?, response: retrofit2.Response<List<Repo>>?) {
                for (repo in response!!.body()!!){
                    Log.e("myLog",repo.name)
                }
            }
            fun
        }
}