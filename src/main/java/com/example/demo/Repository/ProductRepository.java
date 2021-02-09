package com.example.demo.Repository;

import com.example.demo.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    @Autowired
    JdbcTemplate template;

    @Override
    public void create(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?,?)";
        template.update(sql, product.getName(), product.getPrice());
    }

    @Override
    public List<Product> readAll() {
        String sql = "SELECT * FROM products";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public Product getProduct(long productid) {
        String sql = "SELECT * FROM products WHERE productid=?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);
        return template.queryForObject(sql, rowMapper, productid);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name=?, price=? WHERE productid=?";
        template.update(sql, product.getName(), product.getPrice(), product.getProductid());
    }

    @Override
    public void delete(long productid) {
        String sql = "DELETE FROM products WHERE productid=?";
        template.update(sql, productid);
    }
}
