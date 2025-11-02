package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.clients.HorlogeGUI;  // Ajoutez cet import pour le bonus
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        testDuTimeService();
    }

    private static void testDuTimeService() {
        TimerService timerService = new DummyTimeServiceImpl();  // Instanciation de l'implémentation

        // Instancier plusieurs Horloges
        Horloge horloge1 = new Horloge("Num 1", timerService);
        Horloge horloge2 = new Horloge("Num 2", timerService);
        Horloge horloge3 = new Horloge("Num 3", timerService);

        // 1. Instancier avec 5
        CompteARebours car1 = new CompteARebours("CAR1", 5, timerService);

        // 3. Instancier 10 avec valeurs aléatoires 10-20
        for (int i = 1; i <= 10; i++) {
            int randomValue = (int) (Math.random() * 11) + 10;  // 10 à 20 inclus
            new CompteARebours("CAR" + (i + 1), randomValue, timerService);
        }


         try {
             Thread.sleep(30000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

        // Bonus : Instancier la GUI (commentez les sleep si utilisé)
        new HorlogeGUI(timerService);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}