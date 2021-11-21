package finanzas.cartera.controllerRest;


import finanzas.cartera.dto.response.VentaResponseDto;
import finanzas.cartera.dto.resquest.VentaResquestDto;
import finanzas.cartera.service.Interface.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("cedears/venta")
public class VentaController {

    private final IVenta iVentaService;
    private final ProjectionFactory projectionFactory;
    private final MessageSource messageSource;

    @Autowired
    public VentaController (IVenta iVentaService,ProjectionFactory projectionFactory,MessageSource messageSource){
        this.iVentaService=iVentaService;
        this.projectionFactory=projectionFactory;
        this.messageSource=messageSource;
    }


    @PostMapping
    public ResponseEntity<?> createVenta(@Valid @RequestBody VentaResquestDto ventaResquestDto){

        System.out.println("Estamos CreateVenta Repositorio");
        System.out.println("Nro de venta: "+ventaResquestDto.getNroVenta()+"//");
        System.out.println("Cant  de venta: "+ventaResquestDto.getCantidadVenta()+"//");
        System.out.println("Precio dolar CCL: "+ventaResquestDto.getPrecioVentaD()+"//");
        System.out.println("Precio Ars: "+ventaResquestDto.getPrecioVentaP()+"//");
         System.out.println("Deferencia dolar "+ventaResquestDto.getDifVentaCompraD()+"//");
         System.out.println("Diferencia Ars: "+ventaResquestDto.getDifVentaCompraP()+"//");
    try {
        return ResponseEntity.status(HttpStatus.CREATED).body(iVentaService.createVenta(ventaResquestDto));
    }catch(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<VentaResponseDto>> getAllVenta(){
        return ResponseEntity.status(HttpStatus.OK).body(iVentaService.getAllVenta());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getIdVenta(@PathVariable Long id) {
        try{
             return ResponseEntity.status(HttpStatus.OK)
                      .body(iVentaService.getVentaDtoById(id));
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVenta(@PathVariable Long id, @RequestBody VentaResquestDto ventaRequestDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(iVentaService.updateVenta(id,ventaRequestDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteVentaById(@PathVariable Long id) {
        try {
            iVentaService.deleteVenta(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(messageSource.getMessage("venta.delete.successful", null, Locale.getDefault()));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
