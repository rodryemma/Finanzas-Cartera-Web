package finanzas.cartera.service.impl;

import finanzas.cartera.dto.response.CompraResponseDto;
import finanzas.cartera.dto.resquest.CompraResquestDto;
import finanzas.cartera.model.Compra;
import finanzas.cartera.repository.CompraRepository;
import finanzas.cartera.service.Interface.ICompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class CompraServiceImpl implements ICompra {

    private final ProjectionFactory projectionFactory;
    private final CompraRepository compraRepository;
    private final MessageSource messageSource;

    @Autowired
    public CompraServiceImpl(ProjectionFactory projectionFactory,CompraRepository compraRepository,MessageSource messageSource){
    this.projectionFactory = projectionFactory;
    this.compraRepository = compraRepository;
    this.messageSource = messageSource;
    }

   @Override
    public CompraResponseDto createCompra(CompraResquestDto compraResquestDto) {
        Compra compra= Compra.builder()
                .nroCompra(compraResquestDto.getNroCompra())
                .cantidadCompra(compraResquestDto.getCantidadCompra())
                .precioCompraP(compraResquestDto.getPrecioCompraP())
                .precioCompraD(compraResquestDto.getPrecioCompraD())
                .created(new Date())
                .build();
        Compra compraCreated = compraRepository.save(compra);
        return projectionFactory.createProjection(CompraResponseDto.class, compraRepository.save(compraCreated));
    }

    @Override
    public CompraResponseDto updateCompra(Long id, CompraResquestDto compraDto) {

     Compra compra = getCompraById(id);

     if(compraDto.getNroCompra() != null)
        	compra.setNroCompra(compraDto.getNroCompra());
     if(compraDto.getCantidadCompra() != null)
        	compra.setCantidadCompra(compraDto.getCantidadCompra());
     if(compraDto.getPrecioCompraP() != null)
            compra.setPrecioCompraP(compraDto.getPrecioCompraP());
     if(compraDto.getPrecioCompraD() != null)
            compra.setPrecioCompraD(compraDto.getPrecioCompraD());
     compra.setEdited(new Date());
      return projectionFactory.createProjection(CompraResponseDto.class, compraRepository.save(compra));
    }

    @Override
    public List<CompraResponseDto> getAllCompra() {
        return compraRepository.findAllProjectedBy();
    }

    @Override
    public String deleteCompra(Long id) {

    Compra compra = getCompraById(id);
          compraRepository.delete(compra);

          return messageSource.getMessage(
                  "compra.delete.successful", null, Locale.getDefault()
            );


    }

    @Override
    public Compra getCompraById(Long id) {
         return compraRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        messageSource.getMessage("compra.error.not.found", null, Locale.getDefault())
                )
        );

    }

    @Override
    public CompraResponseDto getCompraDtoById(Long id) {
        return projectionFactory.createProjection(CompraResponseDto.class, compraRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        messageSource.getMessage("compra.error.not.found", null, Locale.getDefault())))
                );

    }

    @Override
    public Double getCompraAvgArs(Long idCedear) {
        return compraRepository.findCompraArsAvgById(idCedear);
    }

    @Override
    public Double getCompraMontoArs(Long idCedear) {
        return compraRepository.findCompraArsSumById(idCedear);
    }

    @Override
    public Long getCompraCantidad(Long idCedear) {
        return compraRepository.findCompraCantidadById(idCedear);
    }

}
