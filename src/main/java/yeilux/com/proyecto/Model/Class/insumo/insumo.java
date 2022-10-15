package yeilux.com.proyecto.Model.Class.insumo;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import yeilux.com.proyecto.Model.Class.fabricacion.fabricacion;
import yeilux.com.proyecto.Model.Class.inventario.insumo.inventario;
import yeilux.com.proyecto.Model.Class.proveedor.proveedor;

@Entity
@Table(name="insumo")
public class insumo {
// -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

//----------------NOMBRE-------------//
@NotEmpty
@Column(length = 60)
@Size(min = 2, max = 60)
private String nombre;
//--------------Descripcion---------------//
@NotEmpty
@Column(length = 200)
@Size(min = 2, max = 200)
private String descripcion;
//--------------Imagen---------------//
//--------------Material insumo---------------//
@NotEmpty
@Column(length = 200)
@Size(min = 2, max = 200)
private String material;
//--------------Estado---------------//
@Column(nullable = false)
    private Boolean estado=true;
// ************************************************//
// -------------Relacion con tipo------------------//
// ************************************************//
@ManyToMany
@JsonBackReference
@JoinTable(
    name = "insumo_tipo",
    joinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_tipo", referencedColumnName = "id"))
private Set<tipo> tipo = new HashSet<>();
// ************************************************//
// -------------Relacion con proveedor-------------//
// ************************************************//
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "proveedor_id")
@JsonProperty(access = Access.WRITE_ONLY)
private proveedor proveedor;
// ************************************************//
// -------------Relacion con fabricacion-----------//
// ************************************************//
@ManyToMany
@JoinTable(
    name = "fabricacion_insumo",
    joinColumns = @JoinColumn(name = "id_fabricacion", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "id_insumo", referencedColumnName = "id"))
private Set<fabricacion> fabricacion = new HashSet<>();
// ************************************************//
// -------------Relacion con inventario------------//
// ************************************************//
@OneToMany(mappedBy = "insumo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<inventario> inventario = new HashSet<>();
//---------GETTERS AND SETTERS---------------------//
    
}