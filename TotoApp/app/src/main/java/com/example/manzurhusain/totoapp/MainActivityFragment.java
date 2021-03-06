package com.example.manzurhusain.totoapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.manzurhusain.totoapp.adaptors.TodoListAdaptor;
import com.example.manzurhusain.totoapp.dto.EachTodo;
import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

  private RecyclerView recyclerView;
  public TodoListAdaptor mAdapter;
  private RecyclerView.LayoutManager layoutManager;
  private ArrayList<EachTodo> eachTodos;


  private EditText titleET;
  private EditText priorityET;
  private EditText dueDateET;
  private Button addTaskBtn;


  public MainActivityFragment() {
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View main = inflater.inflate(R.layout.fragment_main, container, false);

    eachTodos = new ArrayList<EachTodo>();

    titleET = (EditText) main.findViewById(R.id.taskTitleInput);
    priorityET = (EditText) main.findViewById(R.id.priorityInput);
    dueDateET = (EditText) main.findViewById(R.id.dueDateInput);
    addTaskBtn = (Button) main.findViewById(R.id.buttonAdd);

    recyclerView = (RecyclerView)main.findViewById(R.id.listRecyclerView);
    layoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layoutManager);
    mAdapter = new TodoListAdaptor(getContext(),eachTodos);
    recyclerView.setAdapter(mAdapter);

    ItemTouchHelper.Callback callback = new TodoTouchHelper(mAdapter);
    ItemTouchHelper helper = new ItemTouchHelper(callback);
    helper.attachToRecyclerView(recyclerView);

    addTaskBtn.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {

        EachTodo eachTodoObj = new EachTodo();
        eachTodoObj.setTitle(titleET.getText().toString());
        eachTodoObj.setPriority(Integer.parseInt(priorityET.getText().toString()));
        eachTodoObj.setDueDate(dueDateET.getText().toString());

        mAdapter.addItem(eachTodoObj, eachTodos.size());
        //eachTodos.add(eachTodoObj);
        //mAdapter.notifyDataSetChanged();

      }
    });

    return main;
  }
}

class TodoTouchHelper extends ItemTouchHelper.SimpleCallback {
  private TodoListAdaptor todoListAdaptor;
  private ArrayList<EachTodo> trashedTodo;

  public TodoTouchHelper(TodoListAdaptor movieAdapter){
    super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    this.todoListAdaptor = movieAdapter;
    trashedTodo = new ArrayList<EachTodo>();
  }

  @Override
  public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
    //TODO: Not implemented here
    return false;
  }

  @Override
  public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    //Remove item
    todoListAdaptor.deleteItem(viewHolder.getAdapterPosition());
    trashedTodo = todoListAdaptor.getAllRecycleTodos();
  }
}

