package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> employees = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        System.out.println("TO DO 1");

        employees.forEach(System.out::println);

        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        System.out.println("TO DO 2");

        employees.stream().filter(s -> s.getName().startsWith("n")).forEach(System.out::println);

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        System.out.println("TO DO 3");

        employees.stream().filter(s -> s.getName().startsWith("n")).filter(s -> s.getSalary() > 100000).forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        System.out.println("TO DO 4");

        employees.stream().filter(s->s.getSubject().equals(Subject.JAVA)).sorted(Comparator.comparing(Teacher::getSalary)).forEach(s->System.out.println());

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */
        System.out.println("TO DO 5");

        /* First Way */
        employees.stream().filter(s->s.getSalary()>60000).forEach(System.out::println);
        /* Second Way */
        employees.stream().filter(s->s.getSalary()>60000).map(Teacher::getName).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        System.out.println("TO DO 6");

        employees.stream().filter(n->n.getName().startsWith("m"))
                .peek(t->t.setSalary(t.getSalary()+200))
                .max(Comparator.comparingInt(Teacher::getSalary))
                .orElse(null);

    }
}