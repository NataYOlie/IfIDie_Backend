package fr.eql.ai113.ifidieback.repository;

import fr.eql.ai113.ifidieback.entity.ListType;
import fr.eql.ai113.ifidieback.entity.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TaskDaoTest {

    Logger logger = LogManager.getLogger();

    @Mock
    private TaskDao taskDao;

    @Test
    public void testFindDefaultStepTasksBySubtype() {

        List<Task> defaultTasks = new ArrayList<>();

        ListType steplist = new ListType();
        steplist.setList_name("Steplist");

        // Define test data
        Task task1 = new Task();
        task1.setHeader("Default_Task1");

        Task task2 = new Task();
        task2.setHeader("Default_Task2");
        task2.setListType(steplist);

        defaultTasks.add(task1);
        defaultTasks.add(task2);

        logger.info(defaultTasks.size() + " taille de defaultTasks");

        // Mock the behavior of taskDao.findDefaultStepTasksBySubtype()
        when(taskDao.findDefaultStepTasksBySubtype()).thenReturn(defaultTasks);

        // Call the method being tested
        List<Task> result = taskDao.findDefaultStepTasksBySubtype();

        // Assert the results
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Default_Task1", result.get(0).getHeader());
    }
}
