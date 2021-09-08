package com.jackrtutorial.androidretrofit2crud;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jackrtutorial.androidretrofit2crud.model.User;
import com.jackrtutorial.androidretrofit2crud.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private Context context;
    private List<User> users;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_user, parent, false);

        TextView txtBarcode = (TextView) rowView.findViewById(R.id.txtBarcode);
        TextView txtProduct_Name = (TextView) rowView.findViewById(R.id.txtProduct_Name);
        TextView txtIngredients = (TextView) rowView.findViewById(R.id.txtIngredients);
        TextView txtStatus = (TextView) rowView.findViewById(R.id.txtStatus);

        txtBarcode.setText(String.format("Barcode: %d", users.get(pos).getBarcode()));
        txtProduct_Name.setText(String.format("Product Name: %s", users.get(pos).getProduct_name()));
        txtIngredients.setText(String.format("Ingredients: %s", users.get(pos).getIngredients()));
        txtStatus.setText(String.format("Status: %s", users.get(pos).getStatus()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("Barcode", String.valueOf(users.get(pos).getBarcode()));
                intent.putExtra("Product Name", users.get(pos).getProduct_name());
                intent.putExtra("Ingredients", users.get(pos).getIngredients());
                intent.putExtra("Status", users.get(pos).getStatus());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}