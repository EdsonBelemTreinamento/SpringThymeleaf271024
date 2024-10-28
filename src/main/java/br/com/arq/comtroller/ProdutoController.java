	package br.com.arq.comtroller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	
	import br.com.arq.model.Produto;
	import br.com.arq.respository.ProdutoDao;
	
 
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
		
		    @Autowired
		    private ProdutoDao produtoDAO;
	
	 
		    @GetMapping("/novo")
		    public String showCreateForm(Model model) {
		        model.addAttribute("produto", new Produto());
		        return "produto-create";
		    }
	
	 
		    @PostMapping("/gravar")
		    public String createProduto(@ModelAttribute Produto produto,  Model model) {
		       try {
		        Produto resp = produtoDAO.create(produto);
		           model.addAttribute("produto", new Produto());
		           model.addAttribute("message", "Gravado Com Sucesso");
		         return "produto-create";
		       }catch(Exception ex) {  
		    	  model.addAttribute("message", "Error:" + ex.getMessage());
		           return "produto-create";
		       }
	 
		    }
	
		 
		    @GetMapping("/altera/{id}")
		    public String showEditForm(@PathVariable("id") int id, Model model) {
		    	try {
		        Produto produto = produtoDAO.findById(id);
		        if (produto==null) {
		        	throw new Exception("Produto nao Encontrado");
		        }
		        model.addAttribute("produto", produto);	        		
		        return "produto-update";
		    	}catch(Exception ex) {
		    		 model.addAttribute("message", "Error:" + ex.getMessage());
			         return "redirect:/produtos/listagem";
		    	}
		    }
	
	
		    @PostMapping("/alterar")
		    public String alterarProduto(@ModelAttribute Produto produto,  Model model) {
		       try {
		        Produto resp = produtoDAO.update(produto);
		           model.addAttribute("message", "Alterado Com Sucesso");
		         return "redirect:/produtos/listagem";
		       }catch(Exception ex) {  
		    	  model.addAttribute("message", "Error:" + ex.getMessage());
		           return "redirect:/produtos/listagem";
		       }
	 
		    }
	 
		    @GetMapping("/listagem")
		    public String listProdutos(Model model) {
		    	try {
		        List<Produto> produtos = produtoDAO.getAllProdutos();
		        if (produtos.size()>0) {
		         model.addAttribute("message", "existem produtos na lista");
		         model.addAttribute("produtos", produtos);
		        }else {
		        	throw new Exception("Produto nao Encontrado");
		        }
		        return "/produto-list";
		    	}catch(Exception ex) {
		    		 model.addAttribute("message", "não Existem produtos na lista");
		    		 return "/produto-list";
		    	}
		    }
	
	 
		    @GetMapping("/delete/{id}")
		    public String deleteProduto(@PathVariable("id") int id, Model model) {
		       try {
		      Boolean resp =produtoDAO.delete(id);
		    	if (resp) {
		    		 model.addAttribute("mensagem", "produto excluido");
		    		return "redirect:/produtos/listagem";
		    	   }else {
		    		throw new Exception("error");
		    	  }
		    	}catch(Exception ex) {
		    		 model.addAttribute("mensagem", "produto nao excluido");
		    		 return "redirect:/produtos/listagem";
		    	}
		    }
	  
		 
		
		
	}
