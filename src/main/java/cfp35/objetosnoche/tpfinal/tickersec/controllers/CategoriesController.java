package cfp35.objetosnoche.tpfinal.tickersec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cfp35.objetosnoche.tpfinal.tickersec.entities.TicketCategory;
import cfp35.objetosnoche.tpfinal.tickersec.repositories.TicketCategoryRepository;


@Controller
public class CategoriesController {
    
    private String mensaje = "Mensaje de CategoriesController";
    private final TicketCategoryRepository categoryRepository = new TicketCategoryRepository();

    @GetMapping("/categorias")
    public String getCategorias(Model model, @RequestParam(name = "buscar", defaultValue = "")String buscar) {
        System.out.println("****************************************************************");
        System.out.println(buscar);
        System.out.println("****************************************************************");

        model.addAttribute("titulo", "Categorías");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("categoria", new TicketCategory());
        // model.addAttribute("categorias", categoryRepository.getAll());
        model.addAttribute("getLikeType", categoryRepository.getLikeType(buscar));
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

    @PostMapping("/removeCategoria")
    public String removeCategoria(@RequestParam(name="idBorrar", defaultValue = "0", required = false) int idBorrar) {
        //System.out.println("******************************************************");
        //System.out.println("Se ejecuto el método borrar");
        //System.out.println(idBorrar);
        //System.out.println("******************************************************");
        categoryRepository.remove(idBorrar);
        return "redirect:cursos";
    }
}
