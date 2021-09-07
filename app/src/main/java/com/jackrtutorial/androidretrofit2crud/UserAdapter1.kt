package com.jackrtutorial.androidretrofit2crud

import android.R.attr
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.jackrtutorial.androidretrofit2crud.model.User

private val Int.txtUsername: Int
    get() {}
private val Int.txtUserId: Int
    get() {}
private val Int.list_user: Any
    get() {}

class UserAdapter(
    private val context: Context,
    @LayoutRes resource: Int,
    private val users: List<User>
) :
    ArrayAdapter<User?>(context, resource, users) {
    override fun getView(pos: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val rowView: View = inflater.inflate(attr.layout.list_user, parent, false)
        val txtUserId = rowView.findViewById<View>(attr.id.txtUserId) as TextView
        val txtUsername = rowView.findViewById<View>(attr.id.txtUsername) as TextView
        txtUserId.text = String.format("#ID: %d", users[pos].id)
        txtUsername.text = String.format("USER NAME: %s", users[pos].name)
        rowView.setOnClickListener { //start Activity User Form
            val intent = Intent(context, UserActivity::class.java)
            intent.putExtra("user_id", users[pos].id.toString())
            intent.putExtra("user_name", users[pos].name)
            context.startActivity(intent)
        }
        return rowView
    }

    companion object {
        private val R: attr? = null
    }
}