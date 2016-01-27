package com.example.manzurhusain.totoapp.dto;

/**
 * Created by manzur.husain on 27/01/16.
 */
public class EachTodo {
  public String title;
  public String dueDate;
  public int priority;


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

}
