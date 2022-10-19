package yeilux.com.proyecto.Model.Class.producto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.producto.inventariopro;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "producto")
public class producto {

    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // -----------------------NOMBRE-----------------------//
    @NotEmpty
    @Column(length = 60)
    @Size(min = 2, max = 60)
    private String nombre;

    // -----------------------Descri Producto-----------------------//
    @NotEmpty
    @Column(length = 200)
    @Size(min = 2, max = 200)
    private String descripcion;

    // -----------------------Estado-----------------------//
    @Column(nullable = false)
    private Boolean estado=true;

    // -----------------------Imagen-----------------------//
    private String imagen;


    // ************************************************//
    // -------------Relacion con Categoria-------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "producto_categoria")
@JoinTable(
    name = "producto_categoria",
    joinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_categoria", referencedColumnName = "id"))
private Set<categoria> categoria = new HashSet<>();
    // ************************************************//
    // -------------Relacion con fabricacion-----------//
    
    // ************************************************//
    @JsonBackReference(value = "fabricacion_producto")
    @ManyToMany
@JoinTable(
    name = "fabricacion_producto",
    joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_producto", referencedColumnName = "id"))
private Set<fabricacion> fabricacion = new HashSet<>();
    // ************************************************//
    // -------------Relacion con inventario------------//
    // ************************************************//
    @JsonManagedReference(value = "producto_inventario")
    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<inventariopro> inventario = new HashSet<>();
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Set<categoria> getCategoria() {
        return categoria;
    }
    public void setCategoria(Set<categoria> categoria) {
        this.categoria = categoria;
    }
    public Set<fabricacion> getFabricacion() {
        return fabricacion;
    }
    public void setFabricacion(Set<fabricacion> fabricacion) {
        this.fabricacion = fabricacion;
    }
    public Set<inventariopro> getInventario() {
        return inventario;
    }
    public void setInventario(Set<inventariopro> inventario) {
        this.inventario = inventario;
    }
    public producto(Integer id, @NotEmpty @Size(min = 2, max = 60) String nombre,
            @NotEmpty @Size(min = 2, max = 200) String descripcion, Boolean estado, String imagen,
            Set<categoria> categoria,
            Set<fabricacion> fabricacion, Set<inventariopro> inventario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.imagen = imagen;
        this.categoria = categoria;
        this.fabricacion = fabricacion;
        this.inventario = inventario;
    }


    
    // ************************************************//
    // -------------Contructores accesores--------------//
    // ************************************************//

    

}
