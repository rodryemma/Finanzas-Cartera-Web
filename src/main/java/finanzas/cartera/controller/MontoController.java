package finanzas.cartera.controller;

import finanzas.cartera.dto.resquest.MontoResquestDto;
import finanzas.cartera.service.Interface.IMonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/monto")
public class MontoController {

    private final IMonto iMontoService;
    private final ProjectionFactory projectionFactory;
    private final MessageSource messageSource;

    @Autowired
    public MontoController (IMonto iMontoService,ProjectionFactory projectionFactory,MessageSource messageSource){
        this.iMontoService = iMontoService;
        this.projectionFactory = projectionFactory;
        this.messageSource = messageSource;
    }


    @PostMapping
    public ResponseEntity<?> createMonto(@Valid @RequestBody MontoResquestDto montoResquestDto){

        System.out.println("Estamos CreateMonto Repositorio");
        System.out.println("Monto actual: "+montoResquestDto.getMontoActual()+"//");
        System.out.println("Monto retirado: "+montoResquestDto.getMontoRetirado()+"//");
        System.out.println("Monto ingresado: "+montoResquestDto.getMontoIngresado()+"//");

    try {
        return ResponseEntity.status(HttpStatus.CREATED).body(iMontoService.createMonto(montoResquestDto));
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


}
