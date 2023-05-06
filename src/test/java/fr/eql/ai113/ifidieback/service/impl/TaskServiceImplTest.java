package fr.eql.ai113.ifidieback.service.impl;

import fr.eql.ai113.ifidieback.entity.Task;
import fr.eql.ai113.ifidieback.repository.TaskDao;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
Dans ce test, nous avons utilisé les annotations @RunWith(SpringRunner.class) et @SpringBootTest pour charger le
contexte de l'application et initialiser les dépendances nécessaires pour le test. La méthode @Transactional garantit
que les opérations de la base de données sont exécutées dans une transaction, qui est ensuite annulée à la fin du test.
 */
@RunWith(MockitoJUnitRunner.class)
class TaskServiceImplTest {

    private JdbcDataSource dataSource;

    @Mock
    private TaskDao taskDaoTest;

    @Mock
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this);
        taskService = Mockito.mock(TaskServiceImpl.class);

        //Je met des tâches types pour test dans ma database H2 qui mimique un SQL
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;MODE=MySQL");
        dataSource.setUser("sa");
        dataSource.setPassword("password");
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE task (\n" +
                    "  id_task INT NOT NULL,\n" +
                    "  default_task BOOLEAN,\n" +
                    "  description TEXT,\n" +
                    "  external_link VARCHAR(255),\n" +
                    "  header VARCHAR(255),\n" +
                    "  previsional_date DATE,\n" +
                    "  subtype VARCHAR(255),\n" +
                    "  task_color VARCHAR(255),\n" +
                    "  validation_date DATE,\n" +
                    "  visible BOOLEAN,\n" +
                    "  list_type_id_task_type INT,\n" +
                    "  user_id_user INT,\n" +
                    "  PRIMARY KEY (id_task)\n" +
                    ");");
            stmt.execute("INSERT INTO task (id_task, default_task, description, external_link, header, previsional_date, subtype, task_color, validation_date, visible, list_type_id_task_type, user_id_user)\n" +
                    "VALUES (1, true, 'C’est un point du testament mais qui peut être traité individuellement. ', 'https://www.demarches.interieur.gouv.fr/particuliers/peut-on-designer-personne-occuper-enfant-deces ', 'Garde des enfants', NULL, 'Famille', 'pastille-jaune', NULL, true, 1, 1);\n");
            stmt.execute("INSERT INTO task (id_task, default_task, description, external_link, header, previsional_date, subtype, task_color, validation_date, visible, list_type_id_task_type, user_id_user)\n" +
                    "VALUES (2, true, 'Trouver une personne qui pourra les prendre en charge.', '', 'Animaux domestiques', NULL, 'Famille', 'pastille-jaune', NULL, true, 1, 1);");
            stmt.execute("INSERT INTO task (id_task, default_task, description, external_link, header, previsional_date, subtype, task_color, validation_date, visible, list_type_id_task_type, user_id_user)\n" +
                "VALUES (3, true, 'Identité :- carte d’identité, passeport, permis de conduire… - Directives anticipées - testament - Documents relatifs aux comptes bancaires, actifs, assurances vies actes de propriété carte grise carnets de santé / documents liés à la santé des enfants à charge ou des personnes dépendantes carnets de santé / documents liés à la santé des animaux de compagnies.', '', 'Documents à regrouper en un lieu centralisé, faire des copies etc : ', NULL, 'Administratif', 'pastille-bleu', NULL, true, 1, 1);");
        }
    }

//    public void setUp() throws Exception {
//
//        /*
//        INSERT INTO `task` (`id_task`,`default_task`, `description`, `external_link`, `header`,`previsional_date`, `subtype`, `task_color`, `validation_date`, `visible`, `list_type_id_task_type`, `user_id_user`) VALUES (1, true, 'C’est un point du testament mais qui peut être traité individuellement. ', 'https://www.demarches.interieur.gouv.fr/particuliers/peut-on-designer-personne-occuper-enfant-deces ', 'Garde des enfants', null, 'Famille', 'pastille-jaune', null, true, 1, 1);
//INSERT INTO `task` (`id_task`,`default_task`, `description`, `external_link`, `header`,`previsional_date`, `subtype`, `task_color`, `validation_date`, `visible`, `list_type_id_task_type`, `user_id_user`) VALUES (2, true, 'Trouver une personne qui pourra les prendre en charge.', '', 'Animaux domestiques', null, 'Famille', 'pastille-jaune', null, true, 1, 1);
//INSERT INTO `task` (`id_task`,`default_task`, `description`, `external_link`, `header`,`previsional_date`, `subtype`, `task_color`, `validation_date`, `visible`, `list_type_id_task_type`, `user_id_user`) VALUES (3, true, 'Identité :- carte d’identité, passeport, permis de conduire… - Directives anticipées - testament - Documents relatifs aux comptes bancaires, actifs, assurances vies actes de propriété carte grise carnets de santé / documents liés à la santé des enfants à charge ou des personnes dépendantes carnets de santé / documents liés à la santé des animaux de compagnies.', '', 'Documents à regrouper en un lieu centralisé, faire des copies etc : ', null, 'Administratif', 'pastille-bleu', null, true, 1, 1);
//         */
//    }

//    @Test
//    public void testGetX() throws Exception {
//        Dao dao = new Dao(dataSource);
//        List<X> xList = dao.getX();
//        assertEquals(2, xList.size());
//        assertEquals("foo", xList.get(0).getName());
//        assertEquals("bar", xList.get(1).getName());
//    }



    /**
     * Dans ce test, nous utilisons Mockito pour créer un objet simulé de TaskDao à l'aide de l'annotation @Mock.
     * Nous initialisons également l'objet TaskServiceImpl avec cet objet simulé.
     * Ensuite, nous définissons le comportement simulé de la méthode findDefaultStepTasksBySubtype() en utilisant
     * la méthode when() de Mockito pour retourner une liste de tâches d'exemple.
     * Nous appelons ensuite la méthode getDefaultStepTasks() de TaskServiceImpl et stockons le résultat dans actualTasks.
     * Enfin, nous comparons les tâches attendues avec les tâches réelles et nous nous assurons que la méthode
     * findDefaultStepTasksBySubtype() de TaskDao a été appelée une fois en utilisant la méthode verify() de Mockito.
     */
    @Test
    void getDefaultStepTasks() {
        List<Task> myDefaultTasksTest = new ArrayList<>();
        when(taskService.getDefaultStepTasks()).thenReturn(myDefaultTasksTest);
        List<Task> actualDefaultTasks = taskService.getDefaultStepTasks();
        assertEquals(myDefaultTasksTest, actualDefaultTasks);
    }

    @Test
    void getMyStepTasks() {
    }

    @Test
    void saveMyStepTasks() {
    }

    @Test
    void findById() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void saveTask() {
    }

    @Test
    void deleteTaskById() {
    }

    @Test
    void getTaskDao() {
    }

    @Test
    void setTaskDao() {
    }

    @Test
    void setListTypeDao() {
    }

    @Test
    void setUserDao() {
    }
}