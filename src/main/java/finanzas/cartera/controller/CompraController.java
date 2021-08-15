package finanzas.cartera.controller;

import finanzas.cartera.dto.response.CompraResponseDto;
import finanzas.cartera.dto.resquest.CompraResquestDto;
import finanzas.cartera.service.Interface.ICompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cedears/compra")
public class CompraController {

    private final ICompra iCompraService;
    private final ProjectionFactory projectionFactory;
    private final MessageSource messageSource;

    @Autowired
    public CompraController (ICompra iCompraService,ProjectionFactory projectionFactory,MessageSource messageSource){
        this.iCompraService = iCompraService;
        this.projectionFactory = projectionFactory;
        this.messageSource = messageSource;
    }


    @PostMapping
    public ResponseEntity<?> createCompra(@Valid @RequestBody CompraResquestDto compraResquestDto){

        System.out.println("Estamos CreateCompra Repositorio");
        System.out.println("Nro de compra: "+compraResquestDto.getNroCompra()+"//");
        System.out.println("Cant  de compra: "+compraResquestDto.getCantidadCompra()+"//");
        System.out.println("Precio dolar CCL: "+compraResquestDto.getPrecioCompraD()+"//");
        System.out.println("Precio Ars: "+compraResquestDto.getPrecioCompraP()+"//");

    try {
        return ResponseEntity.status(HttpStatus.CREATED).body(iCompraService.createCompra(compraResquestDto));
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CompraResponseDto>> getAllCompra() {
        return ResponseEntity.status(HttpStatus.OK).body(iCompraService.getAllCompra());
    }



}
