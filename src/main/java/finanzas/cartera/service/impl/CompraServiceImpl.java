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

import java.util.Date;
import java.util.List;

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
    public CompraResponseDto updateCompra(Long id, CompraResquestDto CompraDto) {
        return null;
    }

    @Override
    public List<CompraResponseDto> getAllCompra() {
        return compraRepository.findAllProjectedBy();
    }

    @Override
    public void deleteCompra(Long id) {

    }

    @Override
    public Compra getCompraById(Long id) {
        return null;
    }

}
