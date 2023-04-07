package com.example.demo.repository;

import com.example.demo.entity.Manufacturer;
import com.example.demo.entity.Product;
import com.example.demo.factory.EmFactory;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ProductRepo implements GenericRepo<Product, String> {
    private final EntityManager entityManager;

    public ProductRepo() {
        this.entityManager = EmFactory.getInstance().getEmf().createEntityManager();
    }


    @Override
    public Product create(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Manufacturer manufacturer = entityManager.find(Manufacturer.class, product.getManufacturer().getManId());
            if (manufacturer == null) {
                entityManager.persist(product.getManufacturer());
            } else {
                entityManager.merge(product.getManufacturer());
            }
            entityManager.persist(product);
            transaction.commit();

            return product;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }

    }

    @Override
    public Product getOne(String s) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, s);
            transaction.commit();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }

    @Override
    public Product update(Product product) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(product);
            transaction.commit();
            return product;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
    }

    @Override
    public boolean delete(String s) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Product product = entityManager.find(Product.class, s);
            entityManager.remove(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    @Override
    public List<Product> getAll() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<Product> products = entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
            transaction.commit();
            return products;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return null;
    }
}
