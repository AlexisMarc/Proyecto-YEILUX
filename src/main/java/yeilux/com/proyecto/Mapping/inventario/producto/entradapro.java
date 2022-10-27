package yeilux.com.proyecto.Mapping.inventario.producto;

import yeilux.com.proyecto.Class.usuario.usuario;

import javax.validation.constraints.NotNull;

public class entradapro {

    // -----------------------ID-----------------------//
    private Integer id;

    // -----------------------FECHA_ENTRADA-----------------------//
    private String fecha;
    // -----------------------CANTIDAD_ENTRADA-----------------------//
    @NotNull(message = "La cantidad no debe estar vacía")
    private Integer cantidad;
    // -----------------------ESTADO-----------------------//
    private Boolean estado;

    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    private inventariopro inventario;

    // ************************************************//
    // -------------Relacion con usuario--------------//
    // ************************************************//
    private usuario usuario;

    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//
    public entradapro() {
    }

}
