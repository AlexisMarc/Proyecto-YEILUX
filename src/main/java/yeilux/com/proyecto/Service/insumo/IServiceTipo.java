package yeilux.com.proyecto.Service.insumo;

import java.util.List;

import yeilux.com.proyecto.Model.Class.insumo.tipo;

public interface IServiceTipo{

    public List<tipo>listar();
    public void guardar(tipo tipo);
    public tipo consulta(Integer id);
    public void eliminar(Integer id);
    public void eliminarTipos();
    public List<tipo>insumoTipo();
    public void eliminarTipo(tipo tipo);
    public void agregarTipo(tipo tipo);
}
