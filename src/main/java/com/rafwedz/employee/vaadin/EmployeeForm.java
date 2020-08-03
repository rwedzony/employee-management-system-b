package com.rafwedz.employee.vaadin;

import com.rafwedz.employee.models.Employee;
import com.rafwedz.employee.services.EmployeeService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;
import org.springframework.beans.factory.annotation.Autowired;


public class EmployeeForm extends FormLayout {
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    TextField role = new TextField("role");


    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Cancel");

    Binder<Employee> binder =new Binder<>(Employee.class);


    public EmployeeForm() {
        addClassName("employee-form");
        binder.bindInstanceFields(this);

        add(
                firstName,
                lastName,
                email,
                role,
                createButtonsLayout()
        );
    }
    public void setEmployee(Employee employee)
    {
        binder.setBean(employee);
    }
    private Component createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(click->validateAndSave());
        delete.addClickListener(click-> fireEvent(new DeleteEvent(this,binder.getBean())));
        close.addClickListener(click->fireEvent(new CloseEvent(this)));


        return new HorizontalLayout(save,delete,close);
    }

    private void validateAndSave() {
        if(binder.isValid()){
            fireEvent(new SaveEvent(this,binder.getBean()));
        }
    }

    public static abstract class EmployeeFormEvent extends ComponentEvent<EmployeeForm> {
        private Employee employee;

        protected EmployeeFormEvent(EmployeeForm source, Employee employee) {
            super(source, false);
            this.employee = employee;
        }

        public Employee getEmployee() {
            return employee;
        }
    }

    public static class SaveEvent extends EmployeeFormEvent {
        SaveEvent(EmployeeForm source, Employee employee) {
            super(source, employee);
        }
    }

    public static class DeleteEvent extends EmployeeFormEvent {
        DeleteEvent(EmployeeForm source, Employee employee) {
            super(source, employee);
        }

    }

    public static class CloseEvent extends EmployeeFormEvent {
        CloseEvent(EmployeeForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
                                                                  ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }

}




