package com.jackrtutorial.androidretrofit2crud

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.jackrtutorial.androidretrofit2crud.model.User
import com.jackrtutorial.androidretrofit2crud.remote.APIUtils
import com.jackrtutorial.androidretrofit2crud.remote.UserService
import com.jackrutorial.androidretrofit2crud.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var btnAddUser: Button? = null
    var btnGetUsersList: Button? = null
    var listView: ListView? = null
    var userService: UserService? = null
    var list: List<User> = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Retrofit 2 CRUD Demo"
        btnAddUser = findViewById<View>(R.id.btnAddUser) as Button
        btnGetUsersList = findViewById<View>(R.id.btnGetUsersList) as Button
        listView = findViewById<View>(R.id.listView) as ListView
        userService = APIUtils.getUserService()
        btnGetUsersList!!.setOnClickListener {


            //get users list
            usersList
        }
        btnAddUser!!.setOnClickListener {
            val intent = Intent(this@MainActivity, UserActivity::class.java)
            intent.putExtra("user_name", "")
            startActivity(intent)
        }
    }

    val usersList: Unit
        get() {
            val call: Call<MutableList<User>>? = userService!!.users
            if (call != null) {
                call.enqueue(object : Callback<List<User>> {
                    override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                        if (response.isSuccessful) {
                            list = response.body()!!
                            listView!!.adapter =
                                UserAdapter(this@MainActivity, R.layout.list_user, list)
                        }
                    }

                    override fun onFailure(call: Call<List<User>>, t: Throwable) {
                        Log.e("ERROR: ", t.message!!)
                    }
                })
            }
        }
}

private fun <T> Call<T>?.enqueue(callback: Callback<List<User>>) {

}
