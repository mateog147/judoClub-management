package modelos;

import java.time.LocalDate;

// La clase judoka corresponde a los miembros activos del club de judo 
public class judoka {
    //Atributos
    private String nombre;
    private String tipoDoc;
    private String doc;
    private String sexo;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    // constructores
    public judoka(String nombre, String tipoDoc, String doc, String sexo, LocalDate fechaNacimiento,
            LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.tipoDoc = tipoDoc;
        this.doc = doc;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }
    public judoka() {
    }

    //metodos de la clase 
    //Setters y Getters
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoDoc() {
        return tipoDoc;
    }
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
    public String getDoc() {
        return doc;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
}
