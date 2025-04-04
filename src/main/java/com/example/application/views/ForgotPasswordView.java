package com.example.application.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("Recuperar Contraseña")
@Route(value = "forgot-password")
public class ForgotPasswordView extends VerticalLayout {

    public ForgotPasswordView() {
        add(new com.vaadin.flow.component.Component[]{new Label("Tu nueva contraseña es: admin")});
    }
}