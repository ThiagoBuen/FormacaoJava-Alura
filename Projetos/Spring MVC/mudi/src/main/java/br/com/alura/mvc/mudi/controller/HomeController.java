package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

		@GetMapping("/home")
		public String home(Model model) {
			
			Pedido pedido = new Pedido();
			pedido.setNome("Nintendo Switch");
			pedido.setUrlImagem("https://assets.nintendo.com/image/upload/b_white,c_pad,f_auto,h_382,q_auto,w_573/ncom/pt_BR/hardware/switch/nintendo-switch-new-package/gallery/image02?v=2022032809");
			pedido.setUrlProduto("https://www.nintendo.com/pt_BR/switch/buy-now/");
			pedido.setDescricao("Descricao qualquer");
			
			List<Pedido> pedidos = Arrays.asList(pedido);
			model.addAttribute("pedidos", pedidos);
			
			return "home";
		}
}
