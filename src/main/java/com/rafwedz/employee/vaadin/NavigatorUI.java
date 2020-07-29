package com.rafwedz.employee.vaadin;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import lombok.Getter;


@SpringUI
public class NavigatorUI extends UI {

    @Getter
    private Navigator navigator;

    @Override
    protected void init(VaadinRequest request) {
        navigator = new Navigator(this, this);
        setNavigator(navigator);
        navigator.addView("" , new VaadinUI());
    }
}
