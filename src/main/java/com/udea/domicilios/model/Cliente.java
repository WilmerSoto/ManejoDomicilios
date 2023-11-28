package com.udea.domicilios.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@ApiModel(description = "Informacion acerca de los clientes")
@Table(name = "clientes")
public class Cliente {
    @ApiModelProperty(notes = "ID Autogenerado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Integer idCliente;

    @ApiModelProperty(notes = "Referencia OneToOne al pedido")
    @OneToOne(mappedBy = "idCliente")
    @JsonIgnoreProperties("cliente")
    private Pedido pedido;

    @ApiModelProperty(notes = "Nombre del cliente")
    @Column(name = "nombre", length = 50)
    @NotNull
    private String nombre;

    @ApiModelProperty(notes = "Apellido del cliente")
    @Column(name = "apellido", length = 50)
    @NotNull
    private String apellido;

    @ApiModelProperty(notes = "Cedula del cliente")
    @Column(name = "cedula", length = 10, unique = true)
    @NotNull
    private String cedula;

    @ApiModelProperty(notes = "Celular del cliente")
    @Column(name = "celular", length = 15)
    private String celular;

    @ApiModelProperty(notes = "Email del cliente")
    @Column(name = "email", length = 100, unique = true)
    @NotNull
    private String email;

    @ApiModelProperty(notes = "Edad del cliente")
    @Column(name = "edad")
    private Integer edad;

    @ApiModelProperty(notes = "Numero total de pedidos del cliente")
    @Column(name = "numPedidos")
    private Integer numPedidos;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(Integer numPedidos) {
        this.numPedidos = numPedidos;
    }
}
