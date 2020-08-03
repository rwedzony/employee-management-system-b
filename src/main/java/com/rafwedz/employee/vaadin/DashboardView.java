package com.rafwedz.employee.vaadin;

import com.rafwedz.employee.services.EmployeeService;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Dashboard | EMS")
@Route(value="",layout=MainLayout.class)
public class DashboardView extends VerticalLayout {

    private final EmployeeService employeeService;
    public DashboardView(EmployeeService employeeService) {
        this.employeeService=employeeService;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add (
        new Label(getContactStats().getText())
       // getEmployeesChart()
        );

    }

//    private Component getEmployeesChart() {
//        Chart chart=new Chart(CharType.PIE);
//    }

    private Span getContactStats() {
        Span stats=new Span(employeeService.count()+"employees");
        stats.addClassName("employees-stats");
        return stats;

    }
}
