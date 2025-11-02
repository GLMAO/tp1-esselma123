package org.emp.gl.clients;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class HorlogeGUI extends JFrame implements TimerChangeListener {

    private JLabel timeLabel;
    private TimerService timerService;

    public HorlogeGUI(TimerService timerService) {
        this.timerService = timerService;
        timerService.addTimeChangeListener(this);

        setTitle("Horloge Graphique");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel);

        updateTime();
        setVisible(true);
    }

    private void updateTime() {
        timeLabel.setText(String.format("%02d:%02d:%02d",
                timerService.getHeures(),
                timerService.getMinutes(),
                timerService.getSecondes()));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(TimerChangeListener.SECONDE_PROP)) {
            updateTime();
        }
    }
}