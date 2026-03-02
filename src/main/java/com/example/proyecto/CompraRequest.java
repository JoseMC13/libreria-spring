package com.example.proyecto;


import java.util.List;

public class CompraRequest {
    private List<CompraItem> items;

    public CompraRequest() {
    }

    public CompraRequest(List<CompraItem> items) {
        this.items = items;
    }

    public List<CompraItem> getItems() {
        return items;
    }
}
