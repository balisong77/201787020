package com.example.hint;

import java.util.ArrayList;

public class Refer{
    public ArrayList<String> sources;
    public ArrayList<String> license;

    public Refer(ArrayList<String> sources, ArrayList<String> license) {
        this.sources = sources;
        this.license = license;
    }
    public Refer(){

    }

    public ArrayList<String> getSources() {
        return sources;
    }

    public void setSources(ArrayList<String> sources) {
        this.sources = sources;
    }

    public ArrayList<String> getLicense() {
        return license;
    }

    public void setLicense(ArrayList<String> license) {
        this.license = license;
    }
}
