package finanzas.cartera.service.impl;

import finanzas.cartera.dto.response.VentaResponseDto;
import finanzas.cartera.dto.resquest.VentaResquestDto;
import finanzas.cartera.model.Venta;
import finanzas.cartera.repository.VentaRepository;
import finanzas.cartera.service.Interface.IVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class VentaServiceImpl implements IVenta {

    private final ProjectionFactory projectionFactory;
    private final VentaRepository ventaRepository;
    private final MessageSource messageSource;

    @Autowired
    public VentaServiceImpl(ProjectionFactory projectionFactory,VentaRepository ventaRepository,MessageSource messageSource){
    this.projectionFactory = projectionFactory;
    this.ventaRepository = ventaRepository;
    this.messageSource = messageSource;
    }


    @Override
    public VentaResponseDto createVenta(VentaResquestDto ventaDto) {
        Venta venta = Venta.builder()
                .nroVenta(ventaDto.getNroVenta())
                .cantidadVenta(ventaDto.getCantidadVenta())
                .precioVentaD(ventaDto.getPrecioVentaD())
                .precioVentaP(ventaDto.getPrecioVentaP())
                .difVentaCompraD(ventaDto.getDifVentaCompraD())
                .difVentaCompraP(ventaDto.getDifVentaCompraP())
                .created(new Date())
                .build();

        Venta ventaCreated = ventaRepository.save(venta);
        return projectionFactory.createProjection(VentaResponseDto.class, ventaRepository.save(ventaCreated));
    }

    @Override
    public VentaResponseDto updateVenta(Long id, VentaResquestDto ventaDto) {

     Venta venta = getVentaById(id);

     if(ventaDto.getNroVenta() != null)
        	venta.setNroVenta(ventaDto.getNroVenta());

     if(ventaDto.getCantidadVenta() != null)
        	venta.setCantidadVenta(ventaDto.getCantidadVenta());

     if(ventaDto.getPrecioVentaP() != null)
            venta.setPrecioVentaP(ventaDto.getPrecioVentaP());

     if(ventaDto.getPrecioVentaD() != null)
            venta.setPrecioVentaD(ventaDto.getPrecioVentaD());

     if(ventaDto.getDifVentaCompraP() != null)
            venta.setDifVentaCompraP(ventaDto.getDifVentaCompraP());

     if(ventaDto.getDifVentaCompraD() != null)
            venta.setDifVentaCompraD(ventaDto.getDifVentaCompraD());

     venta.setEdited(new Date());
      return projectionFactory.createProjection(VentaResponseDto.class, ventaRepository.save(venta));
    }

    @Override
    public List<VentaResponseDto> getAllVenta() {
        return ventaRepository.findAllProjectedBy();
    }

    @Override
    public String deleteVenta(Long id) {
        Venta venta = getVentaById(id);
        ventaRepository.delete(venta);
        return messageSource.getMessage(
                "venta.delete.successful", null, Locale.getDefault()
        );
    }

    @Override
    public Venta getVentaById(Long id) {

        return ventaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        messageSource.getMessage("venta.error.not.found", null, Locale.getDefault())
                )
        );

    }
}
