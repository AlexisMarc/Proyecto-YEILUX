package yeilux.com.proyecto.Controller.empresa;


import javax.validation.Valid;
import java.net.URI;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import yeilux.com.proyecto.Model.Class.empresa.empresa;
import yeilux.com.proyecto.Model.Class.empresa.especialidad;
import yeilux.com.proyecto.Model.Interface.Empresa.IEmpresa;
import yeilux.com.proyecto.Model.Interface.Empresa.IEspecialidad;


@RestController
@SessionAttributes("empresa")
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private IEmpresa iempresa;

    @Autowired
    private IEspecialidad iespecialidad;

// ****************************************//
// --------------METODO GET----------------//
// ****************************************//

// --------------LISTAR TODOS--------------//
@GetMapping
	public ResponseEntity<Page<empresa>> empresas(Pageable pageable){
		return ResponseEntity.ok(iempresa.findAll(pageable));
	}

// ---------------LISTAR UNO---------------//
@GetMapping("/{id}")
	public ResponseEntity<empresa> empresa(@PathVariable Integer id){
		Optional<empresa> empresaOptional = iempresa.findById(id);
		
		if(!empresaOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(empresaOptional.get());
	}


// ****************************************//
// -------------METODO POST----------------//
// ****************************************//

// ---------------REGISTRAR----------------//
@PostMapping
	public ResponseEntity<empresa> guardarempresa(@Valid @RequestBody empresa empresa){
		Optional<especialidad> especialidadOptional = iespecialidad.findById(empresa.getEspecialidad().getId());
		
		if(!especialidadOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		empresa.setEspecialidad(especialidadOptional.get());
		empresa empresaGuardado = iempresa.save(empresa);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(empresaGuardado.getId()).toUri();
		
		return ResponseEntity.created(ubicacion).body(empresaGuardado);
	}

// ****************************************//
// --------------METODO PUT----------------//
// ****************************************//

// ----------------EDITAR------------------//
@PutMapping("/{id}")
	public ResponseEntity<empresa> actualizarempresa(@Valid @RequestBody empresa empresa,@PathVariable Integer id){
		Optional<especialidad> especialidadOptional = iespecialidad.findById(empresa.getEspecialidad().getId());
		
		if(!especialidadOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		Optional<empresa> empresaOptional = iempresa.findById(id);
		if(!empresaOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		empresa.setEspecialidad(especialidadOptional.get());
		empresa.setId(empresaOptional.get().getId());
		iempresa.save(empresa);
		
		return ResponseEntity.noContent().build();
	}



// ----------------ESTADO------------------//



}
