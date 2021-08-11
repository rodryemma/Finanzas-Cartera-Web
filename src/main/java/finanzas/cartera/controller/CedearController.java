package finanzas.cartera.controller;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.dto.resquest.CedearResquestDto;
import finanzas.cartera.service.Interface.ICedear;
import finanzas.cartera.service.impl.CedearServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cedears")
public class CedearController {

    private final ICedear IcedearService;

    @Autowired
    public CedearController (ICedear IcedearService){
        this.IcedearService = IcedearService;
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
}
