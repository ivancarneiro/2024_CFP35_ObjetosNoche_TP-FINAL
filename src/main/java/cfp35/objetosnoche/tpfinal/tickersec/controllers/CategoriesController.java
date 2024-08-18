package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.entities.FilterCategory;
import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategory;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategoryRepository;


@Controller
public class CategoriesController {
    
    private String mensaje = "";
    private final TicketCategoryRepository categoryRepository = new TicketCategoryRepository();

    @GetMapping("/categorias")
    public String getCategorias(Model model,
        @RequestParam(defaultValue = "")String buscar,
        @RequestParam(required = false) String categoryFilter,
        @RequestParam(required = false) String typeFilter){
        model.addAttribute("titulo", "Categorías de Incidentes");
        model.addAttribute("buscarPlaceholder", "buscar en la descripción de la categoria");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("categoria", new TicketCategory());
        model.addAttribute("categorias", categoryRepository.getAll());
        model.addAttribute(
            "getCategoryFiltered",
            categoryRepository.getCategoryFiltered(
                new FilterCategory(
                    buscar,
                    categoryFilter,
                    typeFilter
                )
            ));
        return "categorias";
    }

    @PostMapping("/crearCategoria")
    public String crearCategoria(@ModelAttribute TicketCategory categoria) {
        categoryRepository.save(categoria);
        if(categoria.getId() > 0){
            mensaje = "Se registró la categoria: id: "+ categoria.getId() +" | "+ categoria.getCategory() +" | "+ categoria.getType();
        } else {
            mensaje = "Hubo un error al guardar la categoria";
        }
        return "redirect:categorias";
    }

    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(defaultValue="0", required = false) int categoryId) {
        if (categoryRepository.getAll().contains(categoryRepository.getById(categoryId))) {
            mensaje = "Se eliminó la caegoría: " + categoryId +" "+ categoryRepository.getById(categoryId).getCategory() +" - "+ categoryRepository.getById(categoryId).getType();
            categoryRepository.removeCategory(categoryRepository.getById(categoryId));
        } else {
            mensaje = "No se encontró la caegoría para eliminar con id: " + categoryId;
        }
        return "redirect:/categorias";
    }
}
