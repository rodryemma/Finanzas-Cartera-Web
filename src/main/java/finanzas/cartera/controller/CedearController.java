package finanzas.cartera.controller;

import finanzas.cartera.dto.resquest.CedearResquestDto;
import finanzas.cartera.service.impl.CedearServiceImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cedears")
public class CedearController {

    private final ProjectionFactory projectionFactory;
    private final CedearServiceImp cedearServiceImp;

    @Autowired
    public CedearController (ProjectionFactory projectionFactory,CedearServiceImp cedearServiceImp){
        this.projectionFactory = projectionFactory;
        this.cedearServiceImp = cedearServiceImp;
    }

    @PostMapping
    public ResponseEntity<Object> createCedear(@Valid CedearResquestDto cedearResquestDto){
    try {
        return ResponseEntity.status(HttpStatus.CREATED).body(cedearServiceImp.createCedear(cedearResquestDto));
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}
