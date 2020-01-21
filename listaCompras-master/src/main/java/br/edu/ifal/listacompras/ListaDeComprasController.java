package br.edu.ifal.listacompras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaDeComprasController {

    @Autowired
    private ItemRepository repo;

    @RequestMapping("/")
    public String index() {
        return "index";

    }

    @RequestMapping("/listadecompras")
    public ModelAndView listaDeCompras() {
        ModelAndView mv = new ModelAndView("listacompras");
        mv.addObject("itens", repo.findAll());
        return mv;

    }

    @RequestMapping("/listacompras/cadastro")
    public ModelAndView cadastro(Item item) {
        ModelAndView mv = new ModelAndView("redirect:/listadecompras");
        repo.save(item);
        return mv;
        
    }
    @RequestMapping("/listacompras/excluir/{id}")
    public ModelAndView excluir(@PathVariable(name = "id") long id){
        ModelAndView mv = new ModelAndView("redirect:/listadecompras");
        repo.deleteById(id);
        return mv;

    }

}