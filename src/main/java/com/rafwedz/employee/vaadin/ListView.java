package com.rafwedz.employee.vaadin;



import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.services.EmployeeService;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;

import com.vaadin.flow.component.grid.Grid;

import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="employees",layout=MainLayout.class)
@PageTitle("Employee List | EMS")
public class ListView extends VerticalLayout {

    Grid<Employee> grid=new Grid<>(Employee.class);
    TextField filterText=new TextField();
    private EmployeeService employeeService;
    private final EmployeeForm form;

    public ListView(EmployeeService employeeService){
        this.employeeService=employeeService;
        addClassName("list-view");
        setSizeFull();
        configureGrid();


        form=new EmployeeForm();
        form.addListener(EmployeeForm.SaveEvent.class,this::saveEmployee);
        form.addListener(EmployeeForm.DeleteEvent.class,this::deleteEmployee);
        form.addListener(EmployeeForm.CloseEvent.class,e->closeEditor());

        Div content=new Div(grid,form);
        content.addClassName("content");
        content.setSizeFull();

        add(gertToolBar(),content);
        updateList();
        closeEditor();
    }

    private void deleteEmployee(EmployeeForm.DeleteEvent evt) {
        employeeService.delete(evt.getEmployee());
        updateList();
        closeEditor();

    }

    private void saveEmployee(EmployeeForm.SaveEvent evt) {
     employeeService.save(evt.getEmployee());
     updateList();
     closeEditor();
    }

    private void closeEditor() {
        form.setVisible(false);
        removeClassName("editing");
    }

    private Component gertToolBar() {
        filterText.setPlaceholder("Filter by name....");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e->updateList());
        Button addContactButton=new Button ("Add contact",click->addEmployee());

        HorizontalLayout toolbar=new HorizontalLayout(filterText,addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;


    }

    private void addEmployee() {
        grid.asSingleSelect().clear();
        editEmployee(new Employee());
    }

    private void updateList() {
        grid.setItems(employeeService.getAllEmployees(filterText.getValue()));
    }

    private void configureGrid() {
        grid.addClassName("employee-grid");
        grid.setSizeFull();
        grid.removeColumnByKey("currentMonthWorkingHours");
        grid.setColumns("firstName","lastName","email","role");
        grid.getColumns().forEach(col->col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(evt->editEmployee(evt.getValue()));

    }

    private void editEmployee(Employee employee) {
        if(employee==null){
            closeEditor();
        }
        else{
         form.setEmployee(employee);
         form.setVisible(true);
         addClassName("editing");
        }
    }

}
