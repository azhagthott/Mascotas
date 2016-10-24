package com.zecovery.android.mascotas.app;

/**
 * Created by moe on 24-10-16.
 */

public class Mascota {

    private int numeroFolio;
    private int numeroIngreso;
    private String tipoTenencia;
    private String nombrePropietario;
    private String apellidoPaternoPropietario;
    private String apellidoMaternoPropietario;
    private String rutPropietario;
    private String calle;
    private String numeroDepartamento;
    private String region;
    private String comuna;
    private String telefonoFijo;
    private String telefonoCelular;
    private String correoElectronico;
    private String paciente;
    private String especie;
    private String sexo;
    private String fechaNacimiento;
    private int color;
    private int razaPerro;
    private int razaGato;
    private int numeroIdentificacionAnterior;
    private String comoRecibio;
    private String razonTenencia;

    public Mascota() {
    }

    public Mascota(int numeroFolio, int numeroIngreso, String tipoTenencia, String nombrePropietario,
                   String apellidoPaternoPropietario, String apellidoMaternoPropietario, String rutPropietario,
                   String calle, String numeroDepartamento, String region, String comuna, String telefonoFijo,
                   String telefonoCelular, String correoElectronico, String paciente, String especie,
                   String sexo, String fechaNacimiento, int color, int razaPerro, int razaGato,
                   int numeroIdentificacionAnterior, String comoRecibio, String razonTenencia) {
        this.numeroFolio = numeroFolio;
        this.numeroIngreso = numeroIngreso;
        this.tipoTenencia = tipoTenencia;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPaternoPropietario = apellidoPaternoPropietario;
        this.apellidoMaternoPropietario = apellidoMaternoPropietario;
        this.rutPropietario = rutPropietario;
        this.calle = calle;
        this.numeroDepartamento = numeroDepartamento;
        this.region = region;
        this.comuna = comuna;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCelular = telefonoCelular;
        this.correoElectronico = correoElectronico;
        this.paciente = paciente;
        this.especie = especie;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.color = color;
        this.razaPerro = razaPerro;
        this.razaGato = razaGato;
        this.numeroIdentificacionAnterior = numeroIdentificacionAnterior;
        this.comoRecibio = comoRecibio;
        this.razonTenencia = razonTenencia;
    }

    public int getNumeroFolio() {
        return numeroFolio;
    }

    public void setNumeroFolio(int numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    public int getNumeroIngreso() {
        return numeroIngreso;
    }

    public void setNumeroIngreso(int numeroIngreso) {
        this.numeroIngreso = numeroIngreso;
    }

    public String getTipoTenencia() {
        return tipoTenencia;
    }

    public void setTipoTenencia(String tipoTenencia) {
        this.tipoTenencia = tipoTenencia;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidoPaternoPropietario() {
        return apellidoPaternoPropietario;
    }

    public void setApellidoPaternoPropietario(String apellidoPaternoPropietario) {
        this.apellidoPaternoPropietario = apellidoPaternoPropietario;
    }

    public String getApellidoMaternoPropietario() {
        return apellidoMaternoPropietario;
    }

    public void setApellidoMaternoPropietario(String apellidoMaternoPropietario) {
        this.apellidoMaternoPropietario = apellidoMaternoPropietario;
    }

    public String getRutPropietario() {
        return rutPropietario;
    }

    public void setRutPropietario(String rutPropietario) {
        this.rutPropietario = rutPropietario;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(String numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRazaPerro() {
        return razaPerro;
    }

    public void setRazaPerro(int razaPerro) {
        this.razaPerro = razaPerro;
    }

    public int getRazaGato() {
        return razaGato;
    }

    public void setRazaGato(int razaGato) {
        this.razaGato = razaGato;
    }

    public int getNumeroIdentificacionAnterior() {
        return numeroIdentificacionAnterior;
    }

    public void setNumeroIdentificacionAnterior(int numeroIdentificacionAnterior) {
        this.numeroIdentificacionAnterior = numeroIdentificacionAnterior;
    }

    public String getComoRecibio() {
        return comoRecibio;
    }

    public void setComoRecibio(String comoRecibio) {
        this.comoRecibio = comoRecibio;
    }

    public String getRazonTenencia() {
        return razonTenencia;
    }

    public void setRazonTenencia(String razonTenencia) {
        this.razonTenencia = razonTenencia;
    }
}
