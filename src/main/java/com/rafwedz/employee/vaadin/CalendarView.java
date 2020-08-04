package com.rafwedz.employee.vaadin;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

@PageTitle("Calendar | EMS")
@Route(value="Calendar",layout=MainLayout.class)
public class CalendarView extends VerticalLayout {

    public CalendarView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        FullCalendar calendar = FullCalendarBuilder.create().build();
        add(calendar);
        //container.setFlexGrow(1, calendar);

        add(new Label("calendar label"));
    }
}
