package gabrihorstudios.com.droidsamples.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import gabrihorstudios.com.droidsamples.R;
import gabrihorstudios.com.droidsamples.model.User;

/**
 * Created by andersonferreira on 05/02/17.
 */

public class ListUsersAdapter extends ArrayAdapter<User>{

    private final List<User> users;
    private final Context context;

    public ListUsersAdapter(Context context, List<User> users) {
        super(context, R.layout.list_users, users);
        this.users = users;
        this.context = context;
    }

    static class ViewHolder{
        protected TextView textViewName;
        protected TextView textViewMail;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView == null){
            LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(R.layout.list_users, null);
            final ViewHolder viewHolder = new ViewHolder();

            viewHolder.textViewName = (TextView) view.findViewById(R.id.name_list_users);
            viewHolder.textViewMail = (TextView) view.findViewById(R.id.mail_list_users);
            view.setTag(viewHolder);
        }else{
            view = convertView;
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.textViewName.setText(users.get(position).getName());
        holder.textViewMail.setText(users.get(position).getMail());
        return view;
    }
}
