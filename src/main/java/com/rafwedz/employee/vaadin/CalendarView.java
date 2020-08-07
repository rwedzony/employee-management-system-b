package com.rafwedz.employee.vaadin;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import elemental.json.Json;
import elemental.json.JsonObject;
import org.vaadin.stefan.fullcalendar.Entry;
import org.vaadin.stefan.fullcalendar.EntryClickedEvent;
import org.vaadin.stefan.fullcalendar.FullCalendar;
import org.vaadin.stefan.fullcalendar.FullCalendarBuilder;

import java.time.LocalDate;

@PageTitle("Calendar | EMS")
@Route(value="Calendar",layout=MainLayout.class)
public class CalendarView extends VerticalLayout {


    public CalendarView() {

        JsonObject initialOptions = Json.createObject();

        initialOptions.put("weekNumbers",false);

        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        FullCalendar calendar = FullCalendarBuilder.create().build();
        add(calendar);


        Entry entry = new Entry();
        entry.setTitle("Some event");
        entry.setStart(LocalDate.now().withDayOfMonth(3).atTime(10, 0), calendar.getTimezone());
        entry.setEnd(entry.getStart().plusHours(2), calendar.getTimezone());
        entry.setColor("#ff3333");

        calendar.addEntry(entry);
        calendar.setEntryRenderCallback("" +
                "function(info) {" +
                "   alert('hello');" +
                "}"
        );

        calendar.addEntryClickedListener(event-> someFunction(event));
        System.out.println("Constructor called!");

    }

    private void someFunction(EntryClickedEvent event) {
        System.out.println(event.toString());
    }
}
