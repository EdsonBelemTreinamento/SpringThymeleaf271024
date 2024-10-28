package br.com.arq.respository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.arq.model.Produto;

@Service
public class ProdutoDao extends Dao {

	public List<Produto> getAllProdutos() throws SQLException {
		List<Produto> produtos = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		open();
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getDouble("preco"));
				produtos.add(produto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
 
		}
		return produtos;
	}

	public Produto create(Produto produto) throws SQLException {
		String sql = "insert into produto values (?,?,?,?)";
		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, produto.getIdProduto());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getPreco() );
			stmt.executeUpdate();
			stmt.close();
			return produto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
 
		}
	}

	public Produto update(Produto produto) throws SQLException {
		String sql = "UPDATE produto SET nome = ?, preco = ?, descricao = ? WHERE idProduto = ?";
		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setDouble(2, produto.getPreco());
			stmt.setString(3, produto.getDescricao());
			stmt.setInt(4, produto.getIdProduto());
			stmt.executeUpdate();
			return produto;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
	 
		}
	}

	public Produto findById(int id) throws SQLException {
		String sql = "SELECT * FROM produto WHERE idProduto = ?";
		Produto produto = null;
		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				produto = new Produto();
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setNome(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getDouble("preco"));
			
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
 
		}
		return produto;
	}

	public boolean delete(int id) throws SQLException {
		String sql = "DELETE FROM produto WHERE idProduto = ?";
		try {
			open();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {
	 
		}
	}

}
