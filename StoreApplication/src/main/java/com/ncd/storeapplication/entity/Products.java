package com.ncd.storeapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "products_id", nullable = false)
    private int productsId;
    @Basic
    @Column(name = "title", nullable = true, length = 225)
    private String title;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "picture", nullable = false, length = 225)
    private String picture;
    @Basic
    @Column(name = "discount", nullable = true, precision = 0)
    private Double discount;
    @Basic
    @Column(name = "original_price", nullable = true, precision = 0)
    private Double originalPrice;
    @Basic
    @Column(name = "categories_id", nullable = false)
    private int categoriesId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productsId == products.productsId && Double.compare(price, products.price) == 0 && categoriesId == products.categoriesId && Objects.equals(title, products.title) && Objects.equals(picture, products.picture) && Objects.equals(discount, products.discount) && Objects.equals(originalPrice, products.originalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productsId, title, price, picture, discount, originalPrice, categoriesId);
    }
}
