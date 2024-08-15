package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        @RequestParam(name = "buscar", defaultValue = "")String buscar,
        @RequestParam(name = "categoryFilter", required = false) String categoryFilter,
        @RequestParam(name = "typeFilter", required = false) String typeFilter){
        System.out.println();
        System.out.println("****************************************");
        System.out.println("categoryFilter: " + categoryFilter);
        System.out.println("typeFilter: " + typeFilter);
        System.out.println("****************************************");
        model.addAttribute("titulo", "Categorías de Incidentes");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("categoria", new TicketCategory());
        model.addAttribute("categorias", categoryRepository.getAll());
        model.addAttribute(
            "getCategoryFiltered",
            categoryRepository.getCategoryFiltered(
                new FilterCategory(
                    categoryFilter,
                    typeFilter
                )
            ));
        return "categorias";
    }

    @PostMapping("/crearCategoria")
    public String crearCategoria(@ModelAttribute TicketCategory categoria) {
        // System.out.println("****************************************************************");
        // System.out.println(categoria);
        // System.out.println("****************************************************************");
        categoryRepository.save(categoria);
        if(categoria.getId() > 0){
            mensaje = "Se registró la categoria: id: "+ categoria.getId() +" | "+ categoria.getCategory() +" | "+ categoria.getType();
        } else {
            mensaje = "Hubo un error al guardar la categoria";
        }
        return "redirect:categorias";
    }

    @PostMapping("/categorias/delete/{categoryId}")
    public String deleteCategory(@PathVariable Integer categoryId) {
        if (categoryId != null) {
            // categoryRepository.remove(categoryId);
            mensaje = "Eliminado: " + categoryRepository.getById(categoryId).toString();
        }
        return "redirect:/categorias";
    }
}
