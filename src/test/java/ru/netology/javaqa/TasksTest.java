package ru.netology.javaqa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void shouldReturnFalse(){
        Epic epic = new Epic(1, new String[]{"Подзадача 1", "Подзадача 2", "Подзадача 3"});
        String query = "Подзадача 4";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTrue(){
        String[] subtasks = {"Подзадача 1","Подзадача 2","Подзадача 3"};
        Epic epic = new Epic(1, subtasks);
        String query = "Подзадача 2";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTrueInTitle(){
        SimpleTask task = new SimpleTask(1, "Главная задача");
        String query = "Главная";
        boolean expected = true;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnFalseInTitle(){
        SimpleTask task = new SimpleTask(1, "Главная задача");
        String query = "Дом";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTrueInTopic(){
        Meeting meeting = new Meeting(1, "Тема обсуждения 1", "Проект № 234", "Завтра");
        String query = "обсуждения";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnTrueInProject(){
        Meeting meeting = new Meeting(1,"Тема обсуждения 1", "Проект № 234", "Во вторник");
        String query = "Проект";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldReturnFalseInMeeting(){
        Meeting meeting = new Meeting(1,"Тема обсуждения 1","Проект № 234","На выходных");
        String query = "Дом";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

}
