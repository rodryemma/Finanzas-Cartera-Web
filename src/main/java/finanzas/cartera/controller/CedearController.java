package finanzas.cartera.controller;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.dto.response.PPCCedearResponseDto;
import finanzas.cartera.dto.resquest.PPCCedearRequestDto;
import finanzas.cartera.service.Interface.ICedear;
import finanzas.cartera.service.Interface.ICompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cedears")
public class CedearController {
    private final ICompra iCompraService;
    private final ICedear IcedearService;
    private final ProjectionFactory projectionFactory;
    private final MessageSource messageSource;

    @Autowired
    public CedearController(ICompra iCompraService,ICedear IcedearService, ProjectionFactory projectionFactory, MessageSource messageSource){
        this.iCompraService = iCompraService;
        this.IcedearService = IcedearService;
        this.projectionFactory = projectionFactory;
        this.messageSource = messageSource;
    }

    @GetMapping
    public String getAllCedear(Model model) {
        List<CedearResponseDto> CedearResponseDto = IcedearService.getAllCedear();


        List<PPCCedearRequestDto> PPCArs = new ArrayList<>();


        for(finanzas.cartera.dto.response.CedearResponseDto i : CedearResponseDto){
            PPCCedearRequestDto ppcCedearRequestDto = new PPCCedearRequestDto(i.getId(),iCompraService.getCompraAvgArs(i.getId()));
            PPCArs.add(ppcCedearRequestDto);
        }


        model.addAttribute("titulo", "Lista de Cedears");
        model.addAttribute("CedearResponseDto", CedearResponseDto);

        model.addAttribute("PPCARSCedear",PPCArs);
        return "listCedear";
    }
}
