package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.Arrays;

public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view){
        this.view = view;
    }
    @Override
    public void menuSelected(MenuEvent e) {
        JMenu source =(JMenu) e.getSource();
        Component[] components = source.getMenuComponents();
        Arrays.stream(components).forEach(component -> component.setEnabled(view.isHtmlTabSelected()));
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
