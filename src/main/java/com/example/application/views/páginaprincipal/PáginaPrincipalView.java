package com.example.application.views.páginaprincipal;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Página Principal")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@PermitAll
public class PáginaPrincipalView extends Composite<VerticalLayout> {

    public PáginaPrincipalView() {
        Hr hr = new Hr();
        Tabs tabs = new Tabs();
        H1 h1 = new H1();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h1.setText("------------PROYECTO FINAL DEL GRUPO 6 - GESTOR DE EMPLEADOS-------------");
        h1.setWidth("1500px");
        h1.setHeight("800px");
        getContent().add(hr);
        getContent().add(tabs);
        getContent().add(h1);
    }


}