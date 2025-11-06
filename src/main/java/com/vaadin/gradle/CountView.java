package com.vaadin.gradle;

import static com.vaadin.flow.component.ComponentEffect.bind;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.signals.NumberSignal;

@Route("count")
public class CountView extends VerticalLayout {

    CountView() {
        var count = new NumberSignal();
        var status = new H1();
        bind(status, count, (_, _) -> status.setText(String.valueOf(count.value())));
        add(status, new Button("Increment", e -> count.incrementBy(1)));
    }
}
