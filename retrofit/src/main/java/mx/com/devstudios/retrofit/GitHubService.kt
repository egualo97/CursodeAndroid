package mx.com.devstudios.retrofit


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by egual on 26/10/2017.
 */
interface GitHubService {

    @GET("/users/{username}")
    fun getUser(@Path("username")name: String) : Call<ResponseBody>

    @GET("/users/{username}")
    fun getUserGson(@Path("username")name: String) : Call<ResponseGithubUsers>

    @GET("/users/{username}/repos")
    fun getRepos(@Path("username")name: String): Call<List<Repo>>

}