package org.emp.gl.timer.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface TimerChangeListener extends PropertyChangeListener {

    final static String DIXEME_DE_SECONDE_PROP = "dixième";
    final static String SECONDE_PROP = "seconde";
    final static String MINUTE_PROP = "minute";
    final static String HEURE_PROP = "heure";

    // Méthode standard de PropertyChangeListener
    @Override
    void propertyChange(PropertyChangeEvent evt);
}