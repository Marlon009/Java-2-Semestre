package restaurant.com.restaurante.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.text.DecimalFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.com.restaurante.entities.PedidoEntity;
import restaurant.com.restaurante.entities.PratoEntity;
import restaurant.com.restaurante.repository.PedidoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/pedidos")
public class PedidosController {

  @Autowired
  PedidoRepository pedidoRepository;

  DecimalFormat decimalFormat = new DecimalFormat("0.00");

  @Operation(
    summary = "Retorna todos os pedidos",
    description = "Retorna todos os pedidos que possuem no sistema"
  )
  @GetMapping
  public List<PedidoEntity> buscarTodosOsPedidos() {
    return pedidoRepository.findAll();
  }

  @Operation(
    summary = "Retorna um pedido",
    description = "Retorna um pedido pelo seu id"
  )
  @Parameter(name = "id", description = "Id do pedido", required = true)
  @GetMapping("/{id}")
  public PedidoEntity buscarUmPedido(@PathVariable int id) {
    return pedidoRepository.findById(id).get();
  }

  @Operation(
    summary = "Cria um novo pedido",
    description = "Cria um novo pedido no sistema"
  )
  @Parameter(
    name = "pratos",
    description = "Pratos a serem pedidos",
    required = true
  )
  @PostMapping
  public PedidoEntity criarPedido(@RequestBody List<PratoEntity> pratos) {
    double valorTotal = 0;

    for (PratoEntity prato : pratos) {
      valorTotal += prato.getPreco();
    }

    PedidoEntity pedido = new PedidoEntity();
    pedido.setPratos(pratos);
    pedido.setValorTotal(valorTotal);
    double valorEntrega = valorTotal * 0.01;
    String valorEntregaFormatado = decimalFormat.format(valorEntrega);
    valorEntregaFormatado = valorEntregaFormatado.replace(",", ".");
    pedido.setValorEntrega(Double.parseDouble(valorEntregaFormatado));

    return pedidoRepository.save(pedido);
  }

  @Operation(
    summary = "Atualiza um pedido",
    description = "Atualiza um pedido no sistema"
  )
  @Parameter(name = "id", description = "Id do pedido", required = true)
  @PutMapping("/{id}")
  public PedidoEntity atualizarPedido(
    @PathVariable int id,
    @RequestBody PedidoEntity pedido
  ) {
    PedidoEntity pedidoAtual = pedidoRepository.findById(id).get();

    pedidoAtual.setPratos(pedido.getPratos());
    pedidoAtual.setValorTotal(pedido.getValorTotal());
    pedidoAtual.setValorEntrega(pedido.getValorEntrega());

    return pedidoRepository.save(pedidoAtual);
  }

  @Operation(
    summary = "Deleta um pedido",
    description = "Deleta um pedido no sistema"
  )
  @DeleteMapping("/{id}")
  public String deletarPedido(@PathVariable int id) {
    pedidoRepository.deleteById(id);
    return "Pedido deletado";
  }
}
