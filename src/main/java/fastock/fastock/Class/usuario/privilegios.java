package fastock.fastock.Class.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fastock.fastock.Utils.EnumPrivilegios;

@Entity
@Table(name = "privilegio")
public class privilegios {
    // -----------------------ID-----------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // -----------------------privilegio-----------------------//
    @Column(length = 30, nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumPrivilegios privilegio;

    // ************************************************//
    // -------------Relacion con cargo--------------//
    // ************************************************//
    @ManyToMany
    @JsonIgnoreProperties(value = "privilegio_cargo")
    @JoinTable(name = "privilegio_cargo", joinColumns = @JoinColumn(name = "id_privilegio", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_cargo", referencedColumnName = "id"))
    private Set<cargo> cargo = new HashSet<>();

    // ************************************************//
    // ------------- CONSTRUCTORES/GETTERS AND SETTERS--------------//
    // ************************************************//

    public privilegios() {
    }

    public privilegios(Integer id, EnumPrivilegios privilegio, Set<cargo> cargo) {
        this.id = id;
        this.privilegio = privilegio;
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EnumPrivilegios getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(EnumPrivilegios privilegio) {
        this.privilegio = privilegio;
    }

    public Set<cargo> getCargo() {
        return cargo;
    }

    public void setCargo(Set<cargo> cargo) {
        this.cargo = cargo;
    }

}
