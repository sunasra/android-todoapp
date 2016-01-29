package com.example.manzurhusain.totoapp.adaptors;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.manzurhusain.totoapp.R;
import com.example.manzurhusain.totoapp.dto.EachTodo;
import java.util.ArrayList;

/**
 * Created by manzur.husain on 27/01/16.
 */
public class TodoListAdaptor extends RecyclerView.Adapter<TodoListAdaptor.TodoItemViewHolder> {
  private Context context;
  private ArrayList<EachTodo> eachTodos;

  public TodoListAdaptor(Context context, ArrayList<EachTodo> eachTodos) {
    this.context = context;
    this.eachTodos = eachTodos;
  }

  @Override public TodoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.each_todo,parent,false);
    TodoItemViewHolder todoItemViewHolder = new TodoItemViewHolder(view);

    return  todoItemViewHolder;
  }

  @Override public void onBindViewHolder(TodoItemViewHolder holder, int position) {
    holder.titleTxt.setText(eachTodos.get(position).getTitle());
    holder.priorityTxt.setText("" + eachTodos.get(position).getPriority());
    holder.dueDateTxt.setText(""+eachTodos.get(position).getDueDate());

  }

  @Override public int getItemCount() {
    return eachTodos.size();
  }

  public void addItem(EachTodo eachTodo, int index){
    eachTodos.add(eachTodo);
    notifyItemInserted(index);
  }

  public void deleteItem(int index){
    eachTodos.remove(index);
    notifyItemRemoved(index);
  }

  public class TodoItemViewHolder extends RecyclerView.ViewHolder{

    TextView titleTxt;
    TextView priorityTxt;
    TextView dueDateTxt;
    LinearLayout metaTodo;
    public TodoItemViewHolder(View itemView) {
      super(itemView);

      metaTodo = (LinearLayout) itemView.findViewById(R.id.metaTodo);
      titleTxt = (TextView)itemView.findViewById(R.id.titleTextView);
      priorityTxt = (TextView) metaTodo.findViewById(R.id.priorityTextView);
      dueDateTxt = (TextView) metaTodo.findViewById(R.id.dueDateTextView);

    }
  }
}
