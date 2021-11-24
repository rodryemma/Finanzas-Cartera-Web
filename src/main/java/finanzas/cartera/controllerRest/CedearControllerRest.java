package finanzas.cartera.controllerRest;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.dto.resquest.CedearResquestDto;
import finanzas.cartera.service.Interface.ICedear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

//@RestController
@RequestMapping("/cedears")
public class CedearControllerRest {

    private final ICedear IcedearService;
    private final ProjectionFactory projectionFactory;
    private final MessageSource messageSource;

    @Autowired
    public CedearControllerRest(ICedear IcedearService, ProjectionFactory projectionFactory, MessageSource messageSource){
        this.IcedearService = IcedearService;
        this.projectionFactory = projectionFactory;
        this.messageSource = messageSource;
    }

    @PostMapping
    public ResponseEntity<?> createCedear(@Valid @RequestBody CedearResquestDto cedearResquestDto){
        System.out.println("Estamos CreateCedear Repositorio");
        System.out.println("Cantidad = "+cedearResquestDto.getCantidad()+"// Simbolo =  "+cedearResquestDto.getSimbolo()+"// Nombre = "+cedearResquestDto.getNombre());
    try {
        return ResponseEntity.status(HttpStatus.CREATED).body(IcedearService.createCedear(cedearResquestDto));
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CedearResponseDto>> getAllCedear() {
        return ResponseEntity.status(HttpStatus.OK).body(IcedearService.getAllCedear());
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getCedearById(@RequestBody @PathVariable Long id) {
    try {
         return ResponseEntity.status(HttpStatus.OK)
                    .body(projectionFactory.createProjection(CedearResponseDto.class, IcedearService.getCedearById(id)));
    } catch (Exception e) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCedear(@PathVariable Long id, @RequestBody CedearResquestDto cedearRequestDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(IcedearService.updateCedear(id,cedearRequestDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCedearById(@PathVariable Long id) {
        try {
            IcedearService.deleteCedear(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(messageSource.getMessage("cedear.delete.successful", null, Locale.getDefault()));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



}
