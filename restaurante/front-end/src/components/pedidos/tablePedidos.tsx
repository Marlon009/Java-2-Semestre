"use client";
import { TableBody, TableCell, TableRow } from "../ui/table";
import { api } from "@/services/api";
import { useQuery } from "@tanstack/react-query";
import { ActionPedido } from "./actionPedido";

interface PratoProps {
  id: number;
  nome: string;
  preco: number;
}

interface PedidoProps {
  id: number;
  pratos: PratoProps[];
  valorTotal: number;
}

export const TablePedidos = () => {
  const getPedidos = async () => {
    const response: { data: PedidoProps[] } = await api.get("/pedidos");

    return response.data;
  };

  const { data } = useQuery({
    queryKey: ["pedidos"],
    queryFn: getPedidos,
  });

  return (
    <TableBody>
      {data?.map((pedido: PedidoProps) => (
        <TableRow key={pedido.id}>
          <TableCell>{pedido.id}</TableCell>
          <TableCell>{pedido.pratos[0].nome}</TableCell>
          <TableCell>R$ {pedido.valorTotal.toFixed(2)}</TableCell>
          <TableCell className="flex gap-2">
            <ActionPedido pedido={pedido} />
          </TableCell>
        </TableRow>
      ))}
    </TableBody>
  );
};
