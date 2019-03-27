package com.example.sh.morningtext.gitproject.eventbus;

import java.util.Objects;

public class MessageEvent {

    public String mes;

    public MessageEvent(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes == null ? "" : mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "MessageEvent{" +
                "mes='" + mes + '\'' +
                '}';
    }
}
