package com.example.consommer_with_retrofit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private final List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false); // "item_user" correspond au nom de votre layout XML
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.text1.setText(user.getName());
        holder.text2.setText(user.getEmail());

        // Ajouter un écouteur de clic
        holder.itemView.setOnClickListener(v -> {
            // Passer les données à l'activité UserDetailsActivity
            Intent intent = new Intent(v.getContext(), UserDetailsActivity.class);
            intent.putExtra("name", user.getName());
            intent.putExtra("username", user.getUsername());
            intent.putExtra("email", user.getEmail());

            // Construire une chaîne pour l'adresse complète
            String address = user.getAddress().getStreet() + ", " +
                    user.getAddress().getSuite() + ", " +
                    user.getAddress().getCity() + " " +
                    user.getAddress().getZipcode();
            intent.putExtra("address", address);

            v.getContext().startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(R.id.user_name);  // Assurez-vous que les ID correspondent
            text2 = itemView.findViewById(R.id.user_email);
        }
    }

}
