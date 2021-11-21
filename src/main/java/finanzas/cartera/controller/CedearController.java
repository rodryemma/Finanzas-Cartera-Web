package finanzas.cartera.controller;

import finanzas.cartera.dto.response.CedearResponseDto;
import finanzas.cartera.service.Interface.ICedear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cedears")
public class CedearController {
    private final ICedear IcedearService;
    private final ProjectionFactory projectionFactory;
    private final MessageSource messageSource;

    @Autowired
    public CedearController(ICedear IcedearService, ProjectionFactory projectionFactory, MessageSource messageSource){
        this.IcedearService = IcedearService;
        this.projectionFactory = projectionFactory;
        this.messageSource = messageSource;
    }

    @GetMapping
    public String getAllCedear(Model model) {
        List<CedearResponseDto> CedearResponseDto = IcedearService.getAllCedear();
        model.addAttribute("titulo", "Lista de Cedears");
        model.addAttribute("CedearResponseDto", CedearResponseDto);
        return "listCedear";
    }
}
