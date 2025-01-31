package fastock.fastock.Mapping.usuario;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DTOCreateCargo {

    // -----------------------NOMBRE-----------------------//
    @NotEmpty(message = "El nombre no debe estar vacío")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String nombre;
    // -----------------------Estado-----------------------//
    @NotNull(message = "El estado no debe estar vacío")
    private Boolean estado;
    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DTOCreateCargo() {
    }

    public Boolean getEstado() {
        return estado;
    }

    public DTOCreateCargo(
            @NotEmpty(message = "El nombre no debe estar vacío") @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres") String nombre,
            @NotNull(message = "El estado no debe estar vacío") Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
