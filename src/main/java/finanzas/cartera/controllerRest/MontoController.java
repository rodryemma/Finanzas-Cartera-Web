package finanzas.cartera.controllerRest;

import finanzas.cartera.dto.response.MontoResponseDto;
import finanzas.cartera.dto.resquest.MontoResquestDto;
import finanzas.cartera.service.Interface.IMonto;
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


    @GetMapping
    public ResponseEntity<List<MontoResponseDto>> getAllMonto() {
        return ResponseEntity.status(HttpStatus.OK).body(iMontoService.getAllMonto());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMonto(@PathVariable Long id, @RequestBody MontoResquestDto montoRequestDto) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(iMontoService.updateMonto(id,montoRequestDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteMontoById(@PathVariable Long id) {
        try {
            iMontoService.deleteMonto(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(messageSource.getMessage("monto.delete.successful", null, Locale.getDefault()));
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
