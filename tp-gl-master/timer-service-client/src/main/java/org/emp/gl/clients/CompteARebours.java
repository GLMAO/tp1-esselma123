package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import java.beans.PropertyChangeEvent;

public class CompteARebours implements TimerChangeListener {

    private String name;
    private int count;
    private TimerService timerService;

    public CompteARebours(String name, int initialCount, TimerService timerService) {
        this.name = name;
        this.count = initialCount;
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);
        System.out.println("CompteARebours " + name + " initialized with " + initialCount);
    }

    private void afficherCompte() {
        System.out.println(name + " : " + count);
    }

    @Override  // Correction de la faute de frappe
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            if (count > 0) {
                count--;
                afficherCompte();
                if (count <= 0) {
                    timerService.removeTimeChangeListener(this);
                    System.out.println(name + " reached 0 and unsubscribed.");
                }
            }
        }
    }
}