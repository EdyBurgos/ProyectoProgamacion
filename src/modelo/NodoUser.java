package modelo;

import java.time.LocalDate;
import java.util.Date;

public class NodoUser {

    private String nombre;
    private String correo;
    private String contrasenia;
    private String numTelefono;
    private LocalDate fechaNac;
    private NodoUser sig;
    private NodoUser ant;

    public NodoUser(String nombre, String correo, String contrasenia, String numTelefono, LocalDate fechaNac) {

        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.numTelefono = numTelefono;
        this.fechaNac = fechaNac;
        this.sig = null;
        this.ant = null;
    }

    public NodoUser getSig() {
        return sig;
    }

    public void setSig(NodoUser sig) {
        this.sig = sig;
    }

    public NodoUser getAnt() {
        return ant;
    }

    public void setAnt(NodoUser ant) {
        this.ant = ant;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

}
