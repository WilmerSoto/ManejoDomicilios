package com.udea.domicilios.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import javax.validation.constraints.NotNull;


@Entity
@ApiModel(description = "Informacion acerca de los pedidos")
@Table(name = "pedidos")
public class Pedido {
    @ApiModelProperty(notes = "ID Autogenerado")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Integer idPedido;

    @ApiModelProperty(notes = "Llave foranea del cliente")
    @OneToOne
    @JsonIgnoreProperties("pedido")
    @JoinColumn(name = "fkIdCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    @ApiModelProperty(notes = "Nombre del item pedido")
    @Column(name = "nombreItem", length = 50)
    @NotNull
    private String nombreItem;

    @ApiModelProperty(notes = "Valor total del pedido")
    @Column(name = "valorTotal", length = 50)
    @NotNull
    private Long valorTotal;

    @ApiModelProperty(notes = "Direccion entrega del pedido")
    @Column(name = "direccionEntrega", length = 15)
    private String direccionEntrega;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }
}
