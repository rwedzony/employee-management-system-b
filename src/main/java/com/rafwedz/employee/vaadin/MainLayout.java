package com.rafwedz.employee.vaadin;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightCondition;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {


    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        RouterLink dashboardlink=new RouterLink("Dashboard",DashboardView.class);
        RouterLink employeelink=new RouterLink("Employees",ListView.class);
        RouterLink calendarlink=new RouterLink("Calendar",CalendarView.class);
       // employeelink.setHighlightCondition(HighlightConditions.sameLocation());

        //dashboardlink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
                dashboardlink,
                employeelink,
                calendarlink

        ));
    }

    private void createHeader() {
        H1 h1Header=new H1("Employee Management System");
        h1Header.addClassName("logo");
        HorizontalLayout header=new HorizontalLayout(new DrawerToggle(),h1Header);
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);

    }
}
