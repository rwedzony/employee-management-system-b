package com.rafwedz.employee.vaadin;


import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class VaadinUI extends VerticalLayout implements View {

    public VaadinUI() {
        Button button1 = new Button("Show grid list");
        Button button2 = new Button("Show form");

        addComponents(button1, button2);
    }

}