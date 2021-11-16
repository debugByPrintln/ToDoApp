package com.melnikov.mainDir.runners;

import com.melnikov.mainDir.daoFiles.TaskDAO;
import com.melnikov.mainDir.sourceFiles.Task;
import com.melnikov.mainDir.utils.RSPrinter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainRunner {
    public static void main(String[] args) {
        while (true){

            Scanner scanner = new Scanner(System.in);
            TaskDAO taskDAO = new TaskDAO();

            System.out.println("showAll = 1, delete = 2, add = 3");

            int userMove = scanner.nextInt();

            if (userMove == 1){
                List<Task> allTasks = taskDAO.getAllTasks();
                for (int i  = 0; i < allTasks.size(); i++) {
                    System.out.println("---------------------------------------------------");
                    System.out.println(allTasks.get(i).toString());
                    System.out.println("---------------------------------------------------");
                }
            }

            else if (userMove == 2){
                System.out.println("id to delete");
                int id = scanner.nextInt();
                taskDAO.deleteTask(id);

            }

            else if (userMove == 3){
                Task task = readTaskFromKeyBoard();
                taskDAO.addTask(task);
            }

            else {
                break;
            }

        }
    }

    public static Task readTaskFromKeyBoard(){
        Scanner scanner = new Scanner(System.in);

        Task task = new Task();

        System.out.println("id");
        task.setId(scanner.nextInt());

        System.out.println("Header");
        String header = scanner.next();
        task.setHeader(header);

        System.out.println("Description");
        String description = scanner.next();
        task.setDescription(description);

        task.setCreationDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm-dd-MM-yyyy")));

        System.out.println("To-Do Date");
        task.setToDoDateTime(scanner.next());

        if (task.getHeader() != null){
            return task;
        }
        else {
            return null;
        }
    }

}
