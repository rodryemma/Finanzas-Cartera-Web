package finanzas.cartera.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import finanzas.cartera.dto.response.CompraResponseDto;
import finanzas.cartera.dto.resquest.CompraResquestDto;
import finanzas.cartera.model.Compra;
import finanzas.cartera.service.Interface.ICompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getIdCompra(@PathVariable Long id) {
        try{
             return ResponseEntity.status(HttpStatus.OK)
                      .body(iCompraService.getCompraDtoById(id));
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/avg/{idCedear}")
    public ResponseEntity<Object> getCompraPPP(@PathVariable  Long idCedear) {

        System.out.println(idCedear);
        System.out.println(iCompraService.getCompraAvg(idCedear));
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("PPP", iCompraService.getCompraAvg(idCedear)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCompra(@PathVariable Long id, @RequestBody CompraResquestDto compraRequestDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(iCompraService.updateCompra(id,compraRequestDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteCompraById(@PathVariable Long id) {
        try {
            iCompraService.deleteCompra(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(messageSource.getMessage("compra.delete.successful", null, Locale.getDefault()));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
