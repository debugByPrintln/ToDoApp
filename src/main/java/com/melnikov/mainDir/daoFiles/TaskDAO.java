package com.melnikov.mainDir.daoFiles;

import com.melnikov.mainDir.connection.ConnectionSource;
import com.melnikov.mainDir.sourceFiles.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskDAO {
    private static ConnectionSource source = ConnectionSource.instance();

    public TaskDAO() {

    }

    public List<Task> getAllTasks(){
        List<Task> list = new LinkedList<>();

        try(Connection connection = source.createConnection();
            PreparedStatement getAll = connection.prepareStatement("SELECT * FROM task")){

            ResultSet resultSet = getAll.executeQuery();


            while (resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt(1));
                task.setHeader(resultSet.getString(2));
                task.setDescription(resultSet.getString(3));
                task.setCreationDateTime(resultSet.getString(4));
                task.setToDoDateTime(resultSet.getString(5));
                list.add(task);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public void deleteTask(int id){
        try(Connection connection = source.createConnection();
            PreparedStatement deleteTask = connection.prepareStatement("DELETE FROM task WHERE ID = ?")){

            deleteTask.setInt(1, id);
            deleteTask.execute();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addTask(Task task){
        try(Connection connection = source.createConnection();
            //добавить возможность раложить таск на стрингу
            PreparedStatement addTask = connection.prepareStatement("INSERT INTO task VALUES (" + task.toString() + ")");){

            addTask.execute();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


}
